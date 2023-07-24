package com.hhcc.modules;

import com.hhcc.modules.develop.support.SpringCodeGenerator;

/**
 * 代码生成器
 *
 * @author Chill
 */
public class CodeGeneratorTest {

	/**
	 * 驱动类
	 */
	public static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	/**
	 * 连接地址
	 */
	public static String URL = "jdbc:mysql://localhost:3306/blade?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true";
	/**
	 * 用户名
	 */
	public static String USER_NAME = "test";
	/**
	 * 密码
	 */
	public static String PASSWORD = "test";
	/**
	 * 代码生成的模块名
	 */

	public static String CODE_NAME = "自定义模块";
	/**
	 * 代码所在服务名
	 */
	public static String SERVICE_NAME = "blade-test";
	/**
	 * 代码生成的包名
	 */
	public static String PACKAGE_NAME = "com.hhcc.modules.test";
	/**
	 * 代码生成实体类基类的包名
	 */
	public static String ENTITY_NAME = "";
	/**
	 * 后端路径
	 */
	public static String API_PATH = "D:\\test\\CODE-Generations\\CODE-Generations";


	/**
	 * 前端代码生成所属系统
	 */
	public static String SYSTEM_NAME = "sword";
	/**
	 * 前端代码生成地址
	 */
	public static String PACKAGE_WEB_DIR = "/Users/chill/Workspaces/product/Sword";
	/**
	 * 需要去掉的表前缀
	 */
	public static String[] TABLE_PREFIX = {"blade_"};
	/**
	 * 需要生成的表名(两者只能取其一)
	 */
	public static String[] INCLUDE_TABLES = {"blade_test"};
	/**
	 * 需要排除的表名(两者只能取其一)
	 */
	public static String[] EXCLUDE_TABLES = {};
	/**
	 * 是否包含基础业务字段
	 */
	public static Boolean HAS_SUPER_ENTITY = Boolean.TRUE;
	/**
	 * 基础业务字段
	 */
	public static String[] SUPER_ENTITY_COLUMNS = {"create_time", "create_user", "update_time", "update_user", "status", "is_deleted"};

	/**
	 * RUN THIS
	 */
	public static void main(String[] args) {

		SpringCodeGenerator generator = new SpringCodeGenerator();
		// 设置数据源
		generator.setDriverName(DRIVER_CLASS);
		generator.setUrl(URL);
		generator.setUsername(USER_NAME);
		generator.setPassword(PASSWORD);
		// 设置基础配置
		generator.setCodeName(CODE_NAME);
		generator.setServiceName(SERVICE_NAME);
		generator.setPackageName(PACKAGE_NAME);
		generator.setPackageDir(API_PATH);
		generator.setTablePrefix(TABLE_PREFIX);
		generator.setIncludeTables(INCLUDE_TABLES);
		generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
		generator.setHasSuperEntity(false);
//		generator.setPackageEntityName("");
		generator.run();

	}

}
