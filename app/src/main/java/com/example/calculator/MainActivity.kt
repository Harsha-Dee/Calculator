package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var digit_on_screen = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
    }

    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()
    }

    /**
     * This function initializes all of our numerical buttons from
     *  [0 - 9]
     */
    private fun numericalButtons() {

        one_btn.setOnClickListener {
            appendToDigitOnScreen("1")
        }

        two_btn.setOnClickListener {
            appendToDigitOnScreen("2")
        }

        three_btn.setOnClickListener {
            appendToDigitOnScreen("3")
        }

        four_btn.setOnClickListener {
            appendToDigitOnScreen("4")
        }

        five_btn.setOnClickListener {
            appendToDigitOnScreen("5")
        }

        six_btn.setOnClickListener {
            appendToDigitOnScreen("6")
        }

        seven_btn.setOnClickListener {
            appendToDigitOnScreen("7")
        }

        eight_btn.setOnClickListener {
            appendToDigitOnScreen("8")
        }

        nine_btn.setOnClickListener {
            appendToDigitOnScreen("9")
        }

        zero_btn.setOnClickListener {
            appendToDigitOnScreen("0")
        }

        dot_btn.setOnClickListener {
            appendToDigitOnScreen(".")
        }


    }

    /**
     *  Insert the button been clicked onto the screen so user can see
     *  inputs for the button clicked
     */
    private fun appendToDigitOnScreen(digit: String) {

        // Add each digit to our string builder
        digit_on_screen.append(digit)

        // display it on the screen of our mobile app
        result.text = digit_on_screen.toString()
    }

    /**
     *  Initialize the operation keys in our calculator like the
     *  addition key, subtraction key and the likes
     */
    private fun operationalButtons() {

        plus_btn.setOnClickListener {
            selectOperation('A')
        }

        minus_btn.setOnClickListener {
            selectOperation('B')
        }

        divide_btn.setOnClickListener {
            selectOperation('D')
        }

        multiply_btn.setOnClickListener {
            selectOperation('M')
        }

    }

    /**
     * Function to assign operational sign to our math calculations
     */
    private fun selectOperation(c: Char) {

        operation = c
        leftHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        result.text = "0"
    }

    /**
     * Handles functional operations in out application like
     * clear button, backspace button and the clear everything button
     */
    private fun functionalButtons() {

        clear_all.setOnClickListener {
            digit_on_screen.clear()
            result.text = "0"
        }

        clear_btn.setOnClickListener {
            clearDigit()
        }

        backspace_btn.setOnClickListener {
            clearDigit()
        }

        equal_btn.setOnClickListener {
            performMathOperation()
        }

    }


    /**
     *  This function performs our Math Operation which is then showed on the screen.
     */
    private fun performMathOperation() {

        rightHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()

        when (operation) {

            'A' -> {
                val sum = Helper.add(leftHandSide, rightHandSide)
                result.text = sum.toString()
                digit_on_screen.append(sum)
            }
            'S' -> {
                val subtract = Helper.subtract(leftHandSide, rightHandSide)
                result.text = subtract.toString()
                digit_on_screen.append(subtract)
            }
            'M' -> {
                val multiply = Helper.multiply(leftHandSide, rightHandSide)
                result.text = multiply.toString()
                digit_on_screen.append(multiply)
            }
            'D' -> {
                val divide = Helper.divide(leftHandSide, rightHandSide)
                result.text = divide.toString()
                digit_on_screen.append(divide)
            }

        }

    }

    /**
     *  This function remove the last digit on the screen.
     */
    private fun clearDigit() {

        val length = digit_on_screen.length

        digit_on_screen.deleteCharAt(length - 1)
        result.text = digit_on_screen.toString()

    }


}
