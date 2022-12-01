package com.haylion.charge.system.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.charge.system.constant.RetStubDetail;
import com.haylion.charge.system.model.form.DictItemAddForm;
import com.haylion.charge.system.model.form.DictItemDeleteForm;
import com.haylion.charge.system.model.form.DictItemUpdateForm;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.entity.entity.DictItemT;
import com.haylion.common.repository.mapper.DictItemTMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 9:59
 */
@Service
@Slf4j
public class DictItemService {
    @Autowired
    private DictItemTMapper dictItemMapper;

    @Transactional(rollbackFor = Exception.class)
    public DictItemT addDictItem(DictItemAddForm dictItemAddForm) {
        int num = dictItemMapper.count();
        if (num <= 0) {
            initDictItemTree();
        }
        DictItemT hscDictItemT = assembleDictItem(dictItemAddForm);
        dictItemMapper.insertSelective(hscDictItemT);
        return hscDictItemT;
    }

    /**
     * 初始化区域树(增加唯一虚拟根节点root)
     */
    private void initDictItemTree() {
        DictItemT root = new DictItemT().setName("root")
                .setLeft(0)
                .setRight(1)
                .setLevel(0)
                .setCreateAt(LocalDateTime.now())
                .setCreateBy(SecurityUtil.getUsername());
        dictItemMapper.insertSelective(root);
    }

    private DictItemT assembleDictItem(DictItemAddForm dictItemAddForm) {
        Integer parentId = dictItemAddForm.getParentId();
        DictItemT parentDictItem = parentId == null ? dictItemMapper.getRootDictItem() :
                dictItemMapper.selectById(parentId);
        if (parentDictItem == null) {
            throw new ApplicationException(RetStubDetail.AREA_NOT_EXIST);
        }
        Integer parentRight = parentDictItem.getRight();
        dictItemMapper.updateLeftForAdd(parentRight);
        dictItemMapper.updateRightForAdd(parentRight);
        int left = parentRight;
        int right = left + 1;
        return new DictItemT().setName(dictItemAddForm.getName())
                .setLeft(left)
                .setRight(right)
                .setLevel(parentDictItem.getLevel() + 1)
                .setCreateAt(LocalDateTime.now())
                .setCreateBy(SecurityUtil.getUsername());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteDictItem(DictItemDeleteForm dictItemDeleteForm) {
        //是否要核验是否绑定有摄像头
        DictItemT hscDictItemT = dictItemMapper.selectById(dictItemDeleteForm.getId());
        if (hscDictItemT == null) {
            throw new ApplicationException(RetStubDetail.AREA_NOT_EXIST);
        }
        int left = hscDictItemT.getLeft();
        int right = hscDictItemT.getRight();
        //更新后续节点左右值
        dictItemMapper.updateLeftForDelete(left, right);
        dictItemMapper.updateRightForDelete(left, right);

        dictItemMapper.deleteSubTree(left, right, LocalDateTime.now(), SecurityUtil.getUsername());
    }

    public List<DictItemT> getListByParent(Integer parentId) {
        if (parentId == null) {
            return dictItemMapper.getDictItemByLevel(1);
        }
        DictItemT parentDictItem = dictItemMapper.selectById(parentId);
        if (parentDictItem == null) {
            throw new ApplicationException(RetStubDetail.AREA_NOT_EXIST);
        }
        return dictItemMapper.getDirectChildren(parentDictItem.getLeft(), parentDictItem.getRight(), parentDictItem.getLevel());
    }

//    public LocationView getParentDictItem(Integer parentId) {
//        DictItemT parentDictItem = parentId == null ? dictItemMapper.getRootDictItem() : dictItemMapper.selectById(parentId);
//        if (parentDictItem == null) {
//            throw new ApplicationException(RetStubDetail.AREA_NOT_EXIST);
//        }
//        return new LocationView().setPointId(parentDictItem.getId())
//                .setPointType(CameraConstant.LOCATION_OF_AREA)
//                .setPointName(parentDictItem.getName())
//                .setPointLeft(parentDictItem.getLeft())
//                .setPointRight(parentDictItem.getRight())
//                .setPointLevel(parentDictItem.getLevel());
//    }

    public void updateDictItem(DictItemUpdateForm dictItemUpdateForm) {
        DictItemT hscDictItemT = new DictItemT().setId(dictItemUpdateForm.getId())
                .setName(dictItemUpdateForm.getName())
                .setUpdateAt(LocalDateTime.now())
                .setUpdateBy(SecurityUtil.getUsername());
        dictItemMapper.updateByPrimaryKeySelective(hscDictItemT);
    }

    public PageInfo<DictItemT> getList(Integer page, Integer size, String name) {
        PageHelper.startPage(page, size);
        List<DictItemT> allDictItems = dictItemMapper.selectListByName(name);
        return new PageInfo<>(allDictItems);
    }
}
