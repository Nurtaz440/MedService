package mening.dasturim.medservice.data.constants

import mening.dasturim.medservice.R
import mening.dasturim.medservice.data.model.*

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
  fun getNewsItems(): ArrayList<NewsItem> {
        return arrayListOf(
            NewsItem(R.drawable.uzb, R.string.uz_text1),
            NewsItem(R.drawable.uzi_scanner, R.string.chet_text),
            NewsItem(R.drawable.uzb2, R.string.uz_text2),
            NewsItem(R.drawable.chet, R.string.stamatologiya),
            NewsItem(R.drawable.uzb3, R.string.uz_text3),
            NewsItem(R.drawable.chet2, R.string.urolog),
            NewsItem(R.drawable.uzb4, R.string.uz_text4),
            NewsItem(R.drawable.chet3, R.string.kardiyalogiya)
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
    fun getEnginersDetailItems(): ArrayList<EnginerssDetailItems> {
        return arrayListOf<EnginerssDetailItems>(
            EnginerssDetailItems(R.string.work, R.color.solitude_50, R.color.tangaroa_900),
            EnginerssDetailItems(R.string.reyting, R.color.solitude_50, R.color.tangaroa_900),
            EnginerssDetailItems(R.string.sertificate, R.color.solitude_50, R.color.tangaroa_900)
        )
    }
    fun getCurrentWork(): ArrayList<WorkItem> {
        return arrayListOf(
            WorkItem(
                "Medical Center MEDION CLINIC, AESTHETIC & SPA",
                "ishchi"
            ),
            WorkItem(
                "Medical Center MEDION CLINIC, AESTHETIC & SPA",
                "ishchi"
            ),
            WorkItem(
                "Medical Center MEDION CLINIC, AESTHETIC & SPA",
                "ishchi"
            ),
            WorkItem(
                "Medical Center MEDION CLINIC, AESTHETIC & SPA",
                "bosh boshqaruvchi"
            )
        )
    }

    fun getPastWork(): ArrayList<WorkItem> {
        return arrayListOf(
            WorkItem("CITY CLINICAL INFECTION HOSPITAL", "ishchi"),
            WorkItem("CITY CLINICAL INFECTION HOSPITAL", "ishchi"),
            WorkItem("CITY CLINICAL INFECTION HOSPITAL", "ishchi"),
            WorkItem("CITY CLINICAL INFECTION HOSPITAL", "ishchi"),
            WorkItem("CITY CLINICAL INFECTION HOSPITAL", "ishchi"),
        )
    }
    fun getSertificate(): ArrayList<CertificateItems> {
        return arrayListOf(
            CertificateItems(R.drawable.certificate),
            CertificateItems(R.drawable.certificate_2),
            CertificateItems(R.drawable.certificate_2),
            CertificateItems(R.drawable.certificate),
            CertificateItems(R.drawable.certificate_2)

        )
    }
}