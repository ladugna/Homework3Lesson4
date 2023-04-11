package com.example.homework3lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework3lesson4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // To avoid application crash check intent has data or not
        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("detail")) {
            var ig = intent.getIntExtra("image", 0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("detail")
            binding.name.text = t1.toString()
            binding.desc.text = t2.toString()
            binding.imageView.setImageResource(ig)
        }
    }
}