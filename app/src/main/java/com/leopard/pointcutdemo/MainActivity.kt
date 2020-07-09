package com.leopard.pointcutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.leopard.aop.ClickTrigger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTest.setOnClickListener(this)
    }

    @ClickTrigger
    override fun onClick(v: View?) {
        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show()
    }
}