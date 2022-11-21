package com.haylion.charge.system.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.entity.dto.SiteNoticeDto;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.common.notice.service.SiteNoticeService;
import com.haylion.charge.system.model.form.NoticeIdsForm;
import com.haylion.charge.system.model.vo.CountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyu
 * date 2021/4/7 14:54
 * description
 */
@RestController
@RequestMapping("/notice")
public class SiteNoticeController {
    @Autowired
    SiteNoticeService siteNoticeService;

    @SysOperateLog(description = "查询消息列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('notice:select')")
    public PageInfo<SiteNoticeDto> list(@RequestParam(required = false) Integer states,
                                        @RequestParam(required = false) LocalDateTime startTime,
                                        @RequestParam(required = false) LocalDateTime endTime,
                                        @RequestParam(required = false) Integer[] sourceType,
                                        @RequestParam(required = false) Integer[] contentType,
                                        @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "20") Integer size) {
        Integer userId = SecurityUtil.getUser().getUserId();
        List<Integer> sourceTypeList = sourceType == null ? null : Arrays.asList(sourceType);
        List<Integer> contentTypeList = contentType == null ? null : Arrays.asList(contentType);
        return siteNoticeService.selectList(userId, states, sourceTypeList, contentTypeList, startTime, endTime, page, size);
    }

    @SysOperateLog(description = "查询消息数量")
    @GetMapping("/count")
    @PreAuthorize("hasAuthority('notice:select')")
    public CountVo count(@RequestParam(required = false) Integer states,
                         @RequestParam(required = false) LocalDateTime startTime,
                         @RequestParam(required = false) LocalDateTime endTime) {
        Integer userId = SecurityUtil.getUser().getUserId();
        long count = siteNoticeService.queryCount(userId, states, startTime, endTime);
        return new CountVo(count);
    }

    @PostMapping("/read")
    @PreAuthorize("hasAuthority('notice:read')")
    public void read(@RequestBody NoticeIdsForm noticeIdsForm) {
        siteNoticeService.read(noticeIdsForm.getNoticeUserIds());
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('notice:delete')")
    public void delete(@RequestBody NoticeIdsForm noticeIdsForm) {
        siteNoticeService.delete(noticeIdsForm.getNoticeUserIds());
    }

    @PostMapping("/readAll")
    @PreAuthorize("hasAuthority('notice:read')")
    public void readAll() {
        Integer userId = SecurityUtil.getUser().getUserId();
        siteNoticeService.readAll(userId);
    }
}
