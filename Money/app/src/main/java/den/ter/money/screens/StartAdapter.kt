package den.ter.money.screens

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.ter.money.R
import den.ter.money.model.AMD
import den.ter.money.model.Dengi
import den.ter.money.model.DengiModel
import den.ter.money.model.Valute
import kotlinx.android.synthetic.main.item_layout.view.*
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class StartAdapter: RecyclerView.Adapter<StartAdapter.StartViewHolder>() {
    private var list = ArrayList<DengiModel>()
    var actual_date: String = ""

    class StartViewHolder(view:View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.char_name_value.text = list[position].CharCode
        holder.itemView.name_value.text = list[position].Name
        if(list[position].Value.toString().length>5){
            holder.itemView.sell_price.text = list[position].Value.toString().substring(0,5)
        }else{
        holder.itemView.sell_price.text = list[position].Value.toString()
        }
        if(list[position].Previous.toString().length>5){
            holder.itemView.buy_price.text = list[position].Previous.toString().substring(0,5)
        }else{
            holder.itemView.buy_price.text = list[position].Previous.toString()
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setList(list2: Dengi){
        list.add(list2.Valute.USD)
        list.add(list2.Valute.EUR)
        actual_date = list2.Date.toString()
        notifyDataSetChanged()
    }
}