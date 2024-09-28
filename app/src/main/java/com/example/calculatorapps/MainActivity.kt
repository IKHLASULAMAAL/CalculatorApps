package com.example.calculatorapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var pendingOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onDigitClick(view: View) {
        val button = view as android.widget.Button
        val value = button.text.toString()
        val currentText = resultTextView.text.toString()

        if (currentText == "0") {
            resultTextView.text = value
        } else {
            resultTextView.text = currentText + value
        }
    }

    fun onOperatorClick(view: View) {
        val button = view as android.widget.Button
        val operator = button.text.toString()

        operand1 = resultTextView.text.toString().toDouble()
        pendingOperation = operator
        resultTextView.text = "0"
    }

    fun onEqualClick(view: View) {
        val operand2 = resultTextView.text.toString().toDouble()

        val result = when (pendingOperation) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }

        resultTextView.text = result.toString()
    }
}
