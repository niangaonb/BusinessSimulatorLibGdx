package com.niangaoa.business_simulator.event

import java.util.*

/**
 * 降价事件
 * @author niangaoa
 * */
class DownInPriceEvent {
    private var oldPrice : Int? = null
    private var newPrice : Int? = null
    fun setOldPrice(oldPrice : Int) {
        this.oldPrice = oldPrice
    }
    fun getNewPrice() : Int? {
        return this.newPrice
    }

    /**
     * 填入first以及last来随机生成指定范围内减少金钱的大小(看个人)
     * @param first 随机起始
     * @param last 随机终止
     * */
    fun startRisePrice(first : Int, last : Int) {
        val randomPrice = Random()
        val risePrice : Int = randomPrice.nextInt(first, last)
        newPrice = oldPrice?.plus(risePrice)
    }
}