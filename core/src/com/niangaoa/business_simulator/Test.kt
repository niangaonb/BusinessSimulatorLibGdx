package com.niangaoa.business_simulator

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.esotericsoftware.spine.*


class Test : ApplicationAdapter() {

    private var render: SkeletonRenderer? = null
    private var sData: SkeletonData? = null
    private var state: AnimationState? = null
    private var skeleton: Skeleton? = null
    private var polygonBatch: PolygonSpriteBatch? = null

    override fun create() {
        render = SkeletonRenderer()
        // 获取纹理集合
        val tAtlas = TextureAtlas(Gdx.files.internal("textures/SimpleMan/test/SimpleMan.atlas"))
        // 读取json信息
        val sJson = SkeletonJson(tAtlas)
        sJson.scale = 1f // 缩放，以后不可更改
        sData = sJson.readSkeletonData(Gdx.files.internal("textures/SimpleMan/test/SimpleMan.json"))
        // 初始化动画信息
        val animData = AnimationStateData(sData)
        state = AnimationState(animData)
        // 初始化骨骼信息
        skeleton = Skeleton(sData)
        // 初始化batch
        polygonBatch = PolygonSpriteBatch()
        // 播放动画
        state!!.setAnimation(0, "animation", true)
        // 设置位置
        skeleton!!.setPosition(500f, 200f)
    }

    override fun render() {
        // 清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(1f, 0f, 0f, 0f)
        // 动画控制器更新时间步
        state!!.update(Gdx.graphics.deltaTime)
        // 动画控制器控制骨骼动画
        state!!.apply(skeleton)
        // 骨骼逐级进行矩阵变换
        skeleton!!.updateWorldTransform()
        // 绘制
        polygonBatch!!.begin()
        render?.draw(polygonBatch, skeleton)
        polygonBatch!!.end()
    }
}