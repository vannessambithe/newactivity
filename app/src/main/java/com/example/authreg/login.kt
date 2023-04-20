package com.example.authreg

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {

    private lateinit var edtaddress: EditText
    private lateinit var edtword: EditText
    private lateinit var btnlog: Button
    private lateinit var btnaccount: Button
    private lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtaddress = findViewById(R.id.edtaddress)
        edtword = findViewById(R.id.edtword)
        btnlog = findViewById(R.id.btnlog)
        btnaccount = findViewById(R.id.btnaccount)

        db = openOrCreateDatabase("emobilisvannessa", Context.MODE_PRIVATE, null)

        btnlog.setOnClickListener {
            var email = edtaddress.text.toString().trim()
            var password = edtword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "check your field", Toast.LENGTH_SHORT).show()

            } else {
                val cursor = db.rawQuery(
                    "SELECT * FROM users WHERE arafa=? AND nenosiri=?",
                    arrayOf(email, password)
                )

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, dashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Invalid email or password, please try again",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
        }


    }
    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
}



        

