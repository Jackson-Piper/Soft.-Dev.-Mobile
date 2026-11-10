package au.edu.swin.sdmd.calctest

import android.icu.util.Output
import android.os.Bundle
import android.os.PersistableBundle
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
import androidx.lifecycle.Lifecycle

class MainActivity : AppCompatActivity() {

    var calc: String? = ""

    override fun onStop(){
        super.onStop()
        Log.i("LIFECYCLE", "STOP")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
          outState.putString("output",this.calc)
    }

    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE", "START")
    }

    override fun onResume(){
        super.onResume()
        Log.i("LIFECYCLE", "RESUME")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE", "PAUSE")
    }

    override fun onRestart(){
        super.onRestart()
        Log.i("LIFECYCLE", "RESTART")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("LIFECYCLE", "Destroy")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LIFECYCLE", "CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val number1 = findViewById<EditText>(R.id.numB1)
        val number2 = findViewById<EditText>(R.id.numB2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup3)
        val outPut = findViewById<TextView>(R.id.outPut)
        savedInstanceState?.run {
            calc = getString("output")?: ""
            findViewById<TextView>(R.id.outPut).text = calc
        }
        Log.i("LIFECYCLE", "restored calc = $calc")

        val equals = findViewById<Button>(R.id.equalButt)
        equals.setOnClickListener {
            calc = when (radioGroup.checkedRadioButtonId) {
                R.id.plusBut2 ->
                    add(number1.text.toString(), number2.text.toString())

                R.id.multButt ->
                    mult(number1.text.toString(), number2.text.toString())

                else -> {
                    ""
                }
            }
            outPut.text = calc

        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String) =
        (number1.toInt() + number2.toInt()).toString()

    private fun mult(number1: String, number2: String) =
        (number1.toInt() * number2.toInt()).toString()

}