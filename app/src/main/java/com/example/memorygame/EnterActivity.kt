package com.example.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enter.*

class EnterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        btn_enter1.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_enter2.setOnClickListener {
            val intent = Intent(this,Medium::class.java)
            startActivity(intent)
        }

        btn_enter3.setOnClickListener {
            val intent = Intent(this,HardActivity::class.java)
            startActivity(intent)
        }
    }
}