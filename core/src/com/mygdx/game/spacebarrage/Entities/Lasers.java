package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.mygdx.game.spacebarrage.Util.Constants;
import com.mygdx.game.spacebarrage.Util.Sounds;

/**
 * Created by X on 2018. 05. 15..
 */

public class Lasers {

    Vector2 position;
    public DelayedRemovalArray<Laser> laserArray;
    int points = 0;
    Sounds laserSound;

    public Lasers(Vector2 position){
        laserArray = new DelayedRemovalArray<Laser>(false,100);
        this.position = position;
        laserSound = new Sounds();
    }

    public void render(SpriteBatch batch){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()){
            laserArray.add(new Laser(new Vector2(position.x+ Constants.OFFSET_X,position.y+Constants.OFFSET_Y)));
            laserSound.playSound("sounds/laser.wav");
        }

        for (Laser laser : laserArray){
            laser.render(batch);
        }
    }


    public void update(float delta){
        laserArray.begin();
        for (Laser laser: laserArray){
            laser.update(delta);
            if(laser.position.y > 200){
                laserArray.removeValue(laser,false);
            }
        }
        laserArray.end();
    }

    public void dispose(){laserSound.dispose();}

}
