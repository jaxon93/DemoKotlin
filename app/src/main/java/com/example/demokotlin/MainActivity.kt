package com.example.demokotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.demokotlin.model.User

class MainActivity : AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()
    lateinit var tv_main: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val result = data!!.getStringExtra("result")
            Log.d(TAG, result!!)
            tv_main.text = result
        }
    }

    private fun initView() {
        tv_main = findViewById<TextView>(R.id.tv_main)
        var b_open_detail = findViewById<Button>(R.id.b_open_detail)
        b_open_detail.setOnClickListener(View.OnClickListener {
            var user = User(11, "PDP Academy")
            openDetailActivity(user)
        })
    }

    private fun openDetailActivity(user: User) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("user", user)
//        startActivity(intent)
        detailLauncher.launch(intent)
    }
}