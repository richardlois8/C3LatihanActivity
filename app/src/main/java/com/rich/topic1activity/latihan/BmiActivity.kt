package com.rich.topic1activity.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.rich.topic1activity.R
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlin.math.round

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        setListenerHitung()
        setListenerReset()
    }


    fun setListenerHitung() {
        btnHitung.setOnClickListener() {
            val berat = etBerat.text.toString().toDouble()
            val tinggi = etTinggi.text.toString().toDouble()
            var bmi = round(hitungBmi(berat, tinggi))
            var kategoribmi = kategoriBmi(bmi)

            AlertDialog.Builder(this)
                .setTitle("Hasil")
                .setMessage("Umur Anda : ${etUmur.text.toString()} tahun\nTinggi : ${etTinggi.text.toString()} cm\nBerat Badan : ${etBerat.text.toString()} kg\nBMI Anda : $bmi \nKategori : $kategoribmi")
                .setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    fun setListenerReset() {
        btnReset.setOnClickListener{
            reset()
        }
    }

    fun hitungBmi(berat: Double, tinggi: Double): Double {
        val bmi = berat / ((tinggi * tinggi) / 10000)
        return bmi
    }

    fun kategoriBmi(bmi: Double): String {
        var hasilBmi = ""
        if (bmi < 16.0) {
            hasilBmi = "Terlalu kurus"
        } else if (bmi >= 16.0 && bmi < 17.0) {
            hasilBmi = "Cukup Kurus"
        } else if (bmi >= 17.0 && bmi < 18.5) {
            hasilBmi = "Sedikit Kurus"
        } else if (bmi >= 18.5 && bmi < 25.0) {
            hasilBmi = "Normal"
        } else if (bmi >= 25.0 && bmi < 30.0) {
            hasilBmi = "Gemuk"
        } else if (bmi >= 30.0 && bmi < 35.0) {
            hasilBmi = "Obesitas Kelas I"
        } else if (bmi >= 35.0 && bmi < 40.0) {
            hasilBmi = "Obesitas Kelas II"
        } else if (bmi >= 40.0) {
            hasilBmi = "Obesitas Kelas III"
        }
        return hasilBmi
    }

    fun reset() {
        etBerat.setText("")
        etTinggi.setText("")
        etUmur.setText("")
    }
}