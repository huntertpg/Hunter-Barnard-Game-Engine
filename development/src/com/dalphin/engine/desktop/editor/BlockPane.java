package com.dalphin.engine.desktop.editor;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.managers.AssetManager;


public class BlockPane {
	
	private AssetManager assetManager;
	private JPanel pane;
	private BufferedImage image;
	private Image icon;
	private DalphinButton button;
	private EditorTheme editorTheme;
	private ArrayList<DalphinButton> buttons = new ArrayList<DalphinButton>();
	
	public BlockPane(AssetManager assetManager) {
		pane = new JPanel();
		try {
			for(int i = 0; i < assetManager.blockManager().blocks.size(); i++) {
				String path = ((FileTextureData)assetManager.blockManager().getBlock(i).getTexture().getTextureData()).getFileHandle().path();
				image = ImageIO.read(new File("../core/assets/" + path));
				image = image.getSubimage(assetManager.blockManager().getBlock(i).getTextureRegion().getRegionX(), 
						assetManager.blockManager().getBlock(i).getTextureRegion().getRegionY(), 
						assetManager.blockManager().getBlock(i).getTextureRegion().getRegionWidth(), assetManager.blockManager().getBlock(i).getTextureRegion().getRegionHeight());
				icon = image.getScaledInstance(image.getWidth() * 2, image.getHeight() * 2, Image.SCALE_DEFAULT);
				if(editorTheme == null) {
					button = new DalphinButton(assetManager.blockManager().getBlock(i).getName(),new ImageIcon(icon), null);
					
				}else {
					button = new DalphinButton(assetManager.blockManager().getBlock(i).getName(),new ImageIcon(icon), editorTheme);	
					
				}
				button.setPreferredSize(new Dimension(100, 100));
				button.setHorizontalTextPosition(JButton.CENTER);
				button.setVerticalTextPosition(JButton.BOTTOM);
				button.setToolTipText(assetManager.blockManager().getBlock(i).getName());
				buttons.add(button);
				pane.add(button);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return this.pane;
	}
	
	public void setEditorTheme(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setEditorTheme(editorTheme);
		}
	}
}
