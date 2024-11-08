package com.example.tp0_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

data class Item(val text: String)

class MainActivity : AppCompatActivity() {
    private lateinit var itemList: MutableList<Item>
    private lateinit var adapter: ItemAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv)
        itemList = mutableListOf()
        adapter = ItemAdapter(this, itemList, { position -> showEditItemDialog(itemList[position].text, position) },
            { position -> deleteItem(position) })
        listView.adapter = adapter
    }

    /*private fun showAddItemDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_items, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextDialog)

        AlertDialog.Builder(this)
            .setTitle("Ajouter un élément")
            .setView(dialogView)
            .setPositiveButton("Ajouter") { _, _ ->
                val text = editText.text.toString()
                if (text.isNotEmpty()) {
                    addItem(text)
                }
            }
            .setNegativeButton("Annuler", null)
            .show()
    }*/

    private fun addItem(text: String) {
        // Vérifie si l'élément existe déjà
        if (itemList.any { it.text.equals(text, ignoreCase = true) }) {
            Toast.makeText(this, "L'élément '$text' existe déjà dans la liste.", Toast.LENGTH_SHORT).show()
        } else {
            itemList.add(Item(text))
            adapter.notifyDataSetChanged()
        }
    }

    // filtrer la liste

    private fun showAddItemDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_items, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextDialog)

        AlertDialog.Builder(this)
            .setTitle("Ajouter un élément")
            .setView(dialogView)
            .setPositiveButton("Ajouter") { _, _ ->
                val text = editText.text.toString()
                if (text.isNotEmpty()) {
                    addItem(text)
                }
            }
            .setNegativeButton("Annuler", null)
            .show()
    }

    private fun filterItem(text: String) {

        // Vérifie si l'élément existe déjà
        if (itemList.any { it.text.startsWith(text, ignoreCase = true) }) {
            itemList.add(Item(text))
            adapter.notifyDataSetChanged()
        }
    }

    private fun showEditItemDialog(text: String, position: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_items, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextDialog)
        editText.setText(text)

        AlertDialog.Builder(this)
            .setTitle("Modifier un élément")
            .setView(dialogView)
            .setPositiveButton("Modifier") { _, _ ->
                val newText = editText.text.toString()
                if (newText.isNotEmpty()) {
                    itemList[position] = Item(newText)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Élément modifié: $newText", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Annuler", null)
            .show()
    }

    private fun deleteItem(position: Int) {
        if (position >= 0 && position < itemList.size) {
            val removedItem = itemList.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Élément supprimé: ${removedItem.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuAdd -> {
                showAddItemDialog()
                true
            }


            R.id.menuDelete -> {
                itemList.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Liste vidée", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
