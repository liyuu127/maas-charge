package com.haylion.charge.system.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * date 2022/10/25 10:18
 * description
 */
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // 先将原先支持的MediaType列表拷出
        List<MediaType> mediaTypeList = new ArrayList<>(mappingJackson2HttpMessageConverter.getSupportedMediaTypes());
        //加入对text/html
        mediaTypeList.add(new MediaType("text", "html", StandardCharsets.UTF_8));
        //将已经加入了text/json的MediaType支持列表设置为其支持的媒体类型列表
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
    }
}
