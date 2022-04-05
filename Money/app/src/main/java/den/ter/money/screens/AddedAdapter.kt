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

class AddedAdapter: RecyclerView.Adapter<AddedAdapter.AddViewHolder>() {
    private var list = ArrayList<DengiModel>()

    class AddViewHolder(view:View): RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return AddViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) {
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
        list.add(list2.Valute.AMD)
        list.add(list2.Valute.AUD)
        list.add(list2.Valute.AZN)
        list.add(list2.Valute.BGN)
        list.add(list2.Valute.BRL)
        list.add(list2.Valute.BYN)
        list.add(list2.Valute.CAD)
        list.add(list2.Valute.CHF)
        list.add(list2.Valute.CNY)
        list.add(list2.Valute.CZK)
        list.add(list2.Valute.DKK)
        list.add(list2.Valute.EUR)
        list.add(list2.Valute.GBP)
        list.add(list2.Valute.HKD)
        list.add(list2.Valute.HUF)
        list.add(list2.Valute.INR)
        list.add(list2.Valute.JPY)
        list.add(list2.Valute.KGS)
        list.add(list2.Valute.KRW)
        list.add(list2.Valute.KZT)
        list.add(list2.Valute.MDL)
        list.add(list2.Valute.NOK)
        list.add(list2.Valute.PLN)
        list.add(list2.Valute.UAH)
        list.add(list2.Valute.USD)
        notifyDataSetChanged()
    }
}