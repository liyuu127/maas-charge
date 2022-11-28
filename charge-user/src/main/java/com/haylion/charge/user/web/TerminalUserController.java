package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.charge.user.pojo.vo.UserInfoVo;
import com.haylion.charge.user.service.TerminalUserService;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.common.repository.dto.TerminalUserListDto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyu
 * date 2022/11/25 9:54
 * description
 */
@RestController
@RequestMapping("/user/terminal/")
@AllArgsConstructor
public class TerminalUserController {

    private final TerminalUserService terminalUserService;

    @GetMapping("/list")
    @SysOperateLog(description = "查询人员列表")
    @PreAuthorize("hasAuthority('terminal:user:list')")
    public PageInfo<TerminalUserListDto> selectList(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "username", required = false) String username,
                                                    @RequestParam(value = "card", required = false) String card,
                                                    @RequestParam(value = "mobile", required = false) String mobile,
                                                    @RequestParam(value = "states", required = false) Integer[] states,
                                                    @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return terminalUserService.selectList(name, username, card, states, mobile, currentPage, pageSize);
    }

    /**
     * 查询人员详情
     *
     * @return
     */
    @SysOperateLog(description = "查询人员详情")
    @GetMapping("/info")
    @PreAuthorize("hasAuthority('terminal:user:select')")
    public UserInfoVo info(@RequestParam(value = "userId", required = false) Integer userId) {
        return terminalUserService.info(userId == null ? SecurityUtil.getUser().getUserId() : userId);
    }
}
