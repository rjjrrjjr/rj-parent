package com.rj;

import java.util.ArrayList;
import java.util.HashMap;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by 10064028 on 2018/1/30.
 */
public class MPGenerator {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();  //模板引擎默认 Veloctiy
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("E://rj-parent/mybatis_plus/src/main/java/");
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false); //二级缓存
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setAuthor("rj");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert(){     //自定义数据库表字段类型转换
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型: " + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis_plus");

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //strategyConfig.setCapitalMode(true);全局大写命名 ORACLE 注意
        strategyConfig.setTablePrefix("t_");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);    //表名生成策略(下划线变驼峰)
        strategyConfig.setInclude("t_user");  //需要生成的表
        //strategyConfig.setExclude("t_user");    //排除生成的表
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");    // 自定义实体父类
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });   // 自定义实体，公共字段
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");    // 自定义 mapper 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");  // 自定义 service 父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");  // 自定义 service 实现类父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");    // 自定义 controller 父类
        // public static final String ID = "test_id";   // 【实体】是否生成字段常量（默认 false）
        // strategy.setEntityColumnConstant(true);
        // public User setName(String name) {this.name = name; return this;}    // 【实体】是否为构建者模型（默认 false）
        // strategy.setEntityBuilderModel(true);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.rj");
        packageConfig.setEntity("domain");
        packageConfig.setController("controller");
        //packageConfig.setModuleName("test");

        //注入自定义配置
        InjectionConfig injectionConfig = new InjectionConfig(){
            @Override
            public void initMap() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        ArrayList<FileOutConfig> focList = new ArrayList<>();       //自定义xxList.jsp生成
        focList.add(new FileOutConfig("/template/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "D://my_" + tableInfo.getEntityName() + ".jsp";  //自定义输入文件名称
            }
        });
        injectionConfig.setFileOutConfigList(focList);

        generator.setGlobalConfig(globalConfig);
        generator.setDataSource(dataSourceConfig);
        generator.setStrategy(strategyConfig);
        generator.setPackageInfo(packageConfig);
        //generator.setCfg(injectionConfig);

        generator.execute();

    }
}
