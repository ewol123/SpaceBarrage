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

public class Meteor {

    Vector2 position;
    Rectangle rectangle;

    public Meteor(Vector2 position){
        this.position = position;
    }


    public void render(SpriteBatch batch){
        TextureRegion region = Assets.instance.meteorAssets.meteor;
        Utils.drawTextureRegion(batch,region,position);
        rectangle = new Rectangle(position.x,position.y,40,10);
    }


    public void update(float delta){

        position.y -= delta * Constants.MOVE_SPEED;
    }

}
