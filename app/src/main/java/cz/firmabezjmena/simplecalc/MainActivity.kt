package cz.firmabezjmena.simplecalc

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val first = findViewById<EditText>(R.id.firstNumber)
        val second = findViewById<EditText>(R.id.secondNumber)
        val calculate = findViewById<Button>(R.id.calcIt)
        val operation = findViewById<Spinner>(R.id.operation)
        val result = findViewById<TextView>(R.id.result)

        val operationsArray = listOf("+", "-", "x", "/")
        operation.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, operationsArray)

        calculate.setOnClickListener {
            if (first.text.isNotEmpty() && second.text.isNotEmpty()) {
                val a = first.text.toString().toInt()
                val b = second.text.toString().toInt()
                val o = operation.selectedItem as String

                var c = ""
                when(o) {
                    "+" -> c = (a + b).toString()
                    "-" -> c = (a - b).toString()
                    "/" -> c = (a.toFloat() / b).toString()
                    "x" -> c = (a.toFloat() * b).toString()
                }
                result.text = c
            } else {
              val dialog = AlertDialog.Builder(this).setView(R.layout.warning_dialog).create()

                dialog.show()

          }

        }

    }

}
