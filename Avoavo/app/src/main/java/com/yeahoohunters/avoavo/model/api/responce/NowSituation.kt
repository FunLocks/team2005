package com.yeahoohunters.avoavo.model.api.responce

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class NowSituation (
    val congestion: List<Congestion>
){
    @Entity(tableName = "now_situation")
    data class Congestion(
        @SerializedName("0")
        val one_lounge: Int,
        @SerializedName("1")
        val one_ea_studio: Int,
        @SerializedName("2")
        val one_we_studio: Int,
        @SerializedName("3")
        val one_entrance: Int,
        @SerializedName("4")
        val one_dining: Int,
        @SerializedName("60")
        val one_le_toilet: Int,
        @SerializedName("61")
        val one_ri_toilet: Int,
        @SerializedName("59")
        val one_we_toilet: Int,
        @SerializedName("5")
        val two_we_lounge: Int,
        @SerializedName("6")
        val two_we_studio: Int,
        @SerializedName("7")
        val two_ea_studio: Int,
        @SerializedName("8")
        val two_ea_lounge: Int,
        @SerializedName("9")
        val two_shop: Int,
        @SerializedName("62")
        val two_we_toilet: Int,
        @SerializedName("63")
        val two_le_toilet: Int,
        @SerializedName("64")
        val two_ri_toilet: Int,
        @SerializedName("10")
        val three_gymnasium: Int,
        @SerializedName("11")
        val three_training: Int,
        @SerializedName("12")
        val three_we_toilet: Int,
        @SerializedName("13")
        val three_workshop: Int,
        @SerializedName("14")
        val three_electronics: Int,
        @SerializedName("15")
        val three_musicstudio: Int,
        @SerializedName("16")
        val three_lecroom: Int,
        @SerializedName("17")
        val three_365: Int,
        @SerializedName("18")
        val three_364: Int,
        @SerializedName("19")
        val three_363: Int,
        @SerializedName("65")
        val three_ne_toilet: Int,
        @SerializedName("66")
        val three_se_toilet: Int,
        @SerializedName("20")
        val three_we_lounge: Int,
        @SerializedName("21")
        val three_studio: Int,
        @SerializedName("22")
        val three_ea_lounge: Int,
        @SerializedName("23")
        val three_library: Int,
        @SerializedName("67")
        val three_ea_toilet: Int,
        @SerializedName("68")
        val three_le_toilet: Int,
        @SerializedName("69")
        val three_ri_toilet: Int,
        @SerializedName("24")
        val four_495: Int,
        @SerializedName("25")
        val four_494: Int,
        @SerializedName("26")
        val four_493: Int,
        @SerializedName("27")
        val four_nor_lounge: Int,
        @SerializedName("28")
        val four_485: Int,
        @SerializedName("29")
        val four_484: Int,
        @SerializedName("30")
        val four_483: Int,
        @SerializedName("70")
        val four_ne_toilet: Int,
        @SerializedName("71")
        val four_nw_toilet: Int,
        @SerializedName("72")
        val four_sw_toilet: Int,
        @SerializedName("73")
        val four_se_toilet: Int,
        @SerializedName("31")
        val four_we_studio: Int,
        @SerializedName("32")
        val four_ea_studio: Int,
        @SerializedName("33")
        val four_sou_lounge: Int,
        @SerializedName("34")
        val four_delta: Int,
        @SerializedName("35")
        val four_auditorium: Int,
        @SerializedName("36")
        val five_cir15: Int,
        @SerializedName("37")
        val four_cir14: Int,
        @SerializedName("38")
        val five_cir13: Int,
        @SerializedName("39")
        val five_cir12: Int,
        @SerializedName("40")
        val five_cir11: Int,
        @SerializedName("41")
        val five_cir10: Int,
        @SerializedName("42")
        val five_cir9: Int,
        @SerializedName("43")
        val five_cir8: Int,
        @SerializedName("44")
        val five_cir7: Int,
        @SerializedName("45")
        val five_cir6: Int,
        @SerializedName("46")
        val five_cir5: Int,
        @SerializedName("47")
        val five_cir4: Int,
        @SerializedName("48")
        val five_cir3: Int,
        @SerializedName("49")
        val five_cir2: Int,
        @SerializedName("50")
        val five_cir1: Int,
        @SerializedName("51")
        val five_595: Int,
        @SerializedName("52")
        val five_594: Int,
        @SerializedName("53")
        val five_593: Int,
        @SerializedName("54")
        val five_585: Int,
        @SerializedName("55")
        val five_584: Int,
        @SerializedName("56")
        val five_583: Int,
        @SerializedName("74")
        val five_nw_toilet: Int,
        @SerializedName("75")
        val five_ne_toilet: Int,
        @SerializedName("57")
        val five_we_studio: Int,
        @SerializedName("58")
        val five_ea_studio: Int,
        @SerializedName("76")
        val five_se_toilet: Int
    )
}