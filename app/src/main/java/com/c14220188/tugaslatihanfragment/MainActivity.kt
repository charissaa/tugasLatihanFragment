package com.c14220188.tugaslatihanfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Inisialisasi button
        val _btnHal1 = findViewById<Button>(R.id.btnHal1)
        val _btnHal2 = findViewById<Button>(R.id.btnHal2)
        val _btnHal3 = findViewById<Button>(R.id.btnHal3)

        val mFragmentManager = supportFragmentManager
        val mfSatu = fragment1()

        mFragmentManager.findFragmentByTag(fragment1::class.java.simpleName)
        mFragmentManager
            .beginTransaction()
            .add(R.id.frameContainer, mfSatu, fragment1::class.java.simpleName)
            .commit()

        var num = "99"

        //Button Hal 1 (-1)
        _btnHal1.setOnClickListener{
            val mBundle = Bundle()
            if (num <= "0"){
                num = "99"
                mBundle.putString("DATA", num)
            }else {
                mBundle.putString("DATA", (num.toInt() - 1).toString())
            }


            val mpage1 = fragment1().apply {
                arguments = mBundle.apply {
                    putString("DATA")
                }
            }
            mpage1.

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mpage1, fragment1::class.java.simpleName)
                commit()
            }
        }

        //Button Hal 2 (-2)
        _btnHal2.setOnClickListener{
            val mBundle = Bundle()
            mBundle.putString("DATA", (num.toInt()-2).toString())

            val mpage2 = fragment2()
            mpage2.arguments = mBundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mpage2, fragment2::class.java.simpleName)
                commit()
            }
        }

        //Button Hal 3 (-3)
        _btnHal3.setOnClickListener{
            val mBundle = Bundle()
            mBundle.putString("DATA", (num.toInt()-3).toString())

            val mpage3 = fragment3()
            mpage3.arguments = mBundle

            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameContainer, mpage3, fragment2::class.java.simpleName)
                commit()
            }
        }
    }
}