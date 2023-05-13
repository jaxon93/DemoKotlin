package com.example.demokotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView() {
        var tv_detail = findViewById<TextView>(R.id.tv_detail)
        var user = intent.getSerializableExtra("user")
        var b_exit_detail = findViewById<Button>(R.id.b_exit_detail)
        b_exit_detail.setOnClickListener {
            backToFinish()
        }

        Log.d(TAG, user.toString())

        tv_detail.text = user.toString()
    }

    fun backToFinish() {
        var intent = Intent()
        intent.putExtra("result", "Data returned")
        setResult(RESULT_OK, intent)
        finish()
    }
}