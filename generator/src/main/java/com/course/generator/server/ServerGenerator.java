package com.course.generator.server;

import com.course.generator.util.FreeMarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EaApple
 * @6/8/2020 10:45 AM
 * description：
 */
public class ServerGenerator {

    static String MOUDLE = "business";
    static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    static String toControllerPath = MOUDLE+"\\src\\main\\java\\com\\course\\"+MOUDLE+"\\controller\\admin\\";
    public static void main(String[] args) throws IOException, TemplateException {

        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String moudle = MOUDLE;
        Map<String,Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn",tableNameCn);
        map.put("moudle",MOUDLE);


        //生成service
        // 配置输入
        FreeMarkerUtil.initConfig("service.ftl");
        //配置输出
        FreeMarkerUtil.generator(toServicePath+Domain+"Service.java",map);

        //生成controller
        FreeMarkerUtil.initConfig("controller.ftl");
        FreeMarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);
    }
}