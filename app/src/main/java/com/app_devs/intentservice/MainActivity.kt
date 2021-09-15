package com.app_devs.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app_devs.intentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                binding.tvServiceInfo.text="Service is Running"
            }
        }
        binding.btnStop.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                binding.tvServiceInfo.text = "Service Stopped"
            }
        }
        binding.btnSendData.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val dataString=binding.editTextTextPersonName.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}