package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.FeedbackInfoDto;
import com.haylion.common.entity.dto.QualityFeedbackDto;
import com.haylion.common.entity.dto.QualityFeedbackFileDto;
import com.haylion.common.entity.dto.order.OrderMaterialDto;
import com.haylion.common.entity.entity.ScmQualityFeedback;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ScmQualityFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmQualityFeedback record);

    int insertSelective(ScmQualityFeedback record);

    ScmQualityFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmQualityFeedback record);

    int updateByPrimaryKey(ScmQualityFeedback record);

    List<QualityFeedbackDto> selectFeedbackList(@Param("supplierCode") String supplierCode, @Param("purchaseCode") String purchaseCode,
                                                @Param("materialName") String materialName, @Param("materialCode") String materialCode,
                                                @Param("feedbackTimeStart") LocalDateTime feedbackTimeStart, @Param("feedbackTimeEnd") LocalDateTime feedbackTimeEnd);

    QualityFeedbackDto selectFeedbackInfo(@Param("supplierCode")String supplierCode, @Param("orderMaterialId") Integer orderMaterialId,
                                          @Param("feedbackTimeStart") LocalDateTime feedbackTimeStart, @Param("feedbackTimeEnd") LocalDateTime feedbackTimeEnd);

    List<FeedbackInfoDto> selectFeedbackListByMaterial(@Param("orderMaterialId") Integer orderMaterialId,
                                                       @Param("feedbackTimeStart") LocalDateTime feedbackTimeStart, @Param("feedbackTimeEnd") LocalDateTime feedbackTimeEnd);

    Map<String,Integer> count(@Param("field") String field, @Param("supplierCode")String supplierCode,
                              @Param("feedbackTimeStart") LocalDateTime feedbackTimeStart, @Param("feedbackTimeEnd") LocalDateTime feedbackTimeEnd,
                              @Param("feedbackDate")LocalDate feedbackDate);

    int insertList(@Param("qualityFeedbackFileDtoList") List<QualityFeedbackFileDto> qualityFeedbackFileDtoList);

    List<OrderMaterialDto> selectNeedWarningMaterialByIds(@Param("list")List<QualityFeedbackFileDto> list);
}