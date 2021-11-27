package com.example.myapplication.utils

import android.content.Context
import android.widget.Toast

class Toasts {
     companion object{
     fun showToast(context: Context, msg: String){
      Toast.makeText(context,msg,Toast.LENGTH_LONG).show()

     }
     }
}