package com.example.himmeltitting

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.himmeltitting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //To get dato from CalendarActivity
        val incomingIntent = getIntent()
        val date = incomingIntent.getStringExtra("Dato")
        binding.date.setText(date)

        /*
        SELF NOTE: CalenderView er ikke veldig customizable :(
        Bug: Datoen i dag har alltid en rar farge, selv når du trykker på en annen dato

        kan bruke getIntent() for å sende data mellom forskjellige activities
         */

        binding.button.setOnClickListener {
            val intent = Intent(this, CalendarActivity:: class.java)
            startActivity(intent)
        }
    }
}