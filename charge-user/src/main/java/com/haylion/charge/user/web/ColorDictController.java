package com.haylion.charge.user.web;

import com.haylion.common.entity.entity.ColorDict;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.charge.user.pojo.form.ColorDictForm;
import com.haylion.charge.user.service.ColorDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Slf4j
@RestController
@RequestMapping("/color")
@CrossOrigin
public class ColorDictController {

    @Autowired
    ColorDictService colorDictService;


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('color:insert')")
    public ColorDict add(@RequestBody @Validated(Add.class) ColorDictForm positionColorForm) {
        return colorDictService.add(positionColorForm);
    }

    @PreAuthorize("hasAuthority('color:delete')")
    @PostMapping("/delete")
    public void delete(@RequestBody @Validated(Delete.class) ColorDictForm positionColorForm) {
        colorDictService.delete(positionColorForm.getId());
    }

    @PreAuthorize("hasAuthority('color:update')")
    @PostMapping("/update")
    public void update(@RequestBody @Validated(Update.class) ColorDictForm positionColorForm) {
        colorDictService.update(positionColorForm);
    }

    @PreAuthorize("hasAuthority('color:info')")
    @GetMapping("/info")
    public ColorDict selectById(@RequestParam(value = "id", required = false) Integer id) {
        return colorDictService.getInfoById(id);
    }

    @PreAuthorize("hasAuthority('color:list')")
    @GetMapping("/list")
    public List<ColorDict> selectList(@RequestParam(value = "sourceType", required = false) Integer sourceType,
                                      @RequestParam(value = "name", required = false) String name) {
        return colorDictService.selectList(sourceType, name);
    }

}
