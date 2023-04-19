package com.example.auth_reg_ezra

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class login : AppCompatActivity() {
    lateinit var email_edt: EditText
    lateinit var pass_edt: EditText
    lateinit var log_btn: Button
    lateinit var view_text: TextView
    lateinit var cre_btn: Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email_edt = findViewById(R.id.edt_email_log)
        pass_edt = findViewById(R.id.edt_pass_log)
        log_btn = findViewById(R.id.btn_login)
        view_text = findViewById(R.id.text_view1)
        cre_btn = findViewById(R.id.btn_cre_log)

        log_btn.setOnClickListener {

        }


    }
}
