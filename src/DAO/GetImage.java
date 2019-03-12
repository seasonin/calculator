package DAO;

import java.awt.*;
import javax.swing.*;

public class GetImage{
	
	public ImageIcon creat(String name, int width, int height) {
		String path = "./src/Image/" + name;
		ImageIcon image = new ImageIcon(path);
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		return image;
	}
}
