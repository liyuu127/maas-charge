package com.haylion.charge.gateway.config;

import com.haylion.charge.gateway.handler.JsonErrorWebExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname CustomErrorWebFluxAutoConfiguration
 */
//@Configuration
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
//@ConditionalOnClass(WebFluxConfigurer.class)
//@AutoConfigureBefore(WebFluxAutoConfiguration.class)
//@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
@Configuration
@EnableConfigurationProperties({ServerProperties.class})

public class CustomErrorWebFluxAutoConfiguration {

    private final ServerProperties serverProperties;

    private final ApplicationContext applicationContext;

    private final WebProperties.Resources resourceProperties;

    private final List<ViewResolver> viewResolvers;

    private final ServerCodecConfigurer serverCodecConfigurer;

    public CustomErrorWebFluxAutoConfiguration(ServerProperties serverProperties,
                                               WebProperties.Resources resources,
                                               ObjectProvider<ViewResolver> viewResolversProvider,
                                               ServerCodecConfigurer serverCodecConfigurer,
                                               ApplicationContext applicationContext) {
        this.serverProperties = serverProperties;
        this.applicationContext = applicationContext;
        this.resourceProperties = resources;
        this.viewResolvers = viewResolversProvider.orderedStream()
                .collect(Collectors.toList());
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorWebExceptionHandler.class, search = SearchStrategy.CURRENT)
    @Order(-1)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes) {
        JsonErrorWebExceptionHandler exceptionHandler = new JsonErrorWebExceptionHandler(
                errorAttributes,
                resourceProperties,
                this.serverProperties.getError(),
                applicationContext);
        exceptionHandler.setViewResolvers(this.viewResolvers);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
    public DefaultErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes();
    }



}
