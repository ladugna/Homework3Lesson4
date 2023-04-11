package com.example.homework3lesson4

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.homework3lesson4.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val temp= intent
//       val resa= temp.getStringExtra("user")
//        binding.emailo.text =resa
//        Toast.makeText(this, resa.toString(), Toast.LENGTH_LONG).show()

//        var r_intent= intent
//        var result= r_intent.getStringExtra("message")
//        binding.reso.text=result
       // Toast.makeText(this, res.toString(), Toast.LENGTH_LONG).show()
        binding.book.setOnClickListener {
//            val intent = Intent(applicationContext, BookActivity::class.java)
            val intent = Intent(applicationContext, ForBookActivity::class.java)
            startActivity(intent)

        }






    }

    fun medicineclick(view: View) {

    }

//    fun bookClick(view: View) {}

}