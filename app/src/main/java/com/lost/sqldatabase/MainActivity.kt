package com.lost.sqldatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.lost.sqldatabase.room.entites.AppDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_read = findViewById<Button>(R.id.btn_read)
        val btn_save = findViewById<Button>(R.id.btn_save)

        val tv_name = findViewById<TextView>(R.id.exit1)
        val tv_age = findViewById<TextView>(R.id.exit2)

        val db = Room.databaseBuilder(applicationContext,AppDataBase::class.java, "DB_user").build()

        val userDao = db.userDao()

    }

    fun onSaveDB(){
        val ed_name = findViewById<EditText>(R.id.editTextTextPassword)
        val ed_age = findViewById<EditText>(R.id.editTextTextPassword2)

        val name = ed_name.text.toString()
        val age = ed_age.text.toString()


    }



}