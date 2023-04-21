package com.arkam.contactku.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arkam.contactku.databinding.AcivityEditBinding
import com.arkam.contactku.databinding.ActivityMainBinding

class EditActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AcivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}