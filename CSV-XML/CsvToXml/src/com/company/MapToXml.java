package com.company;

import freemarker.template.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class MapToXml {

    public static void main(String[] args) throws TemplateException {
    }

    static void createXml(Map<String, Contact> contacts)  throws IOException, TemplateException {

        ClassLoader classLoader = MapToXml.class.getClassLoader();
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Zeynep\\Desktop\\CsvToXml\\src"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map data = new HashMap();
        data.put("contacts", contacts.values());

        Template templete;
        templete = cfg.getTemplate("template.ftlh");

        BufferedWriter out;
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/output.xml"),
                "ISO-8859-9"));

        templete.process(data,out);
        out.flush();
        out.close();

        System.out.println("File Created");
    }
}

