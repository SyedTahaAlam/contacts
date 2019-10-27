package com.example.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_activty.*

class LoginActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activty)
        login.setOnClickListener {
            var name: String = email.text.toString()
            var number: String = password.text.toString()

//            mContactsViewModel.addContact(name,number)


            if (name.equals("abc@abc.com") && number.equals("123456")) {
                startActivity(Intent(this, MainActivity::class.java))
                finish();
            } else
                Toast.makeText(this, "try Again ", Toast.LENGTH_SHORT).show()


        }
    }
}
