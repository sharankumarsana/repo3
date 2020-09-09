package com.example.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var arrayList: ArrayList<Country>):

    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val country: TextView =itemView.findViewById<TextView>(R.id.country_name)
        val countryCard: CardView =itemView.findViewById<CardView>(R.id.card)

       val countryCap:TextView = itemView.findViewById<TextView>(R.id.capital)
       val prefix:TextView=itemView.findViewById<TextView>(R.id.tel_prefix)
         val code2:TextView=itemView.findViewById<TextView>(R.id.iso2)
        val num: TextView =itemView.findViewById<TextView>(R.id.iso_num)
        val code3=itemView.findViewById<TextView>(R.id.iso3)
       val fips=itemView.findViewById<TextView>(R.id.fips)
        val center=itemView.findViewById<TextView>(R.id.count_center)
       val countRect=itemView.findViewById<TextView>(R.id.count_rect)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.country_card, parent, false)
        return ViewHolder(v)
    }


    //Setting Cards values
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


       val countries:Country=arrayList[position]

        holder.countryCard.setBackgroundResource(countries.countryFlag)
       holder.country.text =countries.countryName
        holder.countryCap.text= "Capital:  "+countries.capital
        holder.prefix.text="Tel Prefix:  "+countries.telPrefix
       holder.code2.text="Code ISO 2:  "+countries.codeISO2
        holder.num.text="Code ISO Num:  "+countries.codeISOnum
       holder.code3.text="Code ISO 3:  "+countries.codeISO3
        holder.fips.text="Code FIPS:  "+countries.codeFips
        holder.center.text="Center:  "+countries.centerCode
        holder.countRect.text="Rectangle:  "+countries.rectangleStr


    }
    override fun getItemCount(): Int {
       return arrayList.size
    }

        fun filterList(filterdNames: ArrayList<Country>) {
        arrayList = filterdNames
        notifyDataSetChanged()
    }

}