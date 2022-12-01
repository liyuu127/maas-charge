package com.haylion.charge.system.service;

import com.alibaba.fastjson.JSONObject;
import com.haylion.charge.system.model.form.DictItemAddForm;
import com.haylion.charge.system.model.form.DictItemDeleteForm;
import com.haylion.charge.system.model.form.DictItemUpdateForm;
import com.haylion.common.entity.entity.DictItemT;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 14:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DictItemServiceTest {
    @Autowired
    private DictItemService dictItemService;

    @Test
    public void testAddDictItem(){
        DictItemAddForm dictItemAddForm = new DictItemAddForm();
        dictItemAddForm.setName("中华人名共和国");
        dictItemService.addDictItem(dictItemAddForm);
    }

    @Test
    public void testAddDictItemForSecondLevel(){
        DictItemAddForm dictItemAddForm = new DictItemAddForm();
        dictItemAddForm.setParentId(41);
        dictItemAddForm.setName("海南省");
        dictItemService.addDictItem(dictItemAddForm);
    }

    @Test
    public void testAddDictItemForThirdLevel() throws IOException {
        DictItemAddForm dictItemAddForm = new DictItemAddForm();
        dictItemAddForm.setParentId(42);
        dictItemAddForm.setName("佛山市");
        DictItemT hscDictItemT = dictItemService.addDictItem(dictItemAddForm);
        log.info(new ObjectMapper().writeValueAsString(hscDictItemT));
    }

    @Test
    public void testGetListByParent(){
        List<DictItemT> hscDictItemTS = dictItemService.getListByParent(40);
        log.info(JSONObject.toJSONString(hscDictItemTS));
    }

    @Test
    public void testUpdate(){
        DictItemUpdateForm dictItemUpdateForm = new DictItemUpdateForm();
        dictItemUpdateForm.setId(41);
        dictItemUpdateForm.setName("中华人名共和国[update]");
        dictItemService.updateDictItem(dictItemUpdateForm);
    }

    @Test
    public void testDeleteDictItem(){
        DictItemDeleteForm dictItemDeleteForm = new DictItemDeleteForm();
        dictItemDeleteForm.setId(42);
        dictItemService.deleteDictItem(dictItemDeleteForm);
    }

    @Test
    public void testGetList() throws IOException {
        log.info(new ObjectMapper().writeValueAsString(dictItemService.getList(1,20,"海")));
    }
}
