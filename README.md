# spring cloud 服务注册端
注册端用于记录启动的应用，并且监视应用的状态
# 使用方法
## 配置
``` 
spring:
  application:
    name: eureka-center
eureka:
  instance:
    hostname: eureka3.hewe.vip
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://eureka1.hewe.vip:8081/eureka/,http://eureka2.hewe.vip:8082/eureka/
```
* spring.application.name 应用名称，用于描述和区分不同应用，同一个应用多个实例必须相同
* hostname: 主机名。
* register-with-eureka： 是否在eureka注册中心中中注册自己，这里为了高可用，需要注册
* fetch-registry： 是否在注册中心检索服务，高可用，需要检索其他副本
* service-url： 注册中心url，集群模式多个url使用逗号分割，可以指定多个注册中心，这里使用"defaultzone"
## 单机启动集群模式（在idea中启动）
* 关闭单应用模式(右上角-》edit configuration-》右上角-》Single instance only-》取消勾选)
* 编辑application.yml中 active: 为要启动的配置文件，比如要启动`application-peer1.yml`，就改为`peer1`
* 点击右上角运行
* 待起来后，再编辑application.yml文件开启下一个

## 测试

* 启动后，通过端口访问，会进入监控页面
# 服务提供者（一般应用）
通过在注册中心注册，实现被监控，和被发现
## 配置
* 打开一般的springboot应用
* 编写pom文件,添加如下
    ``` 
    <dependencies>
        <!-- Eureka 客户端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    ```
* 编辑application配置文件：
    ``` 
    spring:
      application:
        name: Hello-application
    
    eureka:
      client:
        serviceUrl:
          defaultZone: http://eureka1.hewe.vip:8081/eureka/,http://eureka2.hewe.vip:8082/eureka/,http://eureka3.hewe.vip:8083/eureka/
    ```
   * application.name : 用于区分不同的应用，相同的应用使用相同的名称
   * serviceUrl： 注册中心的地址，多个使用逗号分割
 ## 测试
 运行应用，打开注册中心的页面即可看到应用名称