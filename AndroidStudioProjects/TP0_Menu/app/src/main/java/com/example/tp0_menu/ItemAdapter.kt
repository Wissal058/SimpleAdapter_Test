package com.example.tp0_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView

class ItemAdapter(
    context: Context,
    private val items: MutableList<Item>,
    private val onEdit: (Int) -> Unit,
    private val onDelete: (Int) -> Unit
) : ArrayAdapter<Item>(context, R.layout.list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val itemTextView = view.findViewById<TextView>(R.id.item_text)
        val editButton = view.findViewById<ImageButton>(R.id.button_edit)
        val deleteButton = view.findViewById<ImageButton>(R.id.button_delete)

        itemTextView.text = items[position].text

        editButton.setOnClickListener { onEdit(position) }
        deleteButton.setOnClickListener { onDelete(position) }

        return view
    }
}
