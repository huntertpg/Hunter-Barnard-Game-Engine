package com.hunter.barnard.block;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hunter.barnard.debug.DebugUtil;

public class BlockBrick extends Block2D{

	public BlockBrick(String name, TextureRegion texture, int blockWidth, int blockHeight, DebugUtil debugUtil) {
		super(name, texture, blockWidth, blockHeight, debugUtil);
	}

	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	}
	
	

}
