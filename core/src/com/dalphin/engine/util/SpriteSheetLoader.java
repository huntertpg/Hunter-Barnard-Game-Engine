package com.dalphin.engine.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.loaders.TextureLoader;

public class SpriteSheetLoader {
	
	private TextureLoader textureLoader;
	/**
	 * 
	 * @param textureLoader
	 */
	public SpriteSheetLoader(TextureLoader textureLoader) {
		this.textureLoader = textureLoader;
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @return sprites
	 */
	public TextureRegion[][] loadSpriteSheet(String spriteSheet, int rows, int columns, int spriteWidth, int spriteHeight){
		TextureRegion[][] sprites = TextureRegion.split(textureLoader.loadTexture(spriteSheet), spriteWidth, spriteHeight);
		return sprites;
	}

}
