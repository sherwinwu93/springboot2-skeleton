package com.wusd.skeleton;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.sql.Types;

/**
 * @author Wusd
 * @date 2025/7/10
 * @description
 */
public class CodeGenerator {
    private static final String URL = "jdbc:mysql://localhost:3306/order_db?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Wusd123..";
    private static final String[] TABLES = {"t_order", "t_student"};
    private static final String[] TABLE_PREFIXS = {"t_"};

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> builder
                        .author("Wusd")
                        .enableSwagger()
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.TINYINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> builder
                        .parent("com.wusd.skeleton")
                        .entity("entity.po")
                        .mapper("mapper")
                        .serviceImpl("service")
                        .xml("mapper")
                )
                .strategyConfig(builder -> builder
                        .addInclude(TABLES)
                        .addTablePrefix(TABLE_PREFIXS)

                        .entityBuilder()
                        .enableFileOverride()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .logicDeleteColumnName("del_flag")
                        .logicDeletePropertyName("delFlag")

                        .mapperBuilder()
                        .enableFileOverride()

                        .serviceBuilder()
                        .enableFileOverride()
                        .disableService()
                        .formatServiceImplFileName("%sService")

                        .controllerBuilder()
                        .disable()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
