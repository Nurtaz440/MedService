package mening.dasturim.medservice.ui.main.user.enginer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.EnginerItem
import mening.dasturim.medservice.databinding.ItemEnginerBinding

class OurEnginerAdapter(private val itemClickListener: (EnginerItem) -> Unit) :
    RecyclerView.Adapter<OurEnginerAdapter.VH>() {

    private var listItem = listOf<EnginerItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItem: List<EnginerItem>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemEnginerBinding>(
                inflater,
                R.layout.item_enginer,
                parent,
                false
            )
        return VH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(listItem[position])
        }
        holder.onBind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    class VH(private val binding: ItemEnginerBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(enginer: EnginerItem) {
            binding.apply {
                tvFullName.text = context.getString(enginer.enginerName)
                tvCategoryOfDoctor.text = context.getString(enginer.enginerCategory)
                cardProfileAvater.setImageDrawable(ContextCompat.getDrawable(context, enginer.img))

            //                tvExperience.text = context.getString(doctorDetailItem.experience)
//                tvComments.text = context.getString(doctorDetailItem.comment)
//                tvClinicName.text = context.getString(doctorDetailItem.clinicName)
//                tvDetail.text = context.getString(doctorDetailItem.details)
            }
        }
    }

}