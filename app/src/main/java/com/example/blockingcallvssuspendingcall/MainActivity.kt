package com.example.blockingcallvssuspendingcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.blockingcallvssuspendingcall.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set app theme

        setContentView(binding.root)

        binding.btnRunCode.setOnClickListener {

            CoroutineScope(Dispatchers.Main.immediate).launch {
                delay(3000)
                showMessage()
            }
//            Thread.sleep(3000)
//            showMessage()
        }
    }

    private fun showMessage(){
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

    suspend fun findBigPrime(): BigInteger =
        BigInteger.probablePrime(4096, java.util.Random())
}