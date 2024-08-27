package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResult = findViewById<TextView>(R.id.calcResult)
        val tvPrice = findViewById<TextView>(R.id.resultPrice)
        val tvConsumption = findViewById<TextView>(R.id.resultConsump)
        val tvDistance = findViewById<TextView>(R.id.resultKm)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consumption = intent.getFloatExtra(KEY_CONSUMP, 0f)
        val distance = intent.getFloatExtra(KEY_DISTANCE, 0f)

        val btnNewCalc = findViewById<Button>(R.id.btn_newCalc)

        tvPrice.text = price.toString()
        tvConsumption.text = consumption.toString()
        tvDistance.text = distance.toString()

        val result = (distance/ consumption) * price

        tvResult.text = result.toString()

        btnNewCalc.setOnClickListener {
            val intent = Intent(this, PriceActivity::class.java)
            startActivity(intent)
        }
    }
}