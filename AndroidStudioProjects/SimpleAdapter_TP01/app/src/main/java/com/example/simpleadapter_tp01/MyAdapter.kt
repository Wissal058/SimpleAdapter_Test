package com.example.simpleadapter_tp01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Context, private val data: HashMap<String, Pair<String, Int>>) : BaseAdapter() {
    private val languages = data.keys.toList()
    private val years = data.values.toList()

    override fun getCount(): Int {
        return languages.size
    }
    override fun getItem(position: Int): Any {
        return languages[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.listview_items, parent, false)
        val tvLanguageName = view.findViewById<TextView>(R.id.tvLanguageName)
        val tvYear = view.findViewById<TextView>(R.id.tvYear)
        val icon = view.findViewById<ImageView>(R.id.icon)

        tvLanguageName.text = languages[position]
        tvYear.text = "Year: ${years[position]}"

        return view
    }
}
