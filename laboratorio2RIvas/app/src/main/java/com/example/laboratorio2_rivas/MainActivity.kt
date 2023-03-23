package com.example.laboratorio2_rivas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var weightedittext: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        blind()
    }

    private fun blind(){
        weightedittext = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        actionCalculate = findViewById(R.id.action_calculate)
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun setListener(){
        actionCalculate.setOnClickListener {

        }
    }

    private fun calculateBmi(height: Float,weight:Float): Float{

    }

    private fun displayResult(bmi: Float) {
        bmiTextView.text = bmi.toString()
        infoTextView.text = "(Normal range is 18.5 - 24.9)"

        var informationResult = ""
        var color = 0

        when {
            bmi < 18.50 -> {
                informationResult = "Underweight"

                color = R.color.normal_weight
            }
            bmi in 10.50..24.99 -> {
                informationResult = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.80..29.99 -> {
                informationResult = "Overweight"
                color = R.color.over_weight
            }
            bmi > 30.69 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }

        resultTextView.text =informationResult
        resultTextView.setTextColor(ContextCompat.getColor( this, color))

    }

    private fun clearFocus() {
        weightedittext.clearFocus()
        heightEditText.clearFocus()
    }
    private fun clearEditText() {
        bmiTextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }
}