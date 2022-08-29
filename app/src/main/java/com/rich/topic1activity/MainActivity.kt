package com.rich.topic1activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.rich.topic1activity.latihan.BmiActivity
import com.rich.topic1activity.latihan.NilaiAkhirActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var btnClick1 : Button
    lateinit var btnClick2 : Button
    lateinit var tvHello : TextView
    lateinit var btnHome : Button
    lateinit var etName : EditText
    lateinit var btnSubmit : Button
    lateinit var tvHelloName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
        setName()
    }


    fun setListener(){
        btnClick1 = findViewById(R.id.btnClick1)
        btnClick2 = findViewById(R.id.btnClick2)
        tvHello = findViewById(R.id.tvHello)
        btnHome = findViewById(R.id.btnHome)

        btnClick1.setOnClickListener {
            tvHello.text = "Button 1 clicked"
        }

        btnClick2.setOnClickListener {
            tvHello.text = "Button 2 clicked"
        }

        btnHome.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }

        btnBmi.setOnClickListener{
            startActivity(Intent(this, BmiActivity::class.java))
        }

        btnNilai.setOnClickListener{
            startActivity(Intent(this, NilaiAkhirActivity::class.java))
        }
    }

    private fun setName() {
        etName = findViewById(R.id.etName)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvHelloName = findViewById(R.id.tvHelloName)

        btnSubmit.setOnClickListener {
            if(etName.text.toString().isNotEmpty()){
                tvHelloName.text = "Hello ${etName.text}"
            }else{
                AlertDialog.Builder(this).setTitle("Warning").setMessage("Please enter your name").show()
            }
        }
    }
}