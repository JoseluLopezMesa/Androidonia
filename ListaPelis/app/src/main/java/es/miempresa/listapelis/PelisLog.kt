package es.miempresa.listapelis

import android.util.Log
import javax.inject.Inject

class PelisLog @Inject constructor() {

    fun log(message:String){
        Log.d("joselu",message)
    }
}