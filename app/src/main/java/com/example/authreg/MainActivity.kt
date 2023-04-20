package com.example.authreg

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtname:EditText
    private lateinit var edtsecond:EditText
    private lateinit var edtemail:EditText
    private lateinit var edtpassword:EditText
    private lateinit var btncreate:Button
    private lateinit var btnlogin:Button
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtname = findViewById(R.id.edtname)
        edtsecond = findViewById(R.id.edtsecond)
        edtemail = findViewById(R.id.edtemail)
        edtpassword = findViewById(R.id.edt_pass)
        btncreate = findViewById(R.id.btncreate)
        btnlogin = findViewById(R.id.btnlogin)

        db = openOrCreateDatabase("emobilisvannessa", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users( kwanza VARCHAR, pili VARCHAR, arafa VARCHAR, nenosiri VARCHAR)")


        btncreate.setOnClickListener {
            var kwanza_edt = edtname.text.toString().trim()
            var pili_edt = edtsecond.text.toString().trim()
            var arafa_edt = edtemail.text.toString().trim()
            var nenosiri_edt = edtpassword.text.toString().trim()

            if (kwanza_edt.isEmpty() || pili_edt.isEmpty() || arafa_edt.isEmpty() || nenosiri_edt.isEmpty()) {
                Toast.makeText(this, "Cannot Submit", Toast.LENGTH_SHORT).show()
            } else {
                db.execSQL("INSERT INTO users VALUES( '\"+kwanza_edt+\"', '\"+pili_edt+\"', '\"+arafa_edt+\"', '\"+nenosiri_edt+\"')")
                Toast.makeText(this, "Successfully created user", Toast.LENGTH_SHORT).show()

                var gotologin = Intent(this, login:: class.java)
                startActivity(gotologin)

            }
        }

        btnlogin.setOnClickListener {

            var gotoregister = Intent( this, MainActivity:: class.java)
            startActivity(gotoregister)

        }


    }
}






