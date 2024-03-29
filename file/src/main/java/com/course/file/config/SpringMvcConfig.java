package com.course.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    @Value("${file.path}")
    private String FILE_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/f/**").addResourceLocations("file:" + FILE_PATH);
    }
}
//     http://127.0.0.1:9000/file/file:E:/springcloud/springcloud_vue/teacher/JnPabZqM.jpg

    //http://127.0.0.1:9003/file/f/teacher/iLDjSWFo-p1.jpg
