package com.lost.sqldatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.lost.sqldatabase.room.entites.AppDataBase
import com.lost.sqldatabase.room.entites.UserDbEntity
import java.lang.Math.random
import kotlin.concurrent.thread
import kotlin.random.Random

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

        btn_read.setOnClickListener(View.OnClickListener {
            val tv_name = findViewById<TextView>(R.id.exit1)
            val tv_age = findViewById<TextView>(R.id.exit2)
            val ed_name = findViewById<EditText>(R.id.editTextTextPassword)

            val name = ed_name.text.toString()

            val db = Room.databaseBuilder(applicationContext,AppDataBase::class.java, "DB_user").build()
            val userDao = db.userDao()

            thread {
                val user = userDao.findAge(name)
                if (user != null) {
                    Log.d("AAA",user.age.toString())
                    tv_age.text = user.age.toString()
                    tv_name.text = user.name
                } else {
                    Log.d("AAA","ERROR")
                }
            }

        })

        btn_save.setOnClickListener(View.OnClickListener {
            val ed_name = findViewById<EditText>(R.id.editTextTextPassword)
            val ed_age = findViewById<EditText>(R.id.editTextTextPassword2)

            val name = ed_name.text.toString()
            val age = ed_age.text.toString()

            val db = Room.databaseBuilder(applicationContext,AppDataBase::class.java, "DB_user").build()
            val userDao = db.userDao()
            val rand = (0L..10000000L).random()
            thread {
                userDao.saveName(UserDbEntity(id = rand, name = name, age = age.toInt()))
                Log.d("AAA","CREATE")
            }


        })


    }

}