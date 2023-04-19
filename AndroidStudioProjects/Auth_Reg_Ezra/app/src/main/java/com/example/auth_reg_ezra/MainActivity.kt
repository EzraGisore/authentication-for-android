package com.example.auth_reg_ezra

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name1: EditText
    lateinit var name2: EditText
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var cre: Button
    lateinit var log: Button
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name1 = findViewById(R.id.edt_name1)
        name2 = findViewById(R.id.edt_name2)
        email = findViewById(R.id.edt_email)
        pass = findViewById(R.id.edt_pass)
        cre = findViewById(R.id.btn_cre)
        log = findViewById(R.id.btn_log)

        db = openOrCreateDatabase("authDB", Context.MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS users(FirstName VARCHAR, SecondName VARCHAR,Email VARCHAR,Password VARCHAR)")
        cre.setOnClickListener {
            var name1_edt = name1.text.toString().trim()
            var name2_edt = name2.text.toString().trim()
            var email_edt = email.text.toString().trim()
            var pass_edt = pass.text.toString().trim()
            //Validate entries
            if (name1_edt.isEmpty() || name2_edt.isEmpty() || email_edt.isEmpty() || pass_edt.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an empty field.", Toast.LENGTH_SHORT).show()
            } else {
                //insert data
                //backslash(/) signs are auto generated
                //'"+name+"'
                db.execSQL("INSERT INTO users VALUES('\"+name1_edt+\"' ,'\"+name2_edt+\"' , '\"+email_edt+\"' ,'\"+pass_edt+\"')")
                Toast.makeText(this, "User Created successfully!", Toast.LENGTH_SHORT).show()
                var gotologin= Intent(this, login::class.java )
                startActivity(gotologin)
            }
        }
        log.setOnClickListener {
            var gotologin= Intent(this, login::class.java )
            startActivity(gotologin)
        }
    }
}