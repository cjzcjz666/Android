package com.example.listview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_array_adapter_button.*
import kotlinx.android.synthetic.main.arrayadpterlist_layer.*

class ArrayAdapter_button : AppCompatActivity() {
    private val itemlists = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter_button)
        initList()
        val adapter = ArrayAdapter_Items(this, R.layout.item_layer,itemlists)
        listView.adapter = adapter;
    }
    private fun initList(){
        itemlists.add(Item(R.drawable.img1,"陈俊哲","19301141"))
        itemlists.add(Item(R.drawable.img2,"陈俊哲","19301141"))
        itemlists.add(Item(R.drawable.img1,"陈俊哲","19301141"))
    }
}


class ArrayAdapter_Items(activity: Activity, val resourceId: Int, data: ArrayList<Item>)
    :ArrayAdapter<Item>(activity, resourceId, data){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false);
        val imgId: ImageView = view.findViewById(R.id.imageview1)
        val name: TextView = view.findViewById(R.id.textview1)
        val id: TextView = view.findViewById(R.id.textview2)
        val item = getItem(position)

//        if(item != null){
        imgId.setImageResource(item!!.imgId)
        name.text = item.name
        id.text = item.id
//        }
//        return super.getView(position, convertView, parent)
        return view
    }

}
