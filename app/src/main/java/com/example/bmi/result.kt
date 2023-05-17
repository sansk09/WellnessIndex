package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Result : AppCompatActivity() {
    lateinit var txt : TextView
    lateinit var txt4 : TextView
    lateinit var txt5 : TextView
    lateinit var button : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
       txt4= findViewById(R.id.txt_4)
        txt5=findViewById(R.id.txt_5)
        button= findViewById(R.id.back)
        var result = intent.getDoubleExtra("BMI" ,0f.toDouble())
        txt= findViewById(R.id.res)
       txt.setText(Math.round(result).toString())
          //var r = result.toString().toInt()
       if (result  <=18) {
            txt4.setText("UNDERWEIGHT")
            txt5.setText("Tip: You should eat a bit more")
        }
        else if (result>=19 && result<=25 ){
            txt4.setText("NORMAL")
            txt5.setText("Tip: Your BMI is perfect. well done!")
        }
        else {
            txt4.setText("OBESE")
            txt5.setText("Tip: Exercise daily and reduce intake of fatty foods like sweets")
        }


        button.setOnClickListener {
           var intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}