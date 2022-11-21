package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.entity.dto.PositionDto;
import com.haylion.common.entity.dto.PositionInfoDto;
import com.haylion.common.entity.entity.PositionT;
import com.haylion.common.repository.mapper.PositionTMapper;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.pojo.form.PositionForm;
import com.haylion.charge.user.utils.convert.PositionConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/12 15:50
 * description
 */
@Service
public class PositionService {
    @Autowired
    PositionTMapper positionTMapper;
    @Autowired
    UserService userService;

    public PageInfo<PositionDto> selectList(String name, Integer cId, Integer dId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(positionTMapper.selectList(name, dId, cId));
    }

    public PositionInfoDto info(Integer id) {
        return positionTMapper.selectInfo(id);
    }

    public void add(PositionForm positionForm) {
        var positionT = positionTMapper.selectByNameAndDId(positionForm.getName(), positionForm.getDId());
        if (positionT != null) {
            throw new ApplicationException(RetStubDetail.POSITION_NAME_EXIST_ERROR);
        }
        positionT = PositionConvert.INSTANCE.formToEntity(positionForm);
        positionT.setCreateBy(SecurityUtil.getUsername());
        positionT.setCreateTime(LocalDateTime.now());
        positionTMapper.insertSelective(positionT);
    }

    public void update(PositionForm positionForm) {
        PositionT positionT = null;
        if (positionForm.getName() != null) {
            positionT = positionTMapper.selectByNameAndDId(positionForm.getName(), positionForm.getDId());
        }
        if (positionT != null && !positionT.getId().equals(positionForm.getId())) {
            throw new ApplicationException(RetStubDetail.POSITION_NAME_EXIST_ERROR);
        }
        positionT = PositionConvert.INSTANCE.formToEntity(positionForm);
        positionT.setUpdateBy(SecurityUtil.getUsername());
        positionT.setUpdateTime(LocalDateTime.now());
        positionTMapper.updateByPrimaryKeySelective(positionT);
    }

    public void delete(PositionForm positionForm) {
        if (userService.selectUserExitByPId(positionForm.getId())) {
            throw new ApplicationException(RetStubDetail.POSITION_ON_USER_NOT_NULL);
        }
        var positionT = new PositionT();
        positionT.setId(positionForm.getId());
        positionT.setDeleted(CommonConstant.DELETED_YES);
        positionTMapper.updateByPrimaryKeySelective(positionT);
    }

    public Boolean selectPositionExitByDId(Integer dId) {
        return positionTMapper.selectPositionExitByDId(dId);
    }

    public List<PositionDto> listAll(String name, Integer dId) {
        return positionTMapper.selectList(name, dId, null);
    }
}
