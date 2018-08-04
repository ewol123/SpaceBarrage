package com.mygdx.game.spacebarrage.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.spacebarrage.Util.Assets;
import com.mygdx.game.spacebarrage.Util.Utils;

/**
 * Created by X on 2018. 05. 16..
 */

public class Explosion {

    private final Vector2 position;
    private final long startTime;
    public float offset = 0;

    public Explosion(Vector2 position) {
        this.position = position;
        startTime = TimeUtils.nanoTime();
    }

    public void render(SpriteBatch batch) {
        if (!isFinished() && !yetToStart()) {
            Utils.drawTextureRegion(
                    batch,
                    Assets.instance.explosionAssets.explosion.getKeyFrame(Utils.secondsSince(startTime) - offset),
                    position.x-25,
                    position.y-50
            );
            /* batch.draw(Assets.instance.explosionAssets.explosion.getKeyFrame(Utils.secondsSince(startTime)- offset,false),
                    position.x,
                    position.y,
                    100,
                    100);  */
        }
    }

    public boolean yetToStart(){
        return Utils.secondsSince(startTime) - offset < 0;
    }

    public boolean isFinished() {
        float elapsedTime = Utils.secondsSince(startTime) - offset;
        return Assets.instance.explosionAssets.explosion.isAnimationFinished(elapsedTime);
    }
}
