package com.example.homework3lesson4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.homework3lesson4.databinding.ActivityBookBinding


class BookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookBinding
    var planets = arrayOf<String>("Maharishi", "DR Tony Nader", "Scientific Research Consciousness, knowledge and Enlightenment","Modern Science and vedic science",
        "Book Series", "Other Authors", "Clearance")

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, planets)
        //        binding.lview.adapter = adapter
        val adapter= ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,planets )
        binding.lview.adapter=adapter
        binding.lview.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this,"$item Clicked", Toast.LENGTH_LONG).show()
            //
//            val intent = Intent(applicationContext, PlanetActivity::class.java)
            //intent.putExtra("image", imageges[position])
            //startActivity(intent)
        }
    }
}