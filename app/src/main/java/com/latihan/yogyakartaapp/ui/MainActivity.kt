package com.latihan.yogyakartaapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.latihan.yogyakartaapp.R
import com.latihan.yogyakartaapp.adapter.ListTourAdapter
import com.latihan.yogyakartaapp.data.Wisata
import com.latihan.yogyakartaapp.utils.Constants

// implement interface dari adapter (nanti click Alt + Enter)
class MainActivity : AppCompatActivity(), ListTourAdapter.OnItemClickCallback {
    private lateinit var rvTour: RecyclerView
    private val list = ArrayList<Wisata>()
    private lateinit var listTourAdapter: ListTourAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTour = findViewById(R.id.rv_tour)
        rvTour.setHasFixedSize(true) //untuk menginformasikan ukuran recyclerview tidak berubah

        list.addAll(getListTour()) //untuk menambahkan objeck wisata kedalam list
        showRecyclerList() //untuk menampilkan daftar item di Recyclerview
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.profile_picture, menu) // Pastikan nama menu sesuai
        return true
    }

    //mengambil data array
    private fun getListTour(): ArrayList<Wisata> {
        val dataName: Array<String> = resources.getStringArray(R.array.data_name)
        val dataDescription: Array<String> = resources.getStringArray(R.array.data_description)
        val dataPhoto: Array<String> = resources.getStringArray(R.array.data_photo)
        val listTour = ArrayList<Wisata>()
        for (i in dataName.indices) {
            val wisata = Wisata(dataName[i], dataDescription[i], dataPhoto[i])
            listTour.add(wisata)
        }
        return listTour
    }

    private fun showRecyclerList() {
        rvTour.layoutManager = LinearLayoutManager(this)

        // panggil interface dari adapter (this@MainActivity) dan buat adapternya menjadi global variable
        listTourAdapter = ListTourAdapter(list, this@MainActivity)
        rvTour.adapter = listTourAdapter
    }

    override fun onItemClicked(position: Int) {
        // test apakah onclick item nya berfungsi
//        Toast.makeText(this, "Masuk $position", Toast.LENGTH_SHORT).show()

        showSelectedTour(listTourAdapter.getItem(position))
    }

    private fun showSelectedTour(rose: Wisata) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra(Constants.TOUR_ITEM, rose)
        startActivity(detailIntent)
    }


}
