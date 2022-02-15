package com.example.periodictableapp.listedelements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.R
import com.example.periodictableapp.periodictable.Element
import com.google.android.material.card.MaterialCardView
import org.w3c.dom.Text


class ListedElementsAdapter(
    private val elementList : List<Element>
) : RecyclerView.Adapter<ListedElementsAdapter.ListedElementViewHolder>() {

    inner class ListedElementViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var hidden_elements = view.findViewById<RelativeLayout>(R.id.element_hidden_information)
        var element_single_card = view.findViewById<MaterialCardView>(R.id.element_single_card)


        var element_name = view.findViewById<TextView>(R.id.element_name)
        var element_number = view.findViewById<TextView>(R.id.element_number)

        var element_symbol = view.findViewById<TextView>(R.id.element_symbol)
        var element_period = view.findViewById<TextView>(R.id.element_period)
        var element_mass = view.findViewById<TextView>(R.id.element_mass)
        var element_density = view.findViewById<TextView>(R.id.element_density)
        var element_boiling_point = view.findViewById<TextView>(R.id.element_boiling_point)
        var element_melting_point = view.findViewById<TextView>(R.id.element_melting_point)
        var element_electron_affinity = view.findViewById<TextView>(R.id.element_electron_affinity)
//        var element_configuration = view.findViewById<TextView>(R.id.element_configuration)
//        var element_ionization_energy = view.findViewById<TextView>(R.id.element_ionization_energy)
//        var element_category = view.findViewById<TextView>(R.id.element_category)
//        var element_summary = view.findViewById<TextView>(R.id.element_summary)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListedElementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_list_element, parent, false)
        return ListedElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListedElementViewHolder, position: Int) {
        val element = elementList[position]



        val element_name = element.name
        val element_number = element.number
        val element_symbol = "Symbol : " + element.symbol
        val element_period = "Period : " + element.period.toString()
        val element_mass = "Mass : " + element.atomic_mass + " u"
        val element_density = "Density : " + element.density + " g/cc"
        val element_boiling_point = "Boiling Point : " + element.boil.toString() + " K"
        val element_melting_point = "Melting Point : " + element.melt.toString() + " K"
        val element_electron_affinity = "Electron Affinity : " + element.electron_affinity.toString() + " kJ/mol"
        val element_configuration = "Electron Configuration : " + element.electron_configuration
        val element_ionization_energy = "Ionization Energy : " + element.ionization_energies.toString()
        val element_category = "Category : " + element.category
        val element_summary = "Summary : " + element.summary

        holder.element_name.setText(element_name)
        holder.element_number.setText(element_number.toString())
        holder.element_symbol.setText(element_symbol)
        holder.element_period.setText(element_period)
        holder.element_mass.setText(element_mass)
        holder.element_density.setText(element_density)
        holder.element_boiling_point.setText(element_boiling_point)
        holder.element_melting_point.setText(element_melting_point)
        holder.element_electron_affinity.setText(element_electron_affinity)
//        holder.element_configuration.setText(element_configuration)
//        holder.element_ionization_energy.setText(element_ionization_energy)
//        holder.element_category.setText(element_category)
//        holder.element_summary.setText(element_summary)


        changeVisibilityOfView(element.visible, holder)

        holder.element_single_card.setOnClickListener {
            element.visible = !element.visible
            changeVisibilityOfView(element.visible, holder)
        }


    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    private fun changeVisibilityOfView(isVisible: Boolean, holder: ListedElementViewHolder){

        if(isVisible){
            holder.hidden_elements.visibility = View.VISIBLE
        }else{
            holder.hidden_elements.visibility = View.GONE
        }

    }

}