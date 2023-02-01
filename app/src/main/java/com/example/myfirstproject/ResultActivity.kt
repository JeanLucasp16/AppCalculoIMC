package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvclassificaçao = findViewById<TextView>(R.id.textview_classificaçao)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text = result.toString()


        val classificaçao: String = if(result < 18.5f){
            "ABAIXO DO PESO"
        }else if(result in 18.5..24.9){
            "NORMAL"
        }else if (result in 25f..29.9f){
            "SOBREPESO"
        }else if (result in 30f..39.9f){
            "OBESIDADE"
        } else{
            "OBESIDADE GRAVE"
        }

            tvclassificaçao.text =getString(R.string.message_classificaçao, classificaçao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}