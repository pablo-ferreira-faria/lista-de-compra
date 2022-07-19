package com.example.shoppinglist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.data.ShoppingLIstRepository
import com.example.shoppinglist.data.ShoppingList

class MainViewModel(private val shoppingLIstRepository: ShoppingLIstRepository) : ViewModel(){

    fun insert(shoppingList: ShoppingList){
        shoppingLIstRepository.insert(shoppingList)
    }

    fun gatAll() : LiveData<List<ShoppingList>>{
        return shoppingLIstRepository.getAll()
    }

}
class MainViewModelFactory(private val repository: ShoppingLIstRepository) :
        ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("unknow ViewModel class")
    }
        }

