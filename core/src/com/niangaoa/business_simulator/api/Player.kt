package com.niangaoa.business_simulator.api

import com.badlogic.gdx.graphics.Texture

/**
 * Player是玩家能操控的基类
 * @author niangaoa
 * */
interface Player {
    fun draw()
    fun inputListener()
    fun getTextures() : Texture
    fun getX() : Int
    fun getY() : Int
}