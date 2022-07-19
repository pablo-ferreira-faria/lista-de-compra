package com.example.shoppinglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoppingList::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun shoppingDao() : ShoppingListDao

    companion object{
        @Volatile
        private var INSTACE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{
            return INSTACE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "shoppinglist_db"
                ).build()
                INSTACE = instance
                instance
            }

        }
    }
}