package com.latihan.yogyakartaapp.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.latihan.yogyakartaapp.R
import com.latihan.yogyakartaapp.data.Wisata
import com.latihan.yogyakartaapp.databinding.ActivityDetailBinding
import com.latihan.yogyakartaapp.utils.Constants
import com.latihan.yogyakartaapp.utils.parcelable
import kotlin.math.log

class DetailActivity : AppCompatActivity() {
    private val TAG = "DetailActivity"
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item: Wisata? = intent.parcelable(Constants.TOUR_ITEM)
        Log.d(TAG, "onCreate: ${item?.name}")

        supportActionBar?.title = item?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressedDispatcher.onBackPressed()
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }
}