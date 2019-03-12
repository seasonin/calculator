package Listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMouseListener extends MouseAdapter {

	@Override
	public void mouseEntered(MouseEvent e) { 
		((JButton)e.getSource()).setForeground(Color.red);
		((JButton)e.getSource()).setContentAreaFilled(false);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JButton) e.getComponent()).setForeground(Color.black);
		// 设置字体颜色为黑色
		((JButton)e.getSource()).setContentAreaFilled(true);
	}

}