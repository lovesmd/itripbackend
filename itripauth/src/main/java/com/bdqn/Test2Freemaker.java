package com.bdqn;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2Freemaker {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration
                configuration=new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(
                new File("E:\\363itripbackend\\itripauth\\src\\main\\resources"));
        Template template=configuration.getTemplate("b.flt");
        List<Userpojo> list=new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            Userpojo pojo=new Userpojo();
            pojo.setId(i);
            pojo.setName("姓名"+i);
            list.add(pojo);
        }
        Map map=new HashMap();
        map.put("ll",list);
        template.process(map,new FileWriter("E:\\new.txt"));
    }
}
