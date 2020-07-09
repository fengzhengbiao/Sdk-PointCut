package com.leopard.aop

import android.os.SystemClock
import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
import androidx.core.util.getOrElse

object AopClickUtil {
    /**
     * 最近一次点击的时间
     */
    private val clickRecord = SparseArray<Long>()

    /**
     * 是否是快速点击
     *
     * @param intervalMillis  时间间期（毫秒）
     * @return  true:是，false:不是
     */
    fun isFastDoubleClick(@IdRes viewId: Int, intervalMillis: Long = 1200): Boolean {
        val time = SystemClock.elapsedRealtime()
        val mLastClickTime = clickRecord.getOrElse(viewId) { 0 }
        val timeInterval = Math.abs(time - mLastClickTime)
        return if (timeInterval < intervalMillis) {
            true
        } else {
            clickRecord.put(viewId, time)
            false
        }
    }
}