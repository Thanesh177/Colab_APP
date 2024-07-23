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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var a:Int = 0
    private var l:Int = 0
    private var b:Int = 0
    private var ab:Int = 0
    private var ch:Int = 0
    private var t:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
        }

        val button: Button = findViewById(R.id.button)
        val edtxt1: EditText = findViewById(R.id.ed1)
        val resultTV: TextView = findViewById(R.id.result1)
        val spinnerVal: Spinner = findViewById(R.id.spinner)
        var options = arrayOf("Arms", "Legs", "Back", "Abs", "Chest")
        var flag: String = "Arms"
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
            val selectedCategory = options[spinnerVal.selectedItemPosition]
            val c :Int = when(flag){
                "Arms" -> {
                    a = a+x
                    a
                }
                "Legs" -> {
                    l = a+x
                    l
                }
                "Back" -> {
                    b = a+x
                    b
                }
                "Abs" -> {
                    ab = a+x
                    ab
                }
                "Chest" -> {
                    ch = a+x
                    ch
                }
                else -> 0
            }
            t = a+l+b+ab+ch
            resultTV.text = """
            $selectedCategory  $c min
            Total $t min
            """.trimIndent()        }
    }
}