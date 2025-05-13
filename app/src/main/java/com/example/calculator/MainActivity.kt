package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnMulti : Button
    lateinit var btnSub : Button
    lateinit var btnDiv : Button

    lateinit var edit1 : EditText
    lateinit var edit2 : EditText

    lateinit var resultTv : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnMulti = findViewById(R.id.multiply)
        btnSub = findViewById(R.id.btn_subtraction)
        btnDiv = findViewById(R.id.divide)

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        resultTv = findViewById(R.id.result)

        btnAdd.setOnClickListener(this)
        btnMulti.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnDiv.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

    }

    override fun onClick(v: View?) {

        var a = edit1.text.toString().toDouble()
        var b = edit2.text.toString().toDouble()
        var result = 0.0


        when(v?.id){
            R.id.btn_add ->{
                result = a+b
            }
            R.id.btn_subtraction->{
                result = a-b
            }
            R.id.multiply ->{
                result = a*b
            }
            R.id.divide->{
                result = a/b
            }
       }

        resultTv.text ="Result is $result"
    }
}