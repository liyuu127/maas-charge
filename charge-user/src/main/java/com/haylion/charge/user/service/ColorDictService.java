package com.haylion.charge.user.service;

import com.haylion.common.entity.entity.ColorDict;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.ColorDictMapper;
import com.haylion.charge.user.pojo.form.ColorDictForm;
import com.haylion.charge.user.utils.convert.ColorDictConvert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.haylion.charge.user.constant.RetStubDetail.COLOR_NAME_REPEAT;

/**
 * @author liyu
 * date 2021/8/23 15:19
 * description
 */
@Service
public class ColorDictService {
    @Autowired
    ColorDictMapper colorDictMapper;

    public ColorDict add(ColorDictForm colorDictForm) {
        if (colorDictMapper.selectNameExists(colorDictForm.getName(), colorDictForm.getSourceType())) {
            throw new ApplicationException(COLOR_NAME_REPEAT);
        }
        ColorDict colorDict = ColorDictConvert.INSTANCE.formToEntity(colorDictForm);
        colorDictMapper.insertSelective(colorDict);
        return colorDict;
    }

    public void delete(Integer id) {
        ColorDict subPositionColor = new ColorDict();
        subPositionColor.setId(id);
        subPositionColor.setDeleted(CommonConstant.DELETED_YES);
        colorDictMapper.updateByPrimaryKeySelective(subPositionColor);
    }

    public void update(ColorDictForm colorDictForm) {
        ColorDict colorDictOld = colorDictMapper.selectByPrimaryKey(colorDictForm.getId());
        Integer sourceType = colorDictForm.getSourceType() == null ? colorDictOld.getSourceType() : colorDictForm.getSourceType();
        String name = StringUtils.isBlank(colorDictForm.getName()) ? colorDictOld.getName() : colorDictForm.getName();
        ColorDict colorDictSelect = colorDictMapper.selectByNameAndSourceType(name, sourceType);
        if (colorDictSelect != null && !colorDictSelect.getId().equals(colorDictOld.getId())) {
            throw new ApplicationException(COLOR_NAME_REPEAT);
        }

        ColorDict colorDict = ColorDictConvert.INSTANCE.formToEntity(colorDictForm);
        colorDictMapper.updateByPrimaryKeySelective(colorDict);
    }

    public ColorDict getInfoById(Integer id) {
        return colorDictMapper.selectByPrimaryKey(id);
    }

    public List<ColorDict> selectList(Integer sourceType, String name) {
        return colorDictMapper.queryList(name, sourceType);
    }
}
