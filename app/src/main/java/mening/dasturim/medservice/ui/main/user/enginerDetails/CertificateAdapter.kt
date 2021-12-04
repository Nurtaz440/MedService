package mening.dasturim.medservice.ui.main.user.enginerDetails

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.CertificateItems
import mening.dasturim.medservice.databinding.ItemCertificateBinding

class CertificateAdapter(val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<CertificateAdapter.VH>() {

    private var listItem = listOf<CertificateItems>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listItem: List<CertificateItems>) {
        this.listItem = listItem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemCertificateBinding>(
                inflater,
                R.layout.item_certificate,
                parent,
                false
            )
        return VH(binding, parent.context)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(position)
        }
        holder.onBind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    class VH(private val binding: ItemCertificateBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(certificate: CertificateItems) {
            binding.apply {
                ivCertificate.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        certificate.image
                    )
                )

            }

        }
    }
}