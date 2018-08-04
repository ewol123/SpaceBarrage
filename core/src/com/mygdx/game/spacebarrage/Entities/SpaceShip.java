package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.spacebarrage.Util.Assets;
import com.mygdx.game.spacebarrage.Util.Constants;
import com.mygdx.game.spacebarrage.Util.Utils;

/**
 * Created by X on 2018. 05. 14..
 */

public class SpaceShip {

    Lasers lasers;
    Vector2 position;
    Rectangle rectangle;

    public SpaceShip(Vector2 position){

        this.position = position;
        lasers = new Lasers(position);

    }

    public Vector2 getPosition(){return position;}

    public void render(SpriteBatch batch) {

        TextureRegion region = Assets.instance.shipAssets.ship;
        Utils.drawTextureRegion(batch, region, position);
        rectangle = new Rectangle(position.x, position.y, region.getTexture().getWidth(), region.getTexture().getHeight());

        if (position.x > 240) position.x = 240;

        if (position.x < -320) position.x = -320;

    }

    public void update(float delta){

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) position.x -= delta * Constants.MOVE_SPEED;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) position.x += delta * Constants.MOVE_SPEED;

        float accelerometerInput = -Gdx.input.getAccelerometerY() / (Constants.GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);

        position.x += -delta * accelerometerInput * Constants.MOVE_SPEED;

    }
}
