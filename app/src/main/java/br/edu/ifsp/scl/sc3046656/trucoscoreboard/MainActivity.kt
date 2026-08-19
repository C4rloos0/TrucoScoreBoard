package br.edu.ifsp.scl.sc3046656.trucoscoreboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3046656.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val counterA = binding.tvCounterA.text.toString()
        var counterAInt = counterA.toInt()

        val counterB = binding.tvCounterB.text.toString()
        var counterBInt = counterB.toInt()

        binding.btnMaisUmA.setOnClickListener {
            counterAInt = (counterAInt + 1).coerceAtMost(12)
            binding.tvCounterA.text = counterAInt.toString()
        }

        binding.btnMaisTresA.setOnClickListener {
            counterAInt = (counterAInt + 3).coerceAtMost(12)
            binding.tvCounterA.text = counterAInt.toString()
        }

        binding.btnMaisUmB.setOnClickListener {
            counterBInt = (counterBInt + 1).coerceAtMost(12)
            binding.tvCounterB.text = counterBInt.toString()
        }

        binding.btnMaisTresB.setOnClickListener {
            counterBInt = (counterBInt + 3).coerceAtMost(12)
            binding.tvCounterB.text = counterBInt.toString()
        }


    }
}