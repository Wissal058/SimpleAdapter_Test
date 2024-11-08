package com.example.tp0_menu

data class item(val text: String) {
    override fun toString(): String {
        return text // Affiche le texte de l'élément dans la ListView
    }
}
