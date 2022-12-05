package com.bdqn;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestFreemaker {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration=new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(
                new File("E:\\363itripbackend\\itripauth\\src\\main\\resources"));
        Template template=configuration.getTemplate("a.flt");
        Map map=new HashMap();
        map.put("aa","Java 代码设置的值");
        template.process(map,new FileWriter("E:\\new.html"));
    }
}
