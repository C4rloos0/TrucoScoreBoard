package br.edu.ifsp.scl.sc3046656.trucoscoreboard

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3046656.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var counterA = 0
    var counterB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMaisUmA.setOnClickListener {
            counterA = (counterA + 1).coerceAtMost(12)
            atualizaValores()
        }

        binding.btnMaisTresA.setOnClickListener {
            counterA = (counterA + 3).coerceAtMost(12)
            atualizaValores()
        }

        binding.btnMaisUmB.setOnClickListener {
            counterB = (counterB + 1).coerceAtMost(12)
            atualizaValores()
        }

        binding.btnMaisTresB.setOnClickListener {
            counterB = (counterB + 3).coerceAtMost(12)
            atualizaValores()
        }

        binding.btnReiniciar.setOnClickListener {
            counterA = 0
            counterB = 0
            atualizaValores()
        }

    }

    private fun atualizaValores(){
        binding.tvCounterA.text = counterA.toString()
        binding.tvCounterB.text = counterB.toString()


        if(counterA == 12){
            mostrarPopUp("A")
        }

        if(counterB == 12){
            mostrarPopUp("B")
        }
    }

    private fun mostrarPopUp(time:String){
        AlertDialog.Builder(this)
            .setTitle("Fim de Jogo")
            .setMessage("Time $time Venceu")
            .setPositiveButton("Nova Partida") { dialog, _->
                counterA = 0
                counterB = 0
                atualizaValores()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

}