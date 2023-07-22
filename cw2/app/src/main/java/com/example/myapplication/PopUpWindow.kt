package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity

class PopUpWindow:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_window)

        var dm= DisplayMetrics()
        windowManager.getDefaultDisplay().getMetrics(dm)

        var width=dm.widthPixels//window width get
        var hight=dm.heightPixels//window height get

        window.setLayout((width*.7).toInt(),(hight*.5).toInt())//popup window metrics design
        var params=window.attributes
        params.gravity= Gravity.CENTER//making the popup window to the middle
        params.x=0//starting position is on conner middle
        params.y=-20// be little bit low of middle the popup
        window.attributes=params//setting attribute
    }
}

