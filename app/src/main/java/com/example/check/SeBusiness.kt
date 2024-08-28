package com.example.check

import android.widget.ArrayAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SeBusiness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_se_business)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttons = findViewById<Button>(R.id.btnid)
        buttons.setOnClickListener() {
            val intent = Intent(this@SeBusiness, ShopType::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.btnidprev)
        button.setOnClickListener {
            finish()
        }
        val cityToAreaMap = mapOf(
            "Dhaka" to listOf("Gulshan", "Banani", "Motijheel", "Mirpur", "Tejgaon", "Uttara"),
            "Chittagong" to listOf("Pahartali", "Chandgaon", "Kotwali", "Kalurghat", "Anderkilla", "Halishahar"),
            "Khulna" to listOf("Khulna City", "Joragate", "Sonadanga", "Gollamari", "Daulatpur", "Khalishpur"),
            "Rajshahi" to listOf("Rajshahi City", "Shaheb Bazar", "Matihar", "Boalia", "Chandrima", "Tanore"),
            "Sylhet" to listOf("Sylhet City", "Shahi Eidgah", "Ambarkhana", "Jalalabad", "Bandar Bazar", "Osmani Nagar"),
            "Barisal" to listOf("Barisal City", "Uttara", "Central", "Kasba", "City Bazar", "Banaripara"),
            "Rangpur" to listOf("Rangpur City", "Rangpur Sadar", "Badarganj", "Pirganj", "Mithapukur", "Kaunia"),
            "Comilla" to listOf("Comilla City", "Adarsha Sadar", "Chandina", "Muradnagar", "Debidwar", "Barura"),
            "Mymensingh" to listOf("Mymensingh City", "Vashtala", "Trishal", "Gaffargaon", "Phulpur", "Haluaghat"),
            "Gazipur" to listOf("Gazipur City", "Gazipur Sadar", "Kaliakoir", "Sreepur", "Kapasia", "Joydebpur")
        )

        val autoCompleteTextViewCity = findViewById<AutoCompleteTextView>(R.id.city)
        val cityArray = resources.getStringArray(R.array.city_names)
        val cityArrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cityArray)

        autoCompleteTextViewCity.setAdapter(cityArrayAdapter)

        val autoCompleteTextViewArea = findViewById<AutoCompleteTextView>(R.id.area)

        autoCompleteTextViewCity.setOnItemClickListener { parent, view, position, id ->
            val selectedCity = parent.getItemAtPosition(position) as String
            val areas = cityToAreaMap[selectedCity] ?: emptyList()
            val areaArrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, areas)
            autoCompleteTextViewArea.setAdapter(areaArrayAdapter)
        }
    }
}
