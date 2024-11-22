package com.example.ecocontributorapplication.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.ecocontributorapplication.Project
import com.example.ecocontributorapplication.R

class ProjectAdapter(
    private var projects: List<Project>,
    private val onClick: (Project) -> Unit
) : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        holder.bind(project)
        holder.itemView.setOnClickListener { onClick(project) }
    }

    override fun getItemCount() = projects.size

    fun updateProjects(newProjects: List<Project>) {
        val diffCallback = ProjectDiffCallback(projects, newProjects)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        projects = newProjects
        diffResult.dispatchUpdatesTo(this)
    }

    class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val projectNameTextView: TextView = itemView.findViewById(R.id.project_name)
        private val projectDescriptionTextView: TextView = itemView.findViewById(R.id.project_description)

        fun bind(project: Project) {
            projectNameTextView.text = project.name ?: "No Name Available"
            projectDescriptionTextView.text = project.description ?: "No Description Available"
        }
    }

    class ProjectDiffCallback(
        private val oldList: List<Project>,
        private val newList: List<Project>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
