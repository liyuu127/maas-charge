package com.haylion.charge.user.utils.convert;

import com.haylion.common.entity.entity.PositionT;
import com.haylion.charge.user.pojo.form.PositionForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyu
 * date 2021/1/13 15:01
 * description
 */
@Mapper
public interface PositionConvert {
    PositionConvert INSTANCE = Mappers.getMapper(PositionConvert.class);

    PositionT formToEntity(PositionForm positionForm);
}
