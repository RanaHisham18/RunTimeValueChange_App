package com.example.runtimevaluechangeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runtimevaluechangeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val sharedPref = getSharedPreferences("ranaPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
       // val data = binding.editText.text.toString()
        binding.button.setOnClickListener {
            val data = binding.editText.text.toString()

            editor.putString("version", data)
            editor.apply()

            binding.textView.text = sharedPref.getString("version", "This is the default value")
        }



    }
}