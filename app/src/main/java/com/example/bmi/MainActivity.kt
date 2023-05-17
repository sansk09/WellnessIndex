package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var seekbaar : Slider
    lateinit var txt1 : TextView
    lateinit var txt2 : TextView
    lateinit var txt3 : TextView
    lateinit var plus2 : Button
    lateinit var plus1 : Button
    lateinit var minus1 : Button
    lateinit var minus2 : Button
    lateinit var calculate : Button
    var bmi : Int?=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate= findViewById(R.id.calculate)
        minus2=findViewById(R.id.minus_2)
        minus1=findViewById(R.id.minus_1)
         plus2 = findViewById(R.id.plus_2)
        plus1  = findViewById(R.id.plus_1)
         txt2 = findViewById(R.id.txt_2)
        txt3 = findViewById(R.id.txt_3)
        var weight=70
        var age = 18
        seekbaar=findViewById(R.id.seekBar)
        txt1=findViewById(R.id.txt_1)

        plus1.setOnClickListener {
                age++
                txt2.text=age.toString()
        }

        plus2.setOnClickListener {
            weight++
            txt3.text=weight.toString()
        }

        minus1.setOnClickListener {
            age--
            txt2.text=age.toString()
        }

        minus2.setOnClickListener {
            weight--
            txt3.text=weight.toString()
        }

        var height = object : Slider.OnChangeListener{

            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                txt1.setText(value.roundToInt().toString())
            }
        }
        seekbaar.addOnChangeListener(height)


      calculate.setOnClickListener {
          var a=txt3.text.toString().toFloat()
          //Log.e("TAG", "onCreate: ${txt1.toString()}" )

          var b =txt1.text.toString().toFloat()
                   var bmi=(a/Math.pow(b.toDouble(),2f.toDouble()))*10000
            var intent = Intent(this , Result::class.java)
            intent.putExtra("BMI" ,bmi)
            startActivity(intent)
          finish()
        }

    }
}


