package mening.dasturim.medservice.ui.main.user.news

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.NewsItem
import mening.dasturim.medservice.databinding.ItemHomeBinding

class NewsAdapter(private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.VH>() {

    private var listItem = listOf<NewsItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItem: List<NewsItem>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemHomeBinding>(inflater, R.layout.item_home, parent, false)
        return  VH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }
        holder.onBind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    class VH(private val binding: ItemHomeBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NewsItem) {
            binding.apply {
                imageItem.setImageDrawable(ContextCompat.getDrawable(context, item.img))
                textItem.setText(item.info)
            }
        }

    }

}