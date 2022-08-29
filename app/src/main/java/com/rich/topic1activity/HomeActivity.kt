package com.rich.topic1activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var etBil1 : EditText
    lateinit var etBil2 : EditText
    lateinit var btnHitung : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        hitungAngka()
    }

    fun hitungAngka(){
        etBil1 = findViewById(R.id.etBil1)
        etBil2 = findViewById(R.id.etBil2)
        btnHitung = findViewById(R.id.btnHitung)
        btnHitung.setOnClickListener {
            val bil1 = etBil1.text.toString().toInt()
            val bil2 = etBil2.text.toString().toInt()
            val hasil = bil1 + bil2
            AlertDialog.Builder(this)
                .setTitle("Hasil")
                .setMessage("$bil1 + $bil2 = $hasil")
                .setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}