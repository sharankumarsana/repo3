package com.example.country
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var arrayList: ArrayList<Country>, private var type :Int):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var likeButtonClickCount : Int = 1
    private lateinit var myContext:Context
    private val grid=0
    private val list=1
    override fun getItemCount(): Int {
        return arrayList.size
    }
    class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val country: TextView =itemView.findViewById(R.id.country_name)
val countryCard: CardView = itemView.findViewById(R.id.card)
       val countryCap:TextView = itemView.findViewById(R.id.capital)
       val prefix:TextView=itemView.findViewById(R.id.tel_prefix)
         val code2:TextView=itemView.findViewById(R.id.iso2)
        val num: TextView =itemView.findViewById(R.id.iso_num)
        val code3:TextView=itemView.findViewById(R.id.iso3)
       val fips: TextView =itemView.findViewById(R.id.codeFips)
        val center:TextView=itemView.findViewById(R.id.count_center)
       val countRect: TextView =itemView.findViewById(R.id.count_rect)
    var likeButton: Button = itemView.findViewById(R.id.likeBtn)
    }
    class GridViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val flag :ImageView = itemView.findViewById(R.id.grid_flag)
        val country: TextView =itemView.findViewById(R.id.grid_country_name)
        val countryCap:TextView = itemView.findViewById(R.id.grid_capital)
        val prefix:TextView=itemView.findViewById(R.id.grid_tel_prefix)
        val code2:TextView=itemView.findViewById(R.id.grid_iso2)
        val num: TextView =itemView.findViewById(R.id.grid_iso_num)
        val code3:TextView=itemView.findViewById(R.id.grid_iso3)
        val fips: TextView =itemView.findViewById(R.id.grid_fips)
        val center:TextView=itemView.findViewById(R.id.grid_count_center)
        val countRect: TextView =itemView.findViewById(R.id.grid_count_rect)
        var likeb: ImageButton = itemView.findViewById(R.id.grid_likeBtn)

    }

    override fun getItemViewType(position: Int): Int {
        return if (type == grid){
            grid
        }
        else{
            list
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == grid) {
            myContext = parent.context
            val v = LayoutInflater.from(parent.context).inflate(R.layout.gridview, null, false)
            GridViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.country_card, parent, false)
            ListViewHolder(v)
        }
    }
    //Setting Cards values
    override fun onBindViewHolder(listViewHolder: RecyclerView.ViewHolder, position: Int) {
        val countries:Country=arrayList[position]
      if(listViewHolder is ListViewHolder){
          listViewHolder.country.text =countries.countryName
        listViewHolder.countryCap.text= listViewHolder.itemView.context.getString(R.string.capitalName,countries.capital)
        listViewHolder.prefix.text=listViewHolder.itemView.context.getString(R.string.telPrefix,countries.telPrefix)
       listViewHolder.code2.text=listViewHolder.itemView.context.getString(R.string.codeISO2,countries.codeISO2)
        listViewHolder.num.text=listViewHolder.itemView.context.getString(R.string.codeISOnum,countries.codeISOnum)
       listViewHolder.code3.text=listViewHolder.itemView.context.getString(R.string.codeISO3,countries.codeISO3)
        listViewHolder.fips.text=listViewHolder.itemView.context.getString(R.string.codeFIPS,countries.codeFips)
        listViewHolder.center.text=listViewHolder.itemView.context.getString(R.string.center,countries.centerCode)
        listViewHolder.countRect.text=listViewHolder.itemView.context.getString(R.string.rectange,countries.rectangleStr)
          listViewHolder.countryCard.setBackgroundResource(countries.countryFlag)
         if (countries.likestate) {
            (listViewHolder.likeButton.setBackgroundResource(R.drawable.liked))
        } else {
            (listViewHolder.likeButton.setBackgroundResource(R.drawable.not_liked))
        }
    listViewHolder.likeButton.setOnClickListener {
        likeButtonClickCount++
        if(likeButtonClickCount%2==0) {

            countries.likestate = true
            notifyDataSetChanged()
        }
        else{
            countries.likestate=false
            notifyDataSetChanged()
            likeButtonClickCount=1
        }
    }
    }
        else{
          val gridViewHolder = listViewHolder as GridViewHolder
          gridViewHolder.country.text =countries.countryName
          gridViewHolder.countryCap.text= listViewHolder.itemView.context.getString(R.string.capitalName,countries.capital)
          gridViewHolder.prefix.text=listViewHolder.itemView.context.getString(R.string.telPrefix,countries.telPrefix)
          gridViewHolder.code2.text=listViewHolder.itemView.context.getString(R.string.codeISO2,countries.codeISO2)
          gridViewHolder.num.text=listViewHolder.itemView.context.getString(R.string.codeISOnum,countries.codeISOnum)
          gridViewHolder.code3.text=listViewHolder.itemView.context.getString(R.string.codeISO3,countries.codeISO3)
          gridViewHolder.fips.text=listViewHolder.itemView.context.getString(R.string.codeFIPS,countries.codeFips)
          gridViewHolder.center.text=listViewHolder.itemView.context.getString(R.string.center,countries.centerCode)
          gridViewHolder.countRect.text=listViewHolder.itemView.context.getString(R.string.rectange,countries.rectangleStr)
          gridViewHolder.flag.setImageResource(countries.countryFlag)
          if(countries.likestate){
              gridViewHolder.likeb.setBackgroundResource(R.drawable.liked)
          }
          else
          {
              gridViewHolder.likeb.setBackgroundResource(R.drawable.not_liked)
          }
          gridViewHolder.likeb.setOnClickListener{
              likeButtonClickCount++
              if(likeButtonClickCount%2==0) {
                  countries.likestate = true
                  notifyDataSetChanged()
              }
              else{
                  countries.likestate=false
                  notifyDataSetChanged()
                  likeButtonClickCount=1
              }

          }

      }

    }
        fun filterList(filterdNames: ArrayList<Country>) {
        arrayList = filterdNames
        notifyDataSetChanged()
    }
}