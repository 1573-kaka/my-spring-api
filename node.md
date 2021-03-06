## Spring框架概述
***
1、Spring是轻量级的javaEE框架

2、Spring可以解决企业应用开发的复杂性

3、Spring有两个核心部分：IOC和AOP
（1）IOC：控制反转，把创建对象过程交给Spring进行管理
（2）AOP：面向切面，不修改源代码进行功能增强

4、Spring特点
（1）方便解耦，简化开发
（2）AOP编程支持
（3）方便程序测试
（4）方便和其他框架进行整合
（5）方便进行事务操作
（6）降低API开发难度

## IOC容器
* IOC底层原理
* IOC接口（BeanFactory）
* IOC操作Bean管理（基于xml）
* IOC操作Bean管理（基于注解）

### IOC概念和原理
* 控制反转：把对象创建和对象之间的调用过程，交给Spring进行管理
* 使用IOC的目的：为了降低耦合度

### IOC底层原理
* xml解析、工厂模式、反射

### 画图理解IOC底层原理

#### 原始方式
> 耦合度太高

![img_2.png](img_2.png)

#### 工厂模式
>目的：降低耦合度

![img_1.png](img_1.png)

#### IOC过程
![img_3.png](img_3.png)

### IOC（接口）
1. IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
2. Spring提供IOC容器实现两种方式：（两个接口） 
    * BeanFactory:IOC容器基本实现，是Spring内部的使用接口，不提供给开发人员使用
      * 加载配置文件时不会创建对象，在获取对象（使用）才去创建对象
    * ApplicationContext:BeanFactory接口的子接口，提供更多更强大的功能，一般是开发人员进行使用
      * 加载配置文件时就会把配置文件中的进行创建
3. ApplicationContext接口实现类
![img_4.png](img_4.png)
   
### IOC操作Bean管理
#### 什么是bean管理类
* Bean管理指的是俩个操作
   1. Spring创建对象
   2. Spring注入属性
   
##### 使用无参构造进行注入

```xml
<!-- 通过无参进行注入，必须存在无参构造函数 -->
<bean id="user" class="com.imust.entity.user.User">
    <property name="name" value="李华"/>
    <property name="age" value="19"/>
</bean>
```
##### 使用有参构造进行注入

```xml
<!-- 通过有参进行注入 -->
<bean id="user1" class="com.imust.entity.user.User">
    <constructor-arg name="name" value="路飞"/>
    <constructor-arg name="age" value="19"/>
</bean>
```
##### 使用p名称空间注入
第一步 添加p名称空间在配置文件中
> xmlns:p="http://www.springframework.org/schema/p"

第二步 进行属性注入，在bean标签中进行操作

```xml

<bean id="user2" class="com.imust.entity.user.User" p:age="22" p:name="萨博">没有</bean>
```

#### IOC操作Bean管理（FactoryBean）
* Spring有两种类型bean，一种普通bean，另外一种工厂bean（FactoryBean）
    * 普通bean：在spring配置文件定义bean类型就是返回类型
    * 工厂bean：在spring配置文件定义类型可以和返回类型不一样

#### IOC操作Bean管理（Bean作用域）
1. 在Spring里面，设置创建bean实例是单实例还是多实例
2. 在Spring里面，默认情况下，bean是单实例对象
3. 如何设置单实例还是多实例
    1. 在spring配置文件bean标签里面有属性（scope）用于设置单实例还是多实例
    2. scope属性值
        * singleton（默认值）：表示是单实例对象
        * prototype：表示是多实例对象
    3. singleton和prototype区别
        * singleton单实例，prototype多实例
        * 设置scope值是singleton时候，加载spring配置文件时候就会创建单实例对象
          设置scope值是prototype时候，在调用getBean()方法时候创建多实例对象

#### IOC操作Bean管理（Bean生命周期）
1. 生命周期
    * 对象从创建到销毁的过程
    
2. bean生命周期
    * 通过构造器创建bean实例(无参构造)
        * 把bean的实例传递到bean后置处理器的方法
    * 为bean的属性设置值和对其他bean应用(调用set方法)
        * 把bean的实例传递到bean后置处理器的方法
    * 调用bean的初始化的方法(需要进行配置)
    * bean可以使用了(对象获取到了)
    * 当容器关闭的时候，调用bean的销毁的方法(需要进行配置销毁的方法)
    
3. 后置处理器

#### IOC操作Bean管理（xml自动装配）
1. 什么是自动装配
    * 根据指定装配规则(属性名称或者属性类型)，Spring自动将匹配的属性值进行注入

#### IOC操作bean管理(基于注解方式)
1. 什么是注解
    * 注解是代码特殊标记，格式：@注解名称(属性名称=属性值, 属性名称=属性值)
    * 使用注解，注解作用在类、方法和属性上面
    * 使用注解的目的：简化xml配置
    
2. Spring针对Bean管理中创建对象提供注解
    * @Component
    * @Service
    * @Controller
    * @Repository
    
    *上面四个注解功能是一样的，都可以用来创建bean实例
3. 基于注解方式实现对象的创建 
    * 第一步 引入依赖
    * 第二步 开启注解扫描
    * 创建类，在类上面添加创建对象注解
    
4. 开启注解扫描细节

5. 基于注解方式实现属性注入
    * @Autowired:根据属性类型进行自动装配
        * 第一步 把service和dao对象创建，在service和dao类上添加创建对象注解
        * 第二步 在service注入dao对象，在service类添加dao类型属性，在属性上面使用注解
    * @Qualifier:根据属性名称进行注入
    * @Resource:可以根据属性类型注入，也可以根据属性名称注入
    * @Value:注入普通类型属性

## AOP 

## JdbcTemplate

## 事务管理