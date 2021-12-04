package mening.dasturim.medservice.data.constants

import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.HomeItem

object Constants {

    fun getHomeItems() : ArrayList<HomeItem>{
        return arrayListOf(
          HomeItem(R.drawable.bosh,R.string.nevralogiya),
          HomeItem(R.drawable.suyak,R.string.travma),
          HomeItem(R.drawable.tish,R.string.stamatologiya),
          HomeItem(R.drawable.tomoq,R.string.lor),
          HomeItem(R.drawable.urolog,R.string.urolog),
          HomeItem(R.drawable.yurak,R.string.kardiyalogiya),
        )
    }
}