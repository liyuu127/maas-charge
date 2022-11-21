package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.QualityFeedbackFileDto;
import com.haylion.common.entity.entity.ScmQualityFeedbackFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScmQualityFeedbackFileMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ScmQualityFeedbackFile record);

    int insertSelective(ScmQualityFeedbackFile record);

    ScmQualityFeedbackFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmQualityFeedbackFile record);

    int updateByPrimaryKey(ScmQualityFeedbackFile record);

    int insertList(@Param("qualityFeedbackFileDtoList") List<QualityFeedbackFileDto> qualityFeedbackFileDtoList);
}