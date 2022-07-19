package com.example.shoppinglist.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShoppingLIstRepository(private val dao: ShoppingListDao) {

    fun insert(shoppingList: ShoppingList) = runBlocking{
        launch (Dispatchers.IO){
            dao.insert(shoppingList)
        }
    }

    fun getAll() = dao.getAll()
}