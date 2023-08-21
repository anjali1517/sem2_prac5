package com.example.sem2_prac5

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.os.Handler
import java.util.Calendar
import javax.security.auth.callback.Callback

class TimePickerDialog(context: Context, is24HourView:Boolean,isSpinnerType:Boolean = false) {

    lateinit var dialog:TimePickerDialog
    var callback:Callback?=null

    private var listener = OnTimeSetListener{ timePicker, hourOfDay, minutes ->
        callback?.onTimeSelected(hourOfDay,minutes)

    }

    init {
        val style = if (isSpinnerType) {
            R.style.SpinnerTimePickerDialog
        } else {
            0
        }

        val cal = Calendar.getInstance()
        dialog = TimePickerDialog(
            context,style,
            listener,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            is24HourView
        )
    }
        fun showDialog(hourOfDay: Int,minute: Int,callback:Callback?){
            this.callback = callback
            dialog.updateTime(hourOfDay,minute)
            dialog.show()
        }


    interface Callback{
        fun onTimeSelected(hourOfDay:Int,minute:Int)
    }

}