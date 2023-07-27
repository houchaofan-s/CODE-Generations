package com.hhcc.modules.develop;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.hhcc.modules.common.utils.Func;
import com.hhcc.modules.common.utils.StringUtil;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Data
public class SpringCodeGenerator {

    private static final Logger log = LoggerFactory.getLogger(SpringCodeGenerator.class);
    private String systemName = "saber";
    private String codeName;
    private String serviceName = "blade-service";
    private String packageName = "org.springblade.test";
    private String packageEntityName;
    private String packageDir;
    private String packageWebDir;
    private String[] tablePrefix = new String[]{"blade_"};
    private String[] includeTables = new String[]{"blade_test"};
    private String[] excludeTables = new String[0];
    private Boolean hasSuperEntity;
    private Boolean hasWrapper;
    private Boolean hasServiceName;
    private String[] superEntityColumns;
    private String tenantColumn;
    private String driverName;
    private String url;
    private String username;
    private String password;

    public void run() {
        final String servicePackage = this.serviceName.split("-").length > 1 ? this.serviceName.split("-")[1] : this.serviceName;
        Map<String, Object> customMap = new HashMap(11);
        customMap.put("codeName", this.codeName);
        customMap.put("serviceName", this.serviceName);
        customMap.put("servicePackage", servicePackage);
        customMap.put("servicePackageLowerCase", servicePackage.toLowerCase());
        customMap.put("tenantColumn", this.tenantColumn);
        customMap.put("hasWrapper", this.hasWrapper);
        Map<String, String> customFile = new HashMap(15);
        customFile.put("menu.sql", "/templates/sql/menu.sql.vm");
        customFile.put("entityVO.java", "/templates/entityVO.java.vm");
        customFile.put("entityDTO.java", "/templates/entityDTO.java.vm");
        if (this.hasWrapper) {
            customFile.put("wrapper.java", "/templates/wrapper.java.vm");
        }

        FastAutoGenerator.create(this.url, this.username, this.password).globalConfig((builder) -> {
            builder.author("hhcc").dateType(DateType.TIME_PACK).enableSwagger().outputDir(this.getOutputDir()).disableOpenDir();
        }).packageConfig((builder) -> {
            builder.parent(this.packageName).controller("controller").entity("entity").service("service").serviceImpl("service.impl").mapper("mapper").xml("mapper");
        }).strategyConfig((builder) -> {
            builder.addTablePrefix(this.tablePrefix)
                    .addInclude(this.includeTables)
                    .addExclude(this.excludeTables)
                    .entityBuilder().naming(NamingStrategy.underline_to_camel).columnNaming(NamingStrategy.underline_to_camel)
                    .enableLombok()
                    .superClass(Func.toStr(this.packageEntityName, "com.hhcc.modules.common.core.mp.base.BaseEntity")).addSuperEntityColumns(this.superEntityColumns).enableFileOverride()
//                    .serviceBuilder().superServiceClass("com.hhcc.modules.common.utils.core.mp.base.BaseService").superServiceImplClass("com.hhcc.modules.common.utils.core.mp.base.BaseServiceImpl").formatServiceFileName("I%sService").formatServiceImplFileName("%sServiceImpl").enableFileOverride()
//                    .serviceBuilder().enableFileOverride()
                    .mapperBuilder().mapperAnnotation(Mapper.class).enableBaseResultMap().enableBaseColumnList().formatMapperFileName("%sMapper").formatXmlFileName("%sMapper").enableFileOverride()
//                    .controllerBuilder().superClass("com.hhcc.modules.common.utils.core.boot.ctrl.BladeController").formatFileName("%sController").enableRestStyle().enableHyphenStyle().enableFileOverride();
                    .controllerBuilder().enableFileOverride();

        }).templateConfig((builder) -> {
            builder.disable(new TemplateType[]{TemplateType.ENTITY}).entity("/templates/entity.java.vm").service("/templates/service.java.vm").serviceImpl("/templates/serviceImpl.java.vm").mapper("/templates/mapper.java.vm").xml("/templates/mapper.xml.vm").controller("/templates/controller.java.vm");
        }).injectionConfig((builder) -> {
            builder.beforeOutputFile((tableInfo, objectMap) -> {
                System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
            }).customMap(customMap).customFile(customFile);
        }).templateEngine(new VelocityTemplateEngine() {
            protected void outputCustomFile(List<CustomFile> customFiles, TableInfo tableInfo, Map<String, Object> objectMap) {
                String entityName = tableInfo.getEntityName();
                String entityNameLower = tableInfo.getEntityName().toLowerCase();
                customFiles.forEach((customFile) -> {
                    String key = customFile.getFileName();
                    String value = customFile.getTemplatePath();
                    String outputPath = this.getPathInfo(OutputFile.parent);
                    objectMap.put("entityKey", entityNameLower);
                    if (StringUtil.equals(key, "menu.sql")) {
                        objectMap.put("menuId", IdWorker.getId());
                        objectMap.put("addMenuId", IdWorker.getId());
                        objectMap.put("editMenuId", IdWorker.getId());
                        objectMap.put("removeMenuId", IdWorker.getId());
                        objectMap.put("viewMenuId", IdWorker.getId());
                        outputPath = SpringCodeGenerator.this.getOutputDir() + "/" + "sql" + "/" + entityNameLower + ".menu.sql";
                    }

                    if (StringUtil.equals(key, "entityVO.java")) {
                        outputPath = SpringCodeGenerator.this.getOutputDir() + "/" + SpringCodeGenerator.this.packageName.replace(".", "/") + "/" + "vo" + "/" + entityName + "VO" + ".java";
                    }

                    if (StringUtil.equals(key, "entityDTO.java")) {
                        outputPath = SpringCodeGenerator.this.getOutputDir() + "/" + SpringCodeGenerator.this.packageName.replace(".", "/") + "/" + "dto" + "/" + entityName + "DTO" + ".java";
                    }

                    if (StringUtil.equals(key, "wrapper.java")) {
                        outputPath = SpringCodeGenerator.this.getOutputDir() + "/" + SpringCodeGenerator.this.packageName.replace(".", "/") + "/" + "wrapper" + "/" + entityName + "Wrapper" + ".java";
                    }

                    this.outputFile(new File(String.valueOf(outputPath)), objectMap, value, Boolean.TRUE);
                });
            }
        }).execute();
    }

    private Properties getProperties() {
        Resource resource = new ClassPathResource("/templates/code.properties");
        Properties props = new Properties();

        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return props;
    }

    public String getOutputDir() {
        return (Func.isBlank(this.packageDir) ? System.getProperty("user.dir") + "/blade-ops/blade-develop" : this.packageDir) + "/src/main/java";
    }

    public String getOutputWebDir() {
        return (Func.isBlank(this.packageWebDir) ? System.getProperty("user.dir") : this.packageWebDir) + "/src";
    }

    public SpringCodeGenerator() {
        this.hasSuperEntity = Boolean.TRUE;
        this.hasWrapper = Boolean.TRUE;
        this.hasServiceName = Boolean.FALSE;
        this.superEntityColumns = new String[]{"create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};
        this.tenantColumn = "tenant_id";
    }

}
