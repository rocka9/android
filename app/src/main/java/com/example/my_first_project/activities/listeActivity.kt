package com.example.my_first_project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_project.R
import com.example.my_first_project.adapters.CoursesAdapter
import com.example.my_first_project.mod.Course

class listeActivity : AppCompatActivity(), View.OnClickListener {

    // ajout
    // accès à la variable courseAdapter
    private lateinit var coursesAdapter: CoursesAdapter

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
        val courseAdapter = CoursesAdapter(listeCourses)
        recyclerView.adapter = courseAdapter

        // Listener bouton ok :
        val boutonOk: AppCompatButton = findViewById(R.id.bouton_valider)
        boutonOk.setOnClickListener(this)

    }

    override  fun onClick(view: View){
        // Nouvelle course
        // Récuperer le champ de saisie
        val editTextCourse: EditText = findViewById(R.id.course)

        // récupérer la saisie
        val saisie = editTextCourse.text.toString()

        // Créer une course
        val course = Course(saisie, false)

        // ajouter item à course
        coursesAdapter.ajoutCourse(course)

        // finalisation :
        editTextCourse.setText("")
        recyclerView.smoothScrollPosition(0)

    }
}