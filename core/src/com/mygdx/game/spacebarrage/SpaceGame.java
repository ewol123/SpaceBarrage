package com.mygdx.game.spacebarrage;

import com.badlogic.gdx.Game;

public class SpaceGame extends Game {

	@Override
	public void create() {
	setScreen(new GameplayScreen());
	}
}
