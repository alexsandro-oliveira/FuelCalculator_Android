package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_DISTANCE = "DistanceActivity.KEY_INPUT_DISTANCE"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val consumption = intent.getFloatExtra(KEY_CONSUMP, 0f)
        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        val edtDistance = findViewById<TextInputEditText>(R.id.edt_distance)

        val btnNext = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {
            if (edtDistance.toString() == "") {
                Snackbar.make(it, "Preecha com a distância que irá percorrer!", Snackbar.LENGTH_LONG).show()
            } else {
                val distance = edtDistance.text.toString().toFloat()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_DISTANCE, distance)
                intent.putExtra(KEY_CONSUMP, consumption)
                intent.putExtra(KEY_PRICE, price)

                startActivity(intent)
            }
        }
    }
}