package com.example.kotlin1hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.etInputData.text = result.data as Editable
                }
            }

        binding.btnStartSecondActivity.setOnClickListener {
            checkEditText()
        }

    }

    private fun checkEditText() {
        if (binding.etInputData.text.toString() != null) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(TEXT_KEY, binding.etInputData.text.toString())
            resultLauncher.launch(intent)
        } else {
            Toast.makeText(this, "Текстовое поле не может быть пустым", Toast.LENGTH_SHORT)
        }
    }

    companion object{
        const val TEXT_KEY = "ключ"
    }
}