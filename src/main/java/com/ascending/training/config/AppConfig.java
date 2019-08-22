package com.ascending.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.ascending.training")
public class AppConfig {

    private final Logger logger = LoggerFactory.getLogger(AppConfig.class);

//    @Bean(name = "shareProperties")
//    public PropertiesFactoryBean getShareProperties() {
//        logger.debug("I am in the share properties");
//        PorpertiesFactoryBean bean = new PropertiesFactoryBean();
//        bean.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
//        return bean;
//    }
}
