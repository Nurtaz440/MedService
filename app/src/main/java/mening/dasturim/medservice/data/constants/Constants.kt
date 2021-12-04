package mening.dasturim.medservice.data.constants

import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.EnginerItem
import mening.dasturim.medservice.data.model.HomeItem

object Constants {

    fun getHomeItems(): ArrayList<HomeItem> {
        return arrayListOf(
            HomeItem(R.drawable.bosh, R.string.nevralogiya),
            HomeItem(R.drawable.suyak, R.string.travma),
            HomeItem(R.drawable.tish, R.string.stamatologiya),
            HomeItem(R.drawable.tomoq, R.string.lor),
            HomeItem(R.drawable.urolog, R.string.urolog),
            HomeItem(R.drawable.yurak, R.string.kardiyalogiya),
        )
    }

    fun getOurEnginersItems(): ArrayList<EnginerItem> {
        return arrayListOf(
            EnginerItem(
                R.drawable.enginer_2,
                R.string.komil,
                R.string.empity,
                R.string.empity,
                R.string.empity,
                R.string.empity,
                R.string.empity
            ),
        EnginerItem(
            R.drawable.enginer_3,
            R.string.asror,
            R.string.empity,
            R.string.empity,
            R.string.empity,
            R.string.empity,
            R.string.empity
        ),
        EnginerItem(
            R.drawable.enginer_1,
            R.string.sevinch,
            R.string.empity,
            R.string.empity,
            R.string.empity,
            R.string.empity,
            R.string.empity
        ))

    }
}