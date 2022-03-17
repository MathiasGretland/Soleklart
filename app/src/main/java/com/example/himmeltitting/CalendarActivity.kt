package com.example.himmeltitting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.himmeltitting.databinding.CalendarMainBinding
import java.util.*

class CalendarActivity: AppCompatActivity() {
    private lateinit var binding: CalendarMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalendarMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("Date", Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString())

        setupCalendar()

    }

    private fun setupCalendar() {
        val c = getToday()
        binding.calendarView.setMinDate(c.timeInMillis)
        val cw = getDateFromToday(7)
        binding.calendarView.setMaxDate(cw.timeInMillis)
        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val dato = "Valgt dato er: " + dayOfMonth + "/" + (month + 1) + "/" + year
            //To get an toast at the bottom of the screen to display todays date
            //Toast.makeText(this, dato, Toast.LENGTH_SHORT).show()

            //To send back date to another activity, in this case: MainActivity
            val intent = Intent(this, MainActivity:: class.java)
            intent.putExtra("Dato", dato)
            startActivity(intent)

        }
    }

    //Helpmethod to find todays date in the right format
    private fun getToday(): Calendar {
        val calendar = Calendar.getInstance()

        val c = Calendar.getInstance()
        val dag = c.get(Calendar.DAY_OF_MONTH)
        val maaned = c.get(Calendar.MONTH)
        val aar = c.get(Calendar.YEAR)

        calendar.set(Calendar.MONTH, maaned)
        calendar.set(Calendar.DAY_OF_MONTH, dag)
        calendar.set(Calendar.YEAR, aar)

        return calendar
    }

    //Helpmethod to find a date x days from today
    private fun getDateFromToday(days: Int): Calendar {
        val calendar = Calendar.getInstance()

        val c = Calendar.getInstance()
        val dag = c.get(Calendar.DAY_OF_MONTH)
        val maaned = c.get(Calendar.MONTH)
        val aar = c.get(Calendar.YEAR)

        calendar.set(Calendar.MONTH, maaned)
        calendar.set(Calendar.DAY_OF_MONTH, dag + days)
        calendar.set(Calendar.YEAR, aar)

        return calendar
    }
}