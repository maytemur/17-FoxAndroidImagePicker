package com.maytemur.foxandroidimagepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maytemur.foxandroidimagepicker.databinding.ActivityMainBinding
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(), ActivityResultCallback {
                binding.imageView.setImageURI(it)
            }
        )

        binding.button.setOnClickListener {
            getImage.launch("image/*")

        }

    }
}