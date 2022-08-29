package com.rich.topic1activity.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.rich.topic1activity.R
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_nilai_akhir.*
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnHitung
import kotlinx.android.synthetic.main.activity_nilai_akhir.btnReset

class NilaiAkhirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_akhir)

        setListenerHitung()
        setListenerReset()
    }

    private fun setListenerReset() {
        btnReset.setOnClickListener {
            etNama.setText("")
            etNim.setText("")
            etNilaiTugas.setText("")
            etNilaiUts.setText("")
            etNilaiUas.setText("")
        }
    }

    private fun setListenerHitung() {
        btnHitung.setOnClickListener{
            val totalNilai = (etNilaiTugas.text.toString().toDouble() + etNilaiUts.text.toString().toDouble() + etNilaiUas.text.toString().toDouble())
            val nilaiRataRata = hitungRataRata(etNilaiUas.text.toString().toDouble(), etNilaiUts.text.toString().toDouble(), etNilaiTugas.text.toString().toDouble())
            val nilaiHuruf = nilaiHuruf(nilaiRataRata)
            val lulus = cekLulus(nilaiHuruf)

            AlertDialog.Builder(this)
                .setTitle("Hasil")
                .setMessage("Nama Mahasiswa : ${etNama.text}\nNIM : ${etNim.text.toString()}\nNilai UAS : ${etNilaiUas.text}\nNilai UTS : ${etNilaiUts.text}\nNilai Tugas : ${etNilaiTugas.text}\nTotal : ${totalNilai}\nNilai Rata-Rata : ${nilaiRataRata}\nNilai Huruf : ${nilaiHuruf}\nStatus : ${lulus}")
                .setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    fun hitungRataRata(nilaiUas: Double, nilaiUts: Double, nilaiTugas: Double): Double{
        return (nilaiUas + nilaiUts + nilaiTugas) / 3
    }

    fun nilaiHuruf(nilaiRataRata: Double): String{
        return when(nilaiRataRata){
             in 0.0..60.0 -> "E"
             in 61.0..70.0 -> "D"
             in 71.0..80.0 -> "C"
             in 81.0..90.0 -> "B"
             in 91.0..100.0 -> "A"
             else -> "Nilai tidak valid"
        }
    }

    fun cekLulus(nilaiHuruf : String) : String{
        val lulus = arrayOf("A", "B", "C")
        if(nilaiHuruf in lulus){
            return "Lulus"
        }else{
            return "Tidak Lulus"
        }
    }
}