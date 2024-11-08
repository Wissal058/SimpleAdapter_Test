package com.example.simpleadapter_tp01

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //val languages = listOf("Java","C#","Python","Kotlin","Swift")

        val languages = hashMapOf(
            "Java" to Pair("1995", R.drawable.ic_launcher_background),
            "C#" to Pair("2000", R.drawable.ic_launcher_foreground),
            "Python" to Pair("1991", R.drawable.ic_launcher_background),
            "Kotlin" to Pair("2011", R.drawable.ic_launcher_foreground),

        )
        val listView = findViewById<ListView>(R.id.listView)


        /*val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        listView.adapter = adapter*/

        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, languages)
        val adapter = MyAdapter(this, languages)
        listView.adapter = adapter

        // MODE DE SELECTION
        /*listView.choiceMode = ListView.CHOICE_MODE_SINGLE*/

        //listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE


    }
}