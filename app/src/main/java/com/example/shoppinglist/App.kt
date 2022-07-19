package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.data.AppDataBase
import com.example.shoppinglist.data.ShoppingLIstRepository

class App: Application() {
    val database by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { ShoppingLIstRepository(database.shoppingDao()) }

}