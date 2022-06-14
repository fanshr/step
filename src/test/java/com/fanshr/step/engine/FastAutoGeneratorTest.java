package com.fanshr.step.engine;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/19 00:04
 * @date : Modified at 2022/4/19 00:04
 */
public class FastAutoGeneratorTest {






    @Test
    public void testQuestion(){
        //(1)第一步获取项目路径
        String projectPath=System.getProperty("user.dir");
        //（2）创建生产器
        FastAutoGenerator.create("jdbc:mysql://tanlang:3306/step?autoReconnect=true&useUnicode=true&characterEncoding=utf8&&serverTimezone=GMT%2B8", "root", "123456")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("LiuYJ")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)  //定义生成的实体类中日期类型
                            // 指定输出目录，注意可根据包修改，20211206!!!!
                            .outputDir(projectPath+"/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.fanshr.step.engine")        // 设置父包名,注意一定要根据包修改，20211206!!!!
                            .moduleName("question")     // 父包模块名，默认值:无，注意根据包修改，20211206!!!!
                            // 上面两行代码加起来:com.example.chenmptest.midProduct.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("serviceImpl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath+"/src/main/resources/mapper/question"));
                })

                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {


                    // 增加表匹配，需要映射的数据库中的表名
                    builder.addInclude("set_question","set_question_title","set_question_answer","map_graph_question","map_tag_question")
                            .addTablePrefix("set_","map_")                 // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            // .formatFileName("%sDto")
                            //.formatFileName("%sVo")
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库),注意修改，陈20211206！！！
                            .logicDeletePropertyName("delete")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型,如用不到，注意修改，陈20211206！！！
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


    /**
     * 认证鉴权 auth
     * 安全 security
     * 用户 user
     * 单点 sso
     */
    @Test
    public void testSecurity(){
        //

        //(1)第一步获取项目路径
        String projectPath=System.getProperty("user.dir");
        //（2）创建生产器
        FastAutoGenerator.create("jdbc:mysql://tanlang:3306/step?autoReconnect=true&useUnicode=true&characterEncoding=utf8&&serverTimezone=GMT%2B8", "root", "123456")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("LiuYJ")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)  //定义生成的实体类中日期类型
                            // 指定输出目录，注意可根据包修改，20211206!!!!
                            .outputDir(projectPath+"/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.fanshr.step.engine")        // 设置父包名,注意一定要根据包修改，20211206!!!!
                            .moduleName("security")     // 父包模块名，默认值:无，注意根据包修改，20211206!!!!
                            // 上面两行代码加起来:com.example.chenmptest.midProduct.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("serviceImpl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath+"/src/main/resources/mapper/security"));
                })
                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {

                    // 增加表匹配，需要映射的数据库中的表名
                    builder.addInclude("security_right_group","security_right_type","security_right","security_right_detail","security_role","security_user","security_account","map_role_right","map_role_user")
                            .addTablePrefix("security_","map_")                 // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            // .formatFileName("%sDto")
                            //.formatFileName("%sVo")
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库),注意修改，陈20211206！！！
                            .logicDeletePropertyName("delete")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型,如用不到，注意修改，陈20211206！！！
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


    /**
     * 国际化 i18n
     *
     * 本地化 locale
     */
    @Test
    public void testLocale(){
        //

        //(1)第一步获取项目路径
        String projectPath=System.getProperty("user.dir");
        //（2）创建生产器
        FastAutoGenerator.create("jdbc:mysql://tanlang:3306/step?autoReconnect=true&useUnicode=true&characterEncoding=utf8&&serverTimezone=GMT%2B8", "root", "123456")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("LiuYJ")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)  //定义生成的实体类中日期类型
                            // 指定输出目录，注意可根据包修改，20211206!!!!
                            .outputDir(projectPath+"/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.fanshr.step.engine")        // 设置父包名,注意一定要根据包修改，20211206!!!!
                            .moduleName("locale")     // 父包模块名，默认值:无，注意根据包修改，20211206!!!!
                            // 上面两行代码加起来:com.example.chenmptest.midProduct.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("serviceImpl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath+"/src/main/resources/mapper/locale"));
                })
                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {

                    // 增加表匹配，需要映射的数据库中的表名
                    builder.addInclude("locale_label","locale_note","locale_right","locale_tag")
                            // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // .addTablePrefix("sys_","set_","map_")
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            // .formatFileName("%sDto")
                            //.formatFileName("%sVo")
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库),注意修改，陈20211206！！！
                            .logicDeletePropertyName("delete")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型,如用不到，注意修改，陈20211206！！！
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();


    }


    /**
     * 核心
     */
    @Test
    public void testCore(){

        //
        //

        //(1)第一步获取项目路径
        String projectPath=System.getProperty("user.dir");
        //（2）创建生产器
        FastAutoGenerator.create("jdbc:mysql://tanlang:3306/step?autoReconnect=true&useUnicode=true&characterEncoding=utf8&&serverTimezone=GMT%2B8", "root", "123456")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("LiuYJ")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)  //定义生成的实体类中日期类型
                            // 指定输出目录，注意可根据包修改，20211206!!!!
                            .outputDir(projectPath+"/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.fanshr.step.engine")        // 设置父包名,注意一定要根据包修改，20211206!!!!
                            .moduleName("core")     // 父包模块名，默认值:无，注意根据包修改，20211206!!!!
                            // 上面两行代码加起来:com.example.chenmptest.midProduct.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("serviceImpl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath+"/src/main/resources/mapper/core"));
                })
                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {


                    // 增加表匹配，需要映射的数据库中的表名
                    builder.addInclude("core_language","core_locale","core_module","core_keyword","core_label","core_note","core_tag","core_tag_group","map_group_tag","map_graph_tag")
                            .addTablePrefix("core_","set_","map_")                 // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            // .formatFileName("%sDto")
                            //.formatFileName("%sVo")
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库),注意修改，陈20211206！！！
                            .logicDeletePropertyName("delete")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型,如用不到，注意修改，陈20211206！！！
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    /**
     * 通用
     */
    @Test
    public void testCommon(){

    }

    /**
     * 抽象
     */
    @Test
    public void testGeneral(){

    }

    /**
     * 表单建模
     */
    @Test
    public void testMode(){


        //(1)第一步获取项目路径
        String projectPath=System.getProperty("user.dir");
        //（2）创建生产器
        FastAutoGenerator.create("jdbc:mysql://tanlang:3306/step?autoReconnect=true&useUnicode=true&characterEncoding=utf8&&serverTimezone=GMT%2B8", "root", "123456")
                // 全局配置 GlobalConfig
                .globalConfig(builder -> {
                    builder.author("LiuYJ")   // 设置作者名
                            .fileOverride()  // 开启覆盖已生成文件，默认值false
                            .enableSwagger() // 开启 swagger 模式，默认值false
                            .dateType(DateType.ONLY_DATE)  //定义生成的实体类中日期类型
                            // 指定输出目录，注意可根据包修改，20211206!!!!
                            .outputDir(projectPath+"/src/main/java");
                })
                // 包配置 PackageConfig
                .packageConfig(builder -> {
                    builder.parent("com.fanshr.step.engine")        // 设置父包名,注意一定要根据包修改，20211206!!!!
                            .moduleName("mode")     // 父包模块名，默认值:无，注意根据包修改，20211206!!!!
                            // 上面两行代码加起来:com.example.chenmptest.midProduct.xxx(entity、service、controller等）
                            .entity("entity")       // Entity包名
                            .service("service")     // Service包名
                            .serviceImpl("serviceImpl") // ServiceImpl包名
                            .controller("controller")   // Controller包名
                            .mapper("mapper")           // Mapper包名
                            .xml("mapper")              // Mapper XML包名
                            // 路径配置信息，设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,projectPath+"/src/main/resources/mapper/mode"));
                })
                // 配置策略 StrategyConfig
                .strategyConfig(builder -> {


                    // 增加表匹配，需要映射的数据库中的表名
                    builder.addInclude("mode_field_type","mode_field","mode_browser","mode_browser_detail","mode_browser_config","mode_browser_module","mode_select","mode_select_option","mode_select_item","mode_form")
                            .addTablePrefix("mode_","set_","map_")                 // 增加过滤表前缀，生成时将数据库表的前缀"p_"去掉
                            // 1.service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")         // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            // 2.实体策略配置
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)  // 数据库表映射到实体的命名策略，下划线转驼峰命名
                            .enableLombok()                   // 开启 lombok 模型
                            // .formatFileName("%sDto")
                            //.formatFileName("%sVo")
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库),注意修改，陈20211206！！！
                            .logicDeletePropertyName("delete")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()     // 开启生成实体时生成字段注解
                            .idType(IdType.AUTO)              // 全局主键类型,如用不到，注意修改，陈20211206！！！
                            // 3.controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")   // 格式化文件名称
                            .enableRestStyle()                // 开启生成@RestController 控制器
                            // 4.mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)     // 设置父类
                            .enableMapperAnnotation()         // 开启 @Mapper 注解
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper");   // 格式化 xml 实现类文件名称
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


}