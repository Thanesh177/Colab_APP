package com.example.colaboftwoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class third : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)

        val etUserMessage: EditText = findViewById(R.id.etUserMessage)
        val btnSendMsgToNextActivity: Button = findViewById(R.id.btnSendMsgToNextActivity)
        val spinnerVal: Spinner = findViewById(R.id.spinner2)

        val options = arrayOf("Calculator App", "Progressor App")
        var flag: String = "Calculator App"

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

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()


            val selectedCategory = options[spinnerVal.selectedItemPosition]
            val targetClass = when (flag) {
                "Calculator App" -> second::class.java
                "Progressor App" -> MainActivity::class.java
                else -> {
                    Toast.makeText(this, "Unknown application selected", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val intent = Intent(this, targetClass)
            intent.putExtra("key", message)
            startActivity(intent)
        }
    }
}
