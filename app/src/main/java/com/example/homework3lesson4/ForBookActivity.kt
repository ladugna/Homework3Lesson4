package com.example.homework3lesson4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework3lesson4.databinding.ActivityForBookBinding

class ForBookActivity : AppCompatActivity() {
   private lateinit var binding:ActivityForBookBinding

    var imageges = intArrayOf(
        R.drawable.java,
        R.drawable.javascript,
        R.drawable.python,
    )
@SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForBookBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_for_book)

        setContentView(binding.root)
        // Retrieve the array resources of data
        var s1 = resources.getStringArray(R.array.books);
        var  s2 = resources.getStringArray(R.array.desc);
        var s3 = resources.getStringArray(R.array.detail);

        binding.rv.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this,s1 , s2, imageges, s3 )


        // Set adapter to your RecyclerView
        binding.rv.adapter = adapter
    }


    }


