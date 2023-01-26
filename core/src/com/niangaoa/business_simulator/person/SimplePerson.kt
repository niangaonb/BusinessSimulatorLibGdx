package com.niangaoa.business_simulator.person

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.PolygonBatch
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.utils.Json
import com.esotericsoftware.spine.AnimationState
import com.esotericsoftware.spine.AnimationStateData
import com.esotericsoftware.spine.Skeleton
import com.esotericsoftware.spine.SkeletonData
import com.esotericsoftware.spine.SkeletonJson
import com.esotericsoftware.spine.SkeletonRenderer
import com.niangaoa.business_simulator.api.Player
import kotlin.properties.Delegates

/**
 * 简易玩家类，仅仅是测试
 *@author niangaoa
 * */
class SimplePerson(x : Float, y : Float) {
    private lateinit var textureAtlas: TextureAtlas
    private lateinit var personRender : SkeletonRenderer
    private lateinit var personSJson: SkeletonJson
    private lateinit var personSData : SkeletonData
    private lateinit var personAnimationState: AnimationState
    private lateinit var personSkeleton: Skeleton
    private lateinit var personPolygonBatch: PolygonSpriteBatch
    private lateinit var animData: AnimationStateData
    private var realX = x
    private var realY = y
    private var i = 0

    fun draw() {
        personRender = SkeletonRenderer()
        textureAtlas = TextureAtlas(Gdx.files.internal("textures/Man/SimpleMan.atlas"))
        personSJson = SkeletonJson(textureAtlas)
        personSJson.scale = 0.2f
        personSData = personSJson.readSkeletonData(Gdx.files.internal("textures/Man/SimpleMan.json"))
        animData = AnimationStateData(personSData)
        personAnimationState = AnimationState(animData)
        personPolygonBatch = PolygonSpriteBatch()
        personSkeleton = Skeleton(personSData)
    }

    fun runAnimation() {
        if (i == 1) {
            personAnimationState.setAnimation(0, "animation", true)
            print("sfd")
        }
    }

    fun inputListener() {
        personSkeleton.setPosition(realX, realY)
        if (Gdx.input.isKeyPressed(Keys.D)) {
            realX +=2
            i = 1
            print(i)
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            print("yes")
        }
    }

    fun getRender() : SkeletonRenderer {
        return personRender
    }

    fun getBatch() : PolygonSpriteBatch {
        return personPolygonBatch
    }

    fun getSkeleton () : Skeleton {
        return personSkeleton
    }

    fun getState() : AnimationState {
        return personAnimationState
    }
}