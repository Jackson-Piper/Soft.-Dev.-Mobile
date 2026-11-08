package au.edu.swin.sdmd.calctest

import android.icu.util.Output
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val number1 = findViewById<EditText>(R.id.numB1)
        val number2 = findViewById<EditText>(R.id.numB2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup3)
        val outPut = findViewById<TextView>(R.id.outPut)
        findViewById<TextView>(R.id.outPut).text

        val equals = findViewById<Button>(R.id.equalButt)
        equals.setOnClickListener {
            outPut.text = when (radioGroup.checkedRadioButtonId) {
                R.id.plusBut2 ->
                    add(number1.text.toString(), number2.text.toString())

                R.id.multButt ->
                    mult(number1.text.toString(), number2.text.toString())

                else -> {
                    ""
                }
            }

        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) =
        (number1.toInt() + number2.toInt()).toString()

    private fun mult(number1: String, number2: String) =
        (number1.toInt() * number2.toInt()).toString()

}