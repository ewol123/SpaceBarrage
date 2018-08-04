package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.spacebarrage.Util.Sounds;

/**
 * Created by X on 2018. 05. 15..
 */

public class Level {

    SpaceShip spaceShip;
    Meteors meteors;
    Viewport viewport;
    Vector2 position;
    Lasers lasers;
    public DelayedRemovalArray<Explosion> explosions;
    Sounds explosionSound;

    public Level(Viewport viewport, Vector2 position){
        this.viewport = viewport;
        this.position = position;
         spaceShip = new SpaceShip(position);
         meteors = new Meteors();
        lasers = new Lasers(position);
        explosions = new DelayedRemovalArray<Explosion>();
        explosionSound = new Sounds();
    }


    public void render(SpriteBatch batch){
        spaceShip.render(batch);
        meteors.render(batch);
        lasers.render(batch);
        MeteorHit(batch);

        for (Explosion explosion : explosions) {
            explosion.render(batch);
        }
    }

    public void update(float delta){
        spaceShip.update(delta);
        meteors.update(delta);
        lasers.update(delta);

        explosions.begin();
        for (int i = 0; i < explosions.size; i++) {
            if (explosions.get(i).isFinished()) {
                explosions.removeIndex(i);
            }
        }
        explosions.end();
    }


    public void MeteorHit(SpriteBatch batch){

        for(Laser laser: lasers.laserArray) {
            for(Meteor meteor : meteors.meteors) {
                if(laser.rectangle.overlaps(meteor.rectangle)) {
                    lasers.laserArray.removeValue(laser,false);
                    explosions.add(new Explosion(meteor.position));
                    explosionSound.playSound("sounds/explosion.wav");
                    meteors.meteors.removeValue(meteor,false);

                }
            }
        }
    }


    public void dispose(){
        explosionSound.dispose();
        lasers.dispose();
    }
}
