# CODE-Generations

[Maven 最新地址](https://central.sonatype.com/artifact/io.github.houchaofan-s/CODE-Generations)

```
<dependency>
  <groupId>io.github.houchaofan-s</groupId>
  <artifactId>CODE-Generations</artifactId>
  <version>1.0.5</version>
</dependency>
```



# 示例

```
SpringCodeGenerator generator = new SpringCodeGenerator();
// 设置数据源
generator.setDriverName("com.mysql.cj.jdbc.Driver");
generator.setUrl("jdbc:mysql://localhost:3306/blade?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true");
generator.setUsername("test");
generator.setPassword("test");
// 设置基础配置
//代码生成的模块名
generator.setCodeName("测试模块名");
//代码所在服务名
generator.setServiceName("测试代码所在服务名");
//代码生成的包名
generator.setPackageName("com.hhcc.modules.test");
//后端路径
generator.setPackageDir("D:\\test\\CODE-Generations\\CODE-Generations");
//需要去掉的表前缀
generator.setTablePrefix(new String[]{"hh_"});
//需要生成的表名
generator.setIncludeTables(new String[]{"hh_test"});
//基础业务字段
//generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
//generator.setHasSuperEntity(false);
//generator.setPackageEntityName("");
generator.run();
```
