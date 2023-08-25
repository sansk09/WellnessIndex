package com.example.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*


class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var result = intent.getDoubleExtra("BMI" ,0f.toDouble())
        //txt= findViewById(R.id.res)
       res.setText(Math.round(result).toString())
          //var r = result.toString().toInt()
       if (result  <=18) {
            txt_4.setText("UNDERWEIGHT")
            txt_5.setText("Tip: You should eat a bit more")
        }
        else if (result>=19 && result<=25 ){
            txt_4.setText("NORMAL")
            txt_5.setText("Tip: Your BMI is perfect. well done!")
        }
        else {
            txt_4.setText("OBESE")
            txt_5.setText("Tip: Exercise daily and reduce intake of fatty foods like sweets")
        }


        back.setOnClickListener {
           var intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}