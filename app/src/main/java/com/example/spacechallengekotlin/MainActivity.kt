package com.example.spacechallengekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimulation(view: View) {
        val inputStreamFile1 = resources.openRawResource(R.raw.phase1)
        val inputStreamFile2 = resources.openRawResource(R.raw.phase2)

        val simulation = Simulation()
        val arrayListItems1 = ArrayList<Item>()
        val arrayListItems2 = ArrayList<Item>()
        val outputInformation : TextView = findViewById(R.id.outputText)

        var generalInformation = "Моделювання для ракет U1 (дві фази):"
        //Моделювання для ракет U1
        var totalCostSimulation1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems(arrayListItems1, inputStreamFile1)))
        totalCostSimulation1 += simulation.runSimulation(simulation.loadU1(simulation.loadItems(arrayListItems1, inputStreamFile1)))
        generalInformation +="\nБюджет: " + totalCostSimulation1 + " мільйонів $ // кількість ракет U1: " + totalCostSimulation1 / 100

        generalInformation += "\nМоделювання для ракет U2 (дві фази):";
        //Моделювання для рфкет U2
        var totalCostSimulation2 = simulation.runSimulation(simulation.loadU2(simulation.loadItems(arrayListItems2, inputStreamFile2)))
        totalCostSimulation2 += simulation.runSimulation(simulation.loadU2(simulation.loadItems(arrayListItems2, inputStreamFile2)))
        generalInformation += "\nБюджет: " + totalCostSimulation2 + " мільйонів $ // кількість ракет U2: " + totalCostSimulation2 / 120

        outputInformation.text = generalInformation
    }
    //by Barmutov Roman
}
