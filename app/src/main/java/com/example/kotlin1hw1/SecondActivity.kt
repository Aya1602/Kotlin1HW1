package com.example.kotlin1hw1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.kotlin1hw1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent.getStringExtra(MainActivity.TEXT_KEY)
        binding.etInputData.text = getData as Editable

        binding.btnStartSecondActivity.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}