package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var valor1EditText: EditText
    private lateinit var valor2EditText: EditText
    private lateinit var resultadoTextView: TextView

    private var operacaoSelecionada: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valor1EditText = findViewById(R.id.valor1)
        valor2EditText = findViewById(R.id.valor2)
        resultadoTextView = findViewById(R.id.resultado)

        val mulplicacaoButton: Button = findViewById(R.id.multiplicacao)
        val divisaoButton: Button = findViewById(R.id.divisao)
        val somaButton: Button = findViewById(R.id.soma)
        val subtracaoButton: Button = findViewById(R.id.button4)
        val enterButton: Button = findViewById(R.id.button5)


        mulplicacaoButton.setOnClickListener{ setOperacao("*")}
        divisaoButton.setOnClickListener { setOperacao("/")}
        somaButton.setOnClickListener { setOperacao("+")}
        subtracaoButton.setOnClickListener { setOperacao("-")}

        enterButton.setOnClickListener { calcular() }


    }

    private fun calcular() {
        val valor1 = valor1EditText.text.toString().toDoubleOrNull() ?:0.0
        val valor2 = valor2EditText.text.toString().toDoubleOrNull() ?:0.0

            val resultado: Double = when (operacaoSelecionada){
                "*" -> valor1*valor2
                "+" -> valor1+valor2
                "-" -> valor1-valor2
                "/" -> if (valor2 != 0.0) valor1 / valor2 else Double.NaN
                    else -> Double.NaN

            }

        resultadoTextView.text ="Resultado: $resultado"
    }

    private fun setOperacao(operacao: String) {
        operacaoSelecionada = operacao
    }
}