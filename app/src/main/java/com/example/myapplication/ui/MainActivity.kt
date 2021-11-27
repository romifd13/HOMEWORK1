package com.example.myapplication.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.EXTRA_MESSAGE
import com.example.myapplication.utils.Toasts

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var ui: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        registerForActivity()
        setupListener()

    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    ui.etMainAct.setText(result.data?.getStringExtra(EXTRA_MESSAGE))
                }
            }
    }

    private fun setupListener() {
        ui.btnMainAct.setOnClickListener {
            if (ui.etMainAct.text.toString() == "") {
                Toasts.showToast(this, getString(R.string.warning))
            } else openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, Activitytwo::class.java).apply {
            putExtra(EXTRA_MESSAGE, ui.etMainAct.text.toString())
        }
        resultLauncher.launch(intent)
    }
}


