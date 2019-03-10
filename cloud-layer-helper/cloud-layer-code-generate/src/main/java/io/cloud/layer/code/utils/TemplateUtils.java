package io.cloud.layer.code.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * 模板文件默认存放在resources/index.ftl目录下
 * @author RippleChan
 * @date 2019-03-10 09:47
 */
public class TemplateUtils {

    private static final Configuration CONFIGURATION;

    static {
        CONFIGURATION = new Configuration(Configuration.VERSION_2_3_28);
        try {
            CONFIGURATION.setDirectoryForTemplateLoading(new File(TemplateUtils.class.getClassLoader().getResource("templates").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CONFIGURATION.setDefaultEncoding(StandardCharsets.UTF_8.name());
    }

    /**
     * 生成代码
     * @param templateFile 用于生成模板的ftl文件，默认存放在 resources/templates 目录下
     * @param dataModel 用于生成模板的数据
     * @param writer
     */
    public static void process(String templateFile, Object dataModel, Writer writer) {
        try {
            Template template = CONFIGURATION.getTemplate(templateFile);
            template.process(dataModel, writer);

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filePath
     */
    private static void makeDirs(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
