package com.example.authreg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    
    private lateinit var edt_address: EditText        
    private lateinit var edt_word: EditText        
    private lateinit var btn_log: Button      
    private lateinit var btn_account: Button       
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_address = findViewById(R.id.edtaddress)
        edt_word = findViewById(R.id.edtword)
        btn_log = findViewById(R.id.btnlog)
        btn_account = findViewById(R.id.btnaccount)

        btn_log.setOnClickListener {
            var email = edt_address.text.toString().trim()
            var password = edt_word.text.toString().trim()

            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "check your field", Toast.LENGTH_SHORT).show()

            }else {

            }
        }
        


        }
        
    }
