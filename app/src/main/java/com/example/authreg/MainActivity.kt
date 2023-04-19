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
    private lateinit var edt_name:EditText
    private lateinit var edt_second:EditText
    private lateinit var edt_email:EditText
    private lateinit var edt_password:EditText
    private lateinit var btn_create:Button
    private lateinit var btn_login:Button
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edt_name = findViewById(R.id.edtname)
        edt_second = findViewById(R.id.edtsecond)
        edt_email = findViewById(R.id.edtemail)
        edt_password = findViewById(R.id.edt_pass)
        btn_create = findViewById(R.id.btncreate)
        btn_login = findViewById(R.id.btnlogin)

        db = openOrCreateDatabase("emobilisvannessa", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users( kwanza VARCHAR, pili VARCHAR, arafa VARCHAR, nenosiri VARCHAR)")


        btn_login.setOnClickListener {
            var kwanza_edt = edt_name.text.toString().trim()
            var pili_edt = edt_second.text.toString().trim()
            var arafa_edt = edt_email.text.toString().trim()
            var nenosiri_edt = edt_password.text.toString().trim()

            if (kwanza_edt.isEmpty() || pili_edt.isEmpty() || arafa_edt.isEmpty() || nenosiri_edt.isEmpty()) {
                Toast.makeText(this, "Cannot Submit", Toast.LENGTH_SHORT).show()
            } else {
                db.execSQL("INSERT INTO users VALUES( '\"+kwanza_edt+\"', '\"+pili_edt+\"', '\"+arafa_edt+\"', '\"+nenosiri_edt+\"')")
                Toast.makeText(this, "Successfully created user", Toast.LENGTH_SHORT).show()

                var gotologin = Intent(this, login:: class.java)
                startActivity(gotologin)

            }
        }

        btn_create.setOnClickListener {

            var gotoregister = Intent( this, MainActivity:: class.java)
            startActivity(gotoregister)

        }


    }
}
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

git add README.md
git commit -m "login"
git branch -M main
git remote add origin https://github.com/vannessambithe/login.git
git push -u origin main