package com.mygdx.game.spacebarrage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.mygdx.game.spacebarrage.Entities.Level;
import com.mygdx.game.spacebarrage.Entities.Meteors;
import com.mygdx.game.spacebarrage.Entities.SpaceShip;
import com.mygdx.game.spacebarrage.Util.Assets;
import com.mygdx.game.spacebarrage.Util.Constants;

/**
 * Created by X on 2018. 05. 14..
 */

public class GameplayScreen extends ScreenAdapter {

    SpaceShip spaceShip;
    SpriteBatch batch;
    Viewport viewport;
    Meteors meteors;
    Level level;

    @Override
    public void show() {
        batch = new SpriteBatch();
        AssetManager am = new AssetManager();
        viewport = new ExtendViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);

        Assets.instance.init(am);
        level = new Level(viewport,new Vector2((Constants.WORLD_WIDTH/10) * -1 ,(Constants.WORLD_HEIGHT/2) *-1));
    }

    @Override
    public void resize(int width, int height) {
       viewport.update(width,height);
    }

    @Override
    public void render(float delta) {

         viewport.apply();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level.update(delta);

        batch.begin();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        level.render(batch);

        batch.end();
    }



    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        batch.dispose();
        level.dispose();
    }
}
