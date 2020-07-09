# Sdk-PointCut
#Aop for android
1.ClickTrigger
 适用范围：需要防止重复点击的onItemClick和onItemClick方法上，并且方法参数中的第一个view是点击的view
 使用方法：
  项目根目录导入
        classpath 'org.aspectj:aspectjtools:1.8.13'
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.8'
  需要使用注解的module的build.gradle中:
        apply plugin: 'android-aspectjx'
        implementation project(':lib-aop')
  在需要防止重复点击的方法上增加标注
         @ClickTrigger
