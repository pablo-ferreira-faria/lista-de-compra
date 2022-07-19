package com.example.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.shoppinglist.App
import com.example.shoppinglist.R
import com.example.shoppinglist.data.ShoppingList
import com.example.shoppinglist.databinding.ActivityAddShoppingListBinding

class AddShoppingList : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }


        private val binding by lazy{ ActivityAddShoppingListBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isertlistener()
    }


    private fun isertlistener(){
        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnAdicionar.setOnClickListener{
         val shoppingList = ShoppingList(
             item = binding.tilItem.editText?.text.toString(),
             quantidade = binding.tilQuantidade.editText?.text.toString()
         )
            mainViewModel.insert(shoppingList)
            Toast.makeText( this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}