package com.example.homework3lesson4
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework3lesson4.databinding.ActivityMainBinding
import java.io.Serializable

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<User>
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        list.add(User("Lemessa", "Adugna", "lemessa@miu.edu","1234"))
//        list.add(User("Baca", "Uma", "baca@miu.edu","0123"))
//        list.add(User("Zelalem", "Ambisa", "zelalem@miu.edu","5678"))
//        list.add(User("Lammii", "Taye", "lammii@miu.edu","1235"))
//        list.add(User("Lammuu", "Gamada", "lammuu@miu.edu","1234"))
        list = arrayListOf(
            User("Lemessa", "Adugna", "lemessa@miu.edu", "1234"),
            User("Baca", "Uma", "baca@miu.edu", "0123"),
            User("Zelalem", "Ambisa", "zelalem@miu.edu", "5678"),
            User("Lammii", "Taye", "lammii@miu.edu", "1235"),
            User("Lammuu", "Gamada", "lammuu@miu.edu", "1234")
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newUsr = intent.getSerializable("EXTRA_USER") as? User

        if (newUsr != null) {
            list.add(newUsr)
            Toast.makeText(this, " User added Successfully now ${list.size}" +
                    " in total", Toast.LENGTH_LONG).show()
        }

        binding.crtBtn.setOnClickListener {
            val intent = Intent(this, secondActivity::class.java)
            //intent.putExtra(email1)
            startActivity(intent)
        }

        binding.signInBtn.setOnClickListener {
            var email1 = binding.email.text.toString()
            var password = binding.editTextTextPersonName2.text.toString()

            var isValid = false
            for (user in list) {

                if(email1.isEmpty()||password.isEmpty()){
                    isValid =false
                    break
                }
                if (user.email == email1 && user.password == password ) {
                    isValid = true
                    break
                }
            }

            // val account= User(email1, password)
            if (isValid) {
                val acc = email1
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("EXTRA_EMAIL", email1)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Hi there! email or password is incorrect", Toast.LENGTH_LONG).show()
                val intent= Intent(this, secondActivity::class.java)
                startActivity(intent)
            }
        }



       binding.forgot.setOnClickListener {
            val recipient = binding.email.text.toString()
            val subject = "Password Recovery"

            for (usr in list) {

                if (recipient != null) {
                    if (usr.email.equals(recipient)) {
                        val body = "Here is your  password : ${usr.password}"
                        val emailUri = Uri.parse("mailto:$recipient?subject=$subject&body=$body ")
                        val emailIntent = Intent(Intent.ACTION_SENDTO, emailUri)
                        if (emailIntent.resolveActivity(packageManager) != null) {
                            val x = "Here is your  password : ${usr.password}"
                            startActivity(emailIntent)
                        } else {
                            Toast.makeText(this,"No Email client Found",Toast.LENGTH_LONG).show()
                        }


                        //startActivity(Intent.createChooser(emailIntent, "Choose an email client:"))
                    }
                }


            }
        }

    }
}

private fun Intent.getSerializable(s: String): Serializable? {
    return this.getSerializableExtra(s)
}






























