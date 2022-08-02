package com.example.my_first_project.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_project.R
import com.example.my_first_project.mod.Course

class CoursesAdapter(private var listeCourses: MutableList<Course>) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        Log.i("TAG", "onCreateViewHolder: ")
        val viewCourse = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_courses, parent, false)
        return CourseViewHolder(viewCourse)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: $position")
        holder.textViewLibelleCourse.text = listeCourses[position].libelle
        holder.switchAcheteCourse.isChecked = listeCourses[position].achete
    }

    override fun getItemCount(): Int = listeCourses.size // retourne la taille de la liste de course

    //Viewholder:
    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textViewLibelleCourse: TextView = itemView.findViewById(R.id.libelle_course)
        val switchAcheteCourse: SwitchCompat = itemView.findViewById(R.id.achete_course)
    }
}