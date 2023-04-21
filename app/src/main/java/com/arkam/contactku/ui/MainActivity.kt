package com.arkam.contactku.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.arkam.contactku.adapter.MainAdapter
import com.arkam.contactku.databinding.ActivityMainBinding
import com.arkam.contactku.model.People
import org.json.JSONArray
import org.json.JSONException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val peoples: ArrayList<People> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.rvRecylerView.layoutManager = linearLayoutManager

        try {
            val jsonArray = JSONArray(loadJSon().toString())
            for (i in 0 until jsonArray.length()) {
                val jsobObject = jsonArray.getJSONObject(i)
                val people = People(
                    id = jsobObject.getString("id"),
                    firstName = jsobObject.getString("firstName"),
                    lastName = jsobObject.getString("lastName"),
                    email = kotlin.runCatching { jsobObject.getString("email") }.getOrElse { "-" },
                    dob = kotlin.runCatching { jsobObject.getString("dob") }.getOrElse { "-" },
                )
                peoples.add(people)
            }
        } catch (ex: JSONException) {
            ex.printStackTrace()
        }

        Log.d("mainactivity", peoples.size.toString())
        val mainAdapter = MainAdapter(peoples)
        binding.rvRecylerView.adapter = mainAdapter

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