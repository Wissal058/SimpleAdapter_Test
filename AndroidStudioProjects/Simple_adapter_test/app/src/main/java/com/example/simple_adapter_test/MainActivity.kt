package com.example.simple_adapter_test

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listViw = findViewById<ListView>(R.id.listView)

        val produits = listOf(
            mapOf("name" to "Produits1", "price" to "10dh"),
            mapOf("name" to "Produits2", "price" to "20dh"),
            mapOf("name" to "Produits3", "price" to "15dh"),
            mapOf("name" to "Produits4", "price" to "40dh"),
        )

        //Création d'un SimpleAdapter
        var adapter = SimpleAdapter(
            this,
            produits,
            android.R.layout.simple_list_item_2,
            arrayOf("name", "price"),
            intArrayOf(android.R.id.text1, android.R.id.text2)

        )
        listViw.adapter = adapter
    }
}