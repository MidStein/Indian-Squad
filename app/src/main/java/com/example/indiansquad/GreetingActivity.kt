package com.example.indiansquad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.indiansquad.databinding.ActivityGreetingBinding

class GreetingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGreetingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreetingBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view)

        val intent = Intent(this, MainActivity::class.java);
        binding.closeGreetingButton.setOnClickListener {
            startActivity(intent);
            finish();
        }
    }
}