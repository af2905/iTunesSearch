package com.github.af2905.itunessearch.presentation.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.af2905.itunessearch.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)


        //navController = Navigation.findNavController(this, R.id.nav_host_fragment)

       /* val search = findViewById<TextView>(R.id.txt_search)
        search.setOnClickListener(this)*/

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                //navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
                                true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {

    }
}