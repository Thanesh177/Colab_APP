package com.example.colaboftwoapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
        }

        val button: Button = findViewById(R.id.button1)
        val edtxt1: EditText = findViewById(R.id.ed1)
        val edtxt2: EditText = findViewById(R.id.ed2)
        val resultTV: TextView = findViewById(R.id.Result1)
        val spinnerVal: Spinner = findViewById(R.id.spinner1)
        var options = arrayOf("Addition", "Subtraction", "Multiplication", "Division")
        var flag: String = "Addition"
        spinnerVal.adapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt()
            val selectedCategory = options[spinnerVal.selectedItemPosition]
            var r:Int = when(flag) {
                "Addition" -> {
                    x+y
                }
                "Subtraction" -> {
                    x-y
                }
                "Multiplication" -> {
                    x*y
                }
                "Division" -> {
                    x / y
                }
                else -> 0
            }
            resultTV.text = """$selectedCategory 
                |
                |    $r""".trimMargin()
        }
    }
}