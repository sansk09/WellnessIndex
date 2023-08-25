package com.example.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    var bmi : Int?=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var weight=70
        var age = 18


        plus_1.setOnClickListener {
                age++
                txt_2.text=age.toString()
        }

        plus_2.setOnClickListener {
            weight++
            txt_3.text=weight.toString()
        }

        minus_1.setOnClickListener {
            age--
            txt_2.text=age.toString()
        }

        minus_2.setOnClickListener {
            weight--
            txt_3.text=weight.toString()
        }

        var height = object : Slider.OnChangeListener{

            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                txt_1.setText(value.roundToInt().toString())
            }
        }
        seekBar.addOnChangeListener(height)


      calculate.setOnClickListener {
          var a=txt_3.text.toString().toFloat()
          //Log.e("TAG", "onCreate: ${txt1.toString()}" )

          var b =txt_1.text.toString().toFloat()
                   var bmi=(a/Math.pow(b.toDouble(),2f.toDouble()))*10000
            var intent = Intent(this , Result::class.java)
            intent.putExtra("BMI" ,bmi)
            startActivity(intent)
          finish()
        }

    }
}


