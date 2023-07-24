package com.hhcc.modules.develop;


import com.hhcc.modules.develop.support.SpringCodeGenerator;

public class CodeGenerator {
    public static String CODE_NAME = "应用管理";
    public static String SERVICE_NAME = "blade-system";
    public static String PACKAGE_NAME = "org.springblade.system";
    public static String SYSTEM_NAME = "saber";
    public static String PACKAGE_WEB_DIR = "/Users/chill/Workspaces/product/Saber";
    public static String[] TABLE_PREFIX = new String[]{"blade_"};
    public static String[] INCLUDE_TABLES = new String[]{"blade_client"};
    public static String[] EXCLUDE_TABLES = new String[0];
    public static Boolean HAS_SUPER_ENTITY;
    public static String[] SUPER_ENTITY_COLUMNS;
    public static Boolean HAS_WRAPPER;

    public CodeGenerator() {
    }

    public static void run() {
        SpringCodeGenerator generator = new SpringCodeGenerator();
        generator.setCodeName(CODE_NAME);
        generator.setServiceName(SERVICE_NAME);
        generator.setSystemName(SYSTEM_NAME);
        generator.setPackageName(PACKAGE_NAME);
        generator.setPackageWebDir(PACKAGE_WEB_DIR);
        generator.setTablePrefix(TABLE_PREFIX);
        generator.setIncludeTables(INCLUDE_TABLES);
        generator.setExcludeTables(EXCLUDE_TABLES);
        generator.setHasSuperEntity(HAS_SUPER_ENTITY);
        generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        generator.setHasWrapper(HAS_WRAPPER);
        generator.run();
    }

    static {
        HAS_SUPER_ENTITY = Boolean.TRUE;
        SUPER_ENTITY_COLUMNS = new String[]{"id", "create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};
        HAS_WRAPPER = Boolean.TRUE;
    }
}
