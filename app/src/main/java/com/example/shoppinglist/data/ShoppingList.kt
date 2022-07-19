package com.example.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val item: String,
    val quantidade: String
)
