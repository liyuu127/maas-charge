package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.ColorDict;
import com.haylion.charge.user.pojo.form.ColorDictForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface ColorDictConvert {
    ColorDictConvert INSTANCE = Mappers.getMapper(ColorDictConvert.class);

    ColorDict formToEntity(ColorDictForm colorDictForm);

}
