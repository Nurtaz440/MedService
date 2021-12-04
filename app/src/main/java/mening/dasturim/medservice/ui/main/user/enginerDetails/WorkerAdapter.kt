package mening.dasturim.medservice.ui.main.user.enginerDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.WorkItem
import mening.dasturim.medservice.databinding.ItemWorkBinding

class WorkerAdapter :RecyclerView.Adapter<WorkerAdapter.VH>() {


    private var listItem = listOf<WorkItem>()

    fun setData(listItem: List<WorkItem>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemWorkBinding>(
                inflater,
                R.layout.item_work,
                parent,
                false
            )
        return VH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    class VH(private val binding: ItemWorkBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(work: WorkItem) {
            binding.apply {
                tvClinicName.text = work.clinicName
                tvSphere.text = work.sphere
            }

        }
    }
}