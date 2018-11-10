package me.albinmathew.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var operator: Operator = Operator.UNKNOWN

    private var valueOne: Int = -1
    private var valueTwo: Int = -1

    enum class Operator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, UNKNOWN
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button1.setOnClickListener { inputString.text = "${inputString.text}${button1.text}" }
        button2.setOnClickListener { inputString.text = "${inputString.text}${button2.text}" }
        button3.setOnClickListener { inputString.text = "${inputString.text}${button3.text}" }
        button4.setOnClickListener { inputString.text = "${inputString.text}${button4.text}" }
        button5.setOnClickListener { inputString.text = "${inputString.text}${button5.text}" }
        button6.setOnClickListener { inputString.text = "${inputString.text}${button6.text}" }
        button7.setOnClickListener { inputString.text = "${inputString.text}${button7.text}" }
        button8.setOnClickListener { inputString.text = "${inputString.text}${button8.text}" }
        button9.setOnClickListener { inputString.text = "${inputString.text}${button9.text}" }
        button0.setOnClickListener { inputString.text = "${inputString.text}${button0.text}" }

        buttonC.setOnClickListener {

            val currentText = inputString.text
            if (currentText.isNotEmpty()) {
                inputString.text = currentText.subSequence(0, currentText.length - 1)
            } else {
                clearAll()
            }
        }

        buttonA.setOnClickListener {
            operator = Operator.ADDITION
            compute()
            tvOperator.text = "+"
            inputString.text = ""
        }

        buttonS.setOnClickListener {
            operator = Operator.SUBTRACTION
            compute()
            tvOperator.text = "-"
            inputString.text = ""
        }

        buttonM.setOnClickListener {
            operator = Operator.MULTIPLICATION
            compute()
            inputString.text = ""
            tvOperator.text = "*"
        }

        buttonD.setOnClickListener {
            operator = Operator.DIVISION
            compute()
            inputString.text = ""
            tvOperator.text = "/"
        }

        buttonE.setOnClickListener {
            compute()
            operator = Operator.UNKNOWN
            valueOne = -1
            tvOperator.text = ""
        }

    }

    fun clearAll() {

        valueOne = -1
        valueTwo = -1
        inputString.text = ""
        tvOperator.text = "-"
    }


    private fun compute() {
        if (valueOne != -1) {
            val input = inputString.text.toString()
            if (!input.isBlank()) {
                valueTwo = input.toInt()
                inputString.text = ""
                when (operator) {
                    Operator.ADDITION -> inputString.text = calculate(valueOne, valueTwo, ::add).toString()
                    Operator.SUBTRACTION -> inputString.text = calculate(valueOne, valueTwo, ::sub).toString()
                    Operator.MULTIPLICATION -> inputString.text = calculate(valueOne, valueTwo, ::multiply).toString()
                    Operator.DIVISION -> inputString.text = calculate(valueOne, valueTwo) { a, b -> a divide b }.toString()
                    Operator.UNKNOWN -> inputString.text = ""
                }
                valueOne = -1
                valueTwo = -1
            }
        } else {
            val input = inputString.text.toString()
            if (!input.isBlank()) valueOne = input.toInt()
        }
    }

    private fun calculate(x: Int, y: Int, operator: (Int, Int) -> Any): Any {
        return operator(x, y)
    }

    fun add(a: Int, b: Int): Int = a + b

    fun sub(a: Int, b: Int): Int = a - b

    fun multiply(a: Int, b: Int) = a * b

    infix fun Int.divide(a: Int): Double = this / a.toDouble()

}
