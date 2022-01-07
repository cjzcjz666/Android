package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class SimpleAdapter_button : AppCompatActivity() {
    private val names = arrayOf("陈俊哲", "陈俊哲", "陈俊哲")
    private val descs = arrayOf("19301141", "19301141", "19301141")
    private val imageIds = intArrayOf(R.drawable.img1,
        R.drawable.img1, R.drawable.img2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter_button)
        // 创建一个List集合，List集合的元素是Map
        val listItems = ArrayList<Map<String, Any>>()
        for (i in names.indices) {
            val listItem = HashMap<String, Any>()
            listItem["header"] = imageIds[i]
            listItem["personName"] = names[i]
            listItem["desc"] = descs[i]
            listItems.add(listItem)
        }
        // 创建一个SimpleAdapter
        val simpleAdapter = SimpleAdapter(
            this,
            listItems,
            R.layout.simple_item,
            arrayOf("personName", "header", "desc"),
            intArrayOf(R.id.name, R.id.header, R.id.desc)
        )
        val list = findViewById<ListView>(R.id.mylist)
        // 为ListView设置Adapter
        list.adapter = simpleAdapter
    }
}