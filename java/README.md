# 聚合表单开放平台SDK

## 聚合表单平台是什么

## 如何启动

## 如何使用

使用`agg-client-sdk`中的`AggClient`类进行数据推送。

```xml

<dependencies>
  <dependency>
    <groupId>cn.haloop.intg</groupId>
    <artifactId>agg-client-sdk</artifactId>
    <version>1.0.0</version>
  </dependency>

  <!--如果使用jackson，需要引入以下依赖-->
  <dependency>
    <groupId>cn.haloop.intg</groupId>
    <artifactId>agg-serialization-jackson</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>

```

如推送方使用的是 spring-boot构建，可以引入 `agg-client-spring-boot-starter` 简化配置。 在 Starter 启动的时候会扫描，使用兼容的
JSON library 作为序列化工具。

```xml

<dependencies>
  <dependency>
    <groupId>cn.haloop.intg</groupId>
    <artifactId>agg-client-spring-boot-starter</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

在`agg-client-spring-boot-starter`中集成了`agg-serialization-spring-boot-starter`
，以自动配置序列化器，目前实现了`jackson`、`fastjson2`、`gson`的自动装配

```java

@Configuration
public class AggSerializerFactoryAutoConfiguration {

  @Bean
  @ConditionalOnClass(ObjectMapper.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory jackson() {
    return new AggJacksonSerializerFactory();
  }


  @Bean
  @ConditionalOnClass(JSON.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory fastJson() {
    return new AggFastJson2SerializerFactory();
  }

  @Bean
  @ConditionalOnClass(Gson.class)
  @ConditionalOnMissingBean(AggSerializerFactory.class)
  public AggSerializerFactory gson() {
    return new AggGsonSerializerFactory();
  }

}
```

示例参考项目`agg-client-demo`。是一个spring-boot应用程序，包含一个web页面，可用于测试线索的推送。

启动示例项目

方式一： 执行dev.sh一键打包构建docker镜像，通过docker-compose运行。

方式二：编译项目，本地运行

## 数据格式

## TODO

- [ ] 支持fastjson、gson序列化器