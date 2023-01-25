package com.niangaoa.business_simulator

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.niangaoa.business_simulator.person.SimplePerson

class BSSMain : ApplicationAdapter() {
    private lateinit var spriteBatch : SpriteBatch
    private lateinit var simplePerson: SimplePerson

    override fun create() {
        spriteBatch = SpriteBatch()
        simplePerson = SimplePerson(50, 70, 5)
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        simplePerson.draw()
        spriteBatch.begin()
        spriteBatch.draw(Texture(Gdx.files.internal("textures/View1.png")), 0f, 0f)
        spriteBatch.draw(simplePerson.getTextures(), simplePerson.getX().toFloat(), simplePerson.getY().toFloat())
        simplePerson.inputListener()
        spriteBatch.end()
    }
}
