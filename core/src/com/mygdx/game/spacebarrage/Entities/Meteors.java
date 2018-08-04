package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;

import java.util.Random;

/**
 * Created by X on 2018. 05. 15..
 */

public class Meteors {

    Vector2 position;
    DelayedRemovalArray<Meteor> meteors;

    public DelayedRemovalArray<Meteor> getMeteors(){
        return meteors;
    }

    public Meteors(){
        meteors = new DelayedRemovalArray<Meteor>(false,100);
        position = new Vector2();
    }


    public void render(SpriteBatch batch){

        for(Meteor meteor :meteors){
            meteor.render(batch);
        }
    }


    public void update(float delta){

        Random random = new Random();

        if (MathUtils.random() < delta * 5) {
            Vector2 newMeteorPosition = new Vector2(
                    random.nextInt(700) +-320,
                    Gdx.graphics.getHeight());

            Meteor newMeteor = new Meteor(newMeteorPosition);
            meteors.add(newMeteor);
        }

        meteors.begin();
        for(Meteor meteor :meteors){
            meteor.update(delta);

            if(meteor.position.y < -300){
                meteors.removeValue(meteor,false);
            }
        }
        meteors.end();

    }

}
