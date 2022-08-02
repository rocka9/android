package com.example.my_first_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_project.R
import com.example.my_first_project.adapters.CoursesAdapter
import com.example.my_first_project.mod.Course

class listeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)

        // liste:
        val recyclerView: RecyclerView = findViewById(R.id.liste_courses)

        // à ajouter pour de meilleures performances:
        recyclerView.setHasFixedSize(true)

        // layout manager, décrivant comment les items sont disposés :
        recyclerView.layoutManager = LinearLayoutManager(this)

        // contenu de test :
        val listeCourses : MutableList<Course> = ArrayList()
        for (a in 1..20) {
            listeCourses.add(Course("Chocolat $a", a%3 ==0))
        }

        // adapter :
        recyclerView.adapter = CoursesAdapter(listeCourses)

    }
}