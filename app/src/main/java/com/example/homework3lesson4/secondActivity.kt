package com.example.homework3lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework3lesson4.databinding.ActivitySecondBinding

class secondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    var fn=binding.firstName.text.toString()
     var ln= binding.lastName.text.toString()
     var email=binding.email1.text.toString()
     var  password= binding.password1.text.toString()
        var col= User(fn, ln, email, password)

        binding.crtBtn.setOnClickListener {

                val intent= Intent(this, MainActivity::class.java)
                intent.putExtra("EXTRA_USER",col)
                startActivity(intent)

        }
    }
}