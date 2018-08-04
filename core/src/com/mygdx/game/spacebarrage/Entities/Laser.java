package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.spacebarrage.Util.Assets;
import com.mygdx.game.spacebarrage.Util.Constants;
import com.mygdx.game.spacebarrage.Util.Utils;

/**
 * Created by X on 2018. 05. 15..
 */

public class Laser {

    Vector2 position;
    Rectangle rectangle;
    Meteors meteors;

    public Laser(Vector2 position){
        this.position = position;
        meteors = new Meteors();

    }

    public Rectangle getRect(){
        return rectangle;
    }

    public void render(SpriteBatch batch){
        TextureRegion region = Assets.instance.laserAssets.laser;
        Utils.drawTextureRegion(batch,region,position);
        rectangle = new Rectangle(position.x,position.y,30,50);
    }

    public void update(float delta){
        position.y += delta* Constants.LASER_SPEED;
    }
}
