package com.niangaoa.business_simulator.person

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.niangaoa.business_simulator.api.Player

/**
 * 简易玩家类，仅仅是测试
 *@author niangaoa
 * */
class SimplePerson(x: Int, y: Int, private var speed : Int) : Player {
    private lateinit var textures : Texture
    private var realX = x
    private var realY = y
    override fun draw() {
        textures = Texture(Gdx.files.internal("textures/SimpleMan.png"))
    }

    override fun inputListener() {
        if (Gdx.input.isKeyPressed(Keys.D)) {
            realX += speed
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            realX -= speed
        }
    }

    override fun getTextures() : Texture {
        return textures
    }

    override fun getX() : Int {
        return realX
    }

    override fun getY() : Int {
        return realY
    }
}