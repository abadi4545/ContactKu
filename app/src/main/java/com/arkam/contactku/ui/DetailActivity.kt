package com.arkam.contactku.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arkam.contactku.adapter.DetailAdapter
import com.arkam.contactku.databinding.ActivityDetailBinding
import com.arkam.contactku.model.DetailPeople
import org.json.JSONArray
import org.json.JSONException
import java.lang.Exception

class DetailActivity: AppCompatActivity() {

    private val detailpeoples: ArrayList<DetailPeople> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.rvRecylerView.layoutManager = linearLayoutManager

        try {
            val jsonArray = JSONArray(loadJSon().toString())
            for (i in 0 until jsonArray.length()) {
                val jsobObject = jsonArray.getJSONObject(i)
                val detailPeople = DetailPeople(
                    id = jsobObject.getString("id"),
                    firstName = jsobObject.getString("firstName"),
                    lastName = jsobObject.getString("lastName"),
                    email = kotlin.runCatching { jsobObject.getString("email") }.getOrElse { "-" },
                    dob = kotlin.runCatching { jsobObject.getString("dob") }.getOrElse { "-" },
                )
                detailpeoples.add(detailPeople)
            }
        } catch (ex: JSONException) {
            ex.printStackTrace()
        }

        Log.d("mainactivity", detailpeoples.size.toString())
        val detailAdapter = DetailAdapter(detailpeoples)
        binding.rvRecylerView.adapter = detailAdapter
    }

    private fun loadJSon(): String? {
        val json: String?
        try {
            val inputStream = assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}