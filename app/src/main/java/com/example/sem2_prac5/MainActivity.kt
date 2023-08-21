package com.example.sem2_prac5

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.sem2_prac5.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    var count:Int=0
    lateinit var txtTime:TextView
    lateinit var btnTime:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTime = findViewById(R.id.txtTime)
        btnTime = findViewById(R.id.btnCount)

    }

    override fun onStart() {
        super.onStart()
        btnTime.setOnClickListener {
            myAsync().execute()
        }
    }

    inner class myAsync : AsyncTask<String, Int, String>() {

        override fun onPreExecute() {
            super.onPreExecute()

            Toast.makeText(this@MainActivity,"onPreExecute",Toast.LENGTH_LONG).show()
            count=0
        }

        override fun doInBackground(vararg p0: String?): String {

            while(count<=100){
                //count = txtCouter.text.toString().toInt() + 1
                runOnUiThread {
                    txtTime.text = count.toString()
                }
                TimeUnit.MILLISECONDS.sleep(30)
                Log.i("ISPP",count.toString())
                count++
            }
            return "success"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(this@MainActivity,"onPostExecute",Toast.LENGTH_LONG).show()
        }
    }
}
