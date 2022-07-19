package com.example.shoppinglist.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.example.shoppinglist.App
import com.example.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel : MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { ShoppingListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvList.adapter = adapter
        insertListener()
        getAllShoppingCard()
    }
    private fun insertListener(){
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this@MainActivity,AddShoppingList::class.java)
            startActivity(intent)
        }
    }
   private fun getAllShoppingCard(){
       mainViewModel.gatAll().observe(this, { shoppingList ->
           adapter.submitList(shoppingList)
       })
   }
}