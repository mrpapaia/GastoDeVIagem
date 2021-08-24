package com.mrpapaia.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btCalcular = findViewById<Button>(R.id.btCalcular)
        btCalcular.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val id = v.id

        if (id == R.id.btCalcular) {
            calcularGastoViagem()
        }
    }


    private fun calcularGastoViagem() {

        val etDistancia = findViewById<EditText>(R.id.etDistancia)

        val etPreco = findViewById<EditText>(R.id.etPreco)
        val etAutonomia = findViewById<EditText>(R.id.etAutonomia)
        if (validate(etDistancia) && validate(etPreco) && validate(etAutonomia)) {
            val custoViagem = (etDistancia.text.toString().toFloat() * etPreco.text.toString()
                .toFloat()) / etAutonomia.text.toString().toFloat()
            findViewById<TextView>(R.id.tvCustoViagem).text = "R$ ${"%.2f".format(custoViagem)}"
        }


    }

    private fun validate(v: EditText): Boolean {
        if (v.text.isBlank()) {
            v.error = "Este campo é obrigatorio!"
            return false
        } else if (v.text.toString().toDouble() <= 0) {
            v.error = "O valor informado deve ser maior que 0"
            return false
        }
        return true
    }


}