package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList(""+i+" 번째 자동차 ",""+i+"순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity,carName+" "+carEngine,Toast.LENGTH_SHORT).show()
        }


    }
}

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val layoutInflater : LayoutInflater
) : BaseAdapter(){

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 개수
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
       return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템 뷰의 아이디 설정
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_view,null)
        val carNameTextview = view.findViewById<TextView>(R.id.car_name)
        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

        carNameTextview.setText(carForList.get(position).name)
        carEngineTextView.setText(carForList.get(position).engine)

        return view
    }
}