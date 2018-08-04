package com.mygdx.game.spacebarrage.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by X on 2018. 05. 14..
 */

public class Assets implements Disposable,AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    private AssetManager assetManager;

    public ShipAssets shipAssets;
    public BackgroundAssets backgroundAssets;
    public LaserAssets laserAssets;
    public MeteorAssets meteorAssets;
    public ExplosionAssets explosionAssets;

    private Assets (){}

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);

        shipAssets = new ShipAssets(atlas);
        backgroundAssets = new BackgroundAssets(atlas);
        laserAssets = new LaserAssets(atlas);
        meteorAssets = new MeteorAssets(atlas);
        explosionAssets = new ExplosionAssets(atlas);
    }

    public class ShipAssets {

        public final AtlasRegion ship;

        public ShipAssets(TextureAtlas atlas){

            ship = atlas.findRegion(Constants.SHIP_SPRITE);

        }
    }


    public class BackgroundAssets {

        public final AtlasRegion background;

        public BackgroundAssets(TextureAtlas atlas){

            background = atlas.findRegion(Constants.BACKGROUND_SPRITE);
        }
    }


    public class LaserAssets{

        public final AtlasRegion laser;

        public LaserAssets(TextureAtlas atlas){
            laser = atlas.findRegion(Constants.LASER_SPRITE);
        }

    }

    public class MeteorAssets {

        public final AtlasRegion meteor;

        public MeteorAssets(TextureAtlas atlas){
            meteor = atlas.findRegion(Constants.METEOR_SPRITE);
        }
    }

    public class ExplosionAssets{

        public final Animation explosion;

        public ExplosionAssets(TextureAtlas atlas){

            Array<AtlasRegion> explosionRegions = new Array<AtlasRegion>();
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION1));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION2));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION3));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION4));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION5));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION6));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION7));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION8));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION9));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION10));
           /* explosionRegions.add(atlas.findRegion(Constants.EXPLOSION11));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION12));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION13));
            explosionRegions.add(atlas.findRegion(Constants.EXPLOSION14));*/


            explosion = new Animation(Constants.EXPLOSION_DURATION/explosionRegions.size,explosionRegions, Animation.PlayMode.NORMAL);
        }

    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
