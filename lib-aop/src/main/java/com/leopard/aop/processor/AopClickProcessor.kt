package com.leopard.aop

import android.util.Log
import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature


@Aspect
class AopClickProcessor {


    /**
     * 定义切点，标记切点为所有被@ClickTrigger注解的方法
     * 你自己项目中ClickTrigger这个类的全路径
     */


    @Pointcut("( @annotation(com.leopard.aop.ClickTrigger)  && ( execution(* onClick(*)) || execution(* onItemClick(..))))")
    fun viewClicked() {
    }


    @Around("viewClicked()")
    @Throws(Throwable::class)
    fun aroundJoinPoint(joinPoint: ProceedingJoinPoint) {
        Log.i("AopClickProcessor", "click")
        // 取出方法的注解
        val methodSignature = joinPoint.signature as MethodSignature
        val method = methodSignature.method
        if (method.isAnnotationPresent(ClickTrigger::class.java)) {
            val view = joinPoint.args.first { it is View } as View
            val aopOnclick = method.getAnnotation(ClickTrigger::class.java)
            if (aopOnclick == null) {
                joinPoint.proceed()
            } else {
                // 判断是否快速点击
                if (!AopClickUtil.isFastDoubleClick(view.id, aopOnclick.time)) {
                    // 不是快速点击，执行原方法
                    joinPoint.proceed()
                }
            }
        }


    }

}