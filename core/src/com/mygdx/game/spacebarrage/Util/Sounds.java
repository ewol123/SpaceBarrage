package com.mygdx.game.spacebarrage.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by X on 2018. 05. 17..
 */

public class Sounds {

    public Sound sound;
    public Sound laserSound;
    public Music music;

    public Sounds(){

    }

    public void playSound(String path){

         sound = Gdx.audio.newSound(Gdx.files.internal(path));
        sound.play();
    }

    public void playMusic(){
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/Platformer2.mp3"));
        music.setLooping(true);
        music.play();

    }

    public void dispose(){
        sound.dispose();
        music.dispose();
    }
}
