package com.example.myapplication.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitytwoBinding
import com.example.myapplication.utils.EXTRA_MESSAGE
import com.example.myapplication.utils.Toasts

class Activitytwo : AppCompatActivity() {




    private lateinit var ui: ActivitytwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivitytwoBinding.inflate(layoutInflater)
        setContentView(ui.root)


        checkIntent()
        setypLestiner()
    }


    private fun checkIntent() {

        ui.etActTwo.setText(intent.getStringExtra(EXTRA_MESSAGE).toString())
    }

    private fun setypLestiner() {
        ui.btnActTwo.setOnClickListener {
            if (ui.etActTwo.text.toString() == "") {
                Toasts.showToast(this, getString(R.string.warning))
            } else openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, ui.etActTwo.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
