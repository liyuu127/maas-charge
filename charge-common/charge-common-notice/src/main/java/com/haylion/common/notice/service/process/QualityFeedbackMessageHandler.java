package com.haylion.common.notice.service.process;

import com.haylion.common.entity.entity.SiteNoticeSource;
import com.haylion.common.notice.constant.SiteNoticeConstant;
import com.haylion.common.notice.model.OrderNotice;
import com.haylion.common.notice.model.QualityFeedbackNotice;
import com.haylion.common.repository.mapper.SiteNoticeSourceMapper;
import com.haylion.common.repository.mapper.SiteNoticeUserMapper;
import com.haylion.common.repository.mapper.UserTMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2021/4/20 17:02
 */
@Component("feedbackNotice")
@Slf4j
public class QualityFeedbackMessageHandler extends AbstractSiteNoticeProcessHandler<QualityFeedbackNotice> {
    @Autowired
    SiteNoticeSourceMapper subSiteNoticeSourceMapper;
    @Autowired
    SiteNoticeUserMapper subSiteNoticeUserMapper;
    @Autowired
    UserTMapper userTMapper;

    @Override
    public void saveSiteNotice(QualityFeedbackNotice qualityFeedbackNotice) {
        SiteNoticeSource siteNoticeSource = convertSiteNoticeSource(qualityFeedbackNotice);
        subSiteNoticeSourceMapper.insertSelective(siteNoticeSource);
        String supplierCode = qualityFeedbackNotice.getSupplierCode();
        Set<Integer> userIdSet = userTMapper.selectIdsBySupplierCode(supplierCode);
        if(userIdSet != null && userIdSet.size() > 0){
            subSiteNoticeUserMapper.batchInsertByUserId(userIdSet, siteNoticeSource.getId(), SiteNoticeConstant.READ_STATE_UN_READ);
        }
    }
}
