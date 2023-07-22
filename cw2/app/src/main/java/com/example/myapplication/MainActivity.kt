package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow


class MainActivity : AppCompatActivity() {
    private lateinit var aboutBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aboutBtn= findViewById<Button>(R.id.aboutBtn)
        var newGameBtn= findViewById<Button>(R.id.newGameBtn)

        aboutBtn.setOnClickListener {
            openPopUpWindow()
        }
        newGameBtn.setOnClickListener {
            var gameWindow = Intent(this@MainActivity, GameWindow::class.java)
            startActivity(gameWindow)

        }
    }

    fun openPopUpWindow(){
        val popupView =layoutInflater.inflate(R.layout.activity_popup_window,null)
        val popUpWindow=PopupWindow(
            popupView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popUpWindow.showAtLocation(aboutBtn,Gravity.CENTER,0,0)
    }
}