package com.haylion.charge.system.service;

import com.haylion.charge.system.model.form.SysInternationalizationAddForm;
import com.haylion.charge.system.model.form.SysInternationalizationDeleteForm;
import com.haylion.charge.system.model.form.SysInternationalizationEditForm;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/5/5 16:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SysInternationalizationServiceTest {
    @Autowired
    private SysInternationalizationService sysInternationalizationService;

    @Test
    public void testGetList() throws IOException {
        log.info(new ObjectMapper().writeValueAsString(sysInternationalizationService.getList(1,20,null,null)));
    }

    @Test
    public void testAddSysInternationalization(){
        SysInternationalizationAddForm sysInternationalizationAddForm = new SysInternationalizationAddForm();
        sysInternationalizationAddForm.setCode("TEST");
        sysInternationalizationAddForm.setValue("测试");
        sysInternationalizationService.addSysInternationalization(sysInternationalizationAddForm);
    }

    @Test
    public void testEditSysInternationalization(){
        SysInternationalizationEditForm sysInternationalizationEditForm = new SysInternationalizationEditForm();
        sysInternationalizationEditForm.setId(40);
        sysInternationalizationEditForm.setCode("Health.Stagecoach.Business.CameraAlreadyExist");
        sysInternationalizationEditForm.setStatus(0);
        sysInternationalizationService.editSysInternationalization(sysInternationalizationEditForm);
    }

    @Test
    public void  testDeleteSysInternationalization(){
        SysInternationalizationDeleteForm sysInternationalizationDeleteForm = new SysInternationalizationDeleteForm();
        sysInternationalizationDeleteForm.setId(null);
        sysInternationalizationService.deleteSysInternationalization(sysInternationalizationDeleteForm);
    }
}
