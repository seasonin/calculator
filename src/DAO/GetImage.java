package DAO;

import java.awt.*;
import javax.swing.*;

public class GetImage{
	
	public ImageIcon creat(String name, int width, int height) {
		String path = "./src/Image/" + name;
		//设置./src/Image/路径下的图标路径
		ImageIcon image = new ImageIcon(path);
		//new ImageIcon实例
		image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		//设置宽为weight，高为height的图标
		return image;
	}
}
