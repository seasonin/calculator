package Listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMouseListener extends MouseAdapter {

	@Override
	public void mouseEntered(MouseEvent e) { 
		((JButton)e.getSource()).setForeground(Color.red);
		//鼠标移进来时，设置按钮字体颜色为红色
		((JButton)e.getSource()).setContentAreaFilled(false);
		//设置按钮透明
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getComponent()).setForeground(Color.black);
		// 鼠标移走后，设置字体颜色为黑色
		((JButton)e.getSource()).setContentAreaFilled(true);
		//设置按钮可见
	}

}