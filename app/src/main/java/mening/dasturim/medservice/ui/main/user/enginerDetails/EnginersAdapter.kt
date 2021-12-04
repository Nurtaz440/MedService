package mening.dasturim.medservice.ui.main.user.enginerDetails

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.EnginerssDetailItems
import mening.dasturim.medservice.databinding.ItemEnginerDetailsBinding

class EnginersAdapter (private val itemClickListener: (Int, Int) -> Unit) :
    RecyclerView.Adapter<EnginersAdapter.VH>() {

    private var listItem = listOf<EnginerssDetailItems>()
    private var lastClickedPosition: Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItem: List<EnginerssDetailItems>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemEnginerDetailsBinding>(
                inflater,
                R.layout.item_enginer_details,
                parent,
                false
            )
        return VH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VH, @SuppressLint("RecyclerView") position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position, lastClickedPosition)
            lastClickedPosition = position
        }
        holder.onBind(listItem[position])
    }


    override fun getItemCount() = listItem.size

    class VH(private val binding: ItemEnginerDetailsBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(category: EnginerssDetailItems) {
            binding.apply {
                tvCategory.setText(category.categoryName)
                tvCategory.setTextColor(ContextCompat.getColor(context, category.textColor))
                cvCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        category.backgroundColor
                    )
                )
            }

        }
    }

}