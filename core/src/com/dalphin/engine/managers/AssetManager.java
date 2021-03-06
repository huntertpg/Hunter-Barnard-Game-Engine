/* Author: Hunter Barnard
 * 
 * This class will be used for loading all of the asset managers and their contents
 * This will be the goto manager for loading and unloading textures to make thing simple
 * 
 */

package com.dalphin.engine.managers;

import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.debug.DebugUtil;

public class AssetManager {
	
	private TextureManager textureManager;
	private ItemManager itemManager;
	private BlockManager blockManager;
	private AnimationManager animationManager;
	private DebugUtil debug;
	private String blockTexturePaths;
	/**
	 */
	public AssetManager() {
		this.debug = new DebugUtil();
		debug.enableDebugging(true);
		debug.Debug();
	}
	/**
	 * 
	 */
	public void InitManagers() {

		textureManager = new TextureManager(debug);
		textureManager.loadAllTextures();
		itemManager = new ItemManager(textureManager, debug);
		blockManager = new BlockManager(textureManager, debug);
		animationManager = new AnimationManager(textureManager);
		
	} 
	/**
	 * 
	 */
	public void dispose() {
		textureManager.disposeAllTextures();
	}
	/**
	 * 
	 * @return textureManager
	 */
	public TextureManager textureManager() {
		return this.textureManager;
	}
	/**
	 * 
	 * @return itemManager
	 */
	public ItemManager itemManager() {
		return this.itemManager;
	}
	/**
	 * 
	 * @return blockManager
	 */
	public BlockManager blockManager() {
		return this.blockManager;
	}
	/**
	 * 
	 * @return assetManager
	 */
	public AnimationManager animationManager() {
		return this.animationManager;
	}
	
	public DebugUtil getDebugUtil() {
		return this.debug;
	}
	

}
