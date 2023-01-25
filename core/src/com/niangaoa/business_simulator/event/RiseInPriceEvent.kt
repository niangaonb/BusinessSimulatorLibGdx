package com.niangaoa.business_simulator.event

import java.util.*

/**
 * 涨价事件
 * @author niangaoa
 * */
class RiseInPriceEvent {
    private var oldPrice : Int? = null
    private var newPrice : Int? = null
    fun setOldPrice(oldPrice : Int) {
        this.oldPrice = oldPrice
    }
    fun getNewPrice() : Int? {
        return this.newPrice
    }

    /**
     * 填入first以及last来随机生成指定范围内增加金钱的大小(建议不要写大了)
     * @param first 随机起始
     * @param last 随机终止
    * */
    fun startRisePrice(first : Int, last : Int) {
        val randomPrice = Random()
        val risePrice : Int = randomPrice.nextInt(first, last)
        newPrice = oldPrice?.plus(risePrice)
    }
}