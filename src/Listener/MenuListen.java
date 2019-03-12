package Listener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import Server.*;
import View.*;
import DAO.*;


public class MenuListen implements ActionListener {
	
	private MyFrame mf;
	private String value;
	
	public MenuListen(MyFrame mf) {
		this.mf = mf;
		//通过构造方法使得本类的mf等于参数mf
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		value = e.getActionCommand();
		//通过getActionCommand方法得到监听对象的值，并赋给value
		if(value.equals("科学型")) {
			mf.cardLayout.show(mf.cardPanel, "Science");
			//使得卡布显示SciencePanel
			mf.setTitle("科学型");
			//设置标题为科学型
			mf.setSize(490, 430);
			return;
		}
		
		if(value.equals("IT型")) {
			mf.cardLayout.show(mf.cardPanel, "ITPanel");
			//设置卡布显示ITPanel
			mf.setTitle("IT型");
			//设置标题为IT型
			mf.setSize(400, 250);
			return;
		}
		
		if(value.equals("关系型")) {
			mf.cardLayout.show(mf.cardPanel, "relationshipPanel");
			//设置卡布为relationshipPanel
			mf.setTitle("关系型");
			//设置标题为关系型
			mf.setSize(320, 250);
			return;
		}
		
		if(value.equals("退出(Q)")) { 
			mf.setVisible(false);
			//如果按了退出的菜单项，把MyFrame设置为不可见
			return;
		}
		
		if(value.equals("绿色")) {
			this.setColor(Color.GREEN);
			//选着绿色菜单项，设置背景色为绿色
			return;
		}
		
		if(value.equals("白色")) {
			this.setColor(Color.WHITE);
			//选着白色菜单项，设置背景色为白色
			return;
		}
		
		if(value.equals("黄色")) {
			this.setColor(Color.YELLOW);
			//选着黄色菜单项，设置背景色为黄色
			return;
		}
		
		if(value.equals("青色")) {
			this.setColor(Color.CYAN);
			//选着青色菜单项，设置背景色为青色
			return;
		}
		
		if(value.equals("粉色")) {
			this.setColor(Color.PINK);
			//选着粉色菜单项，设置背景色为粉色
			return;
		}
		
		if(value.equals("蓝色")) {
			this.setColor(Color.BLUE);
			//选着蓝色菜单项，设置背景色为蓝色
			return;
		}
		
		if(value.equals("增大")) {
			mf.fontSize += 5;
			this.setFont(mf.fontSize);
			//选着蓝色菜单项，设置背景色为蓝色
			return;
		}
		
		if(value.equals("减小")) {
			mf.fontSize -= 5;
			this.setFont(mf.fontSize);
			//选着蓝色菜单项，设置背景色为蓝色
			return;
		}
		
		if(value.equals("关于 (A)")) 
			//通过把图标加入到JLable中再加入到JFrame中，显示开发者信息
			JOptionPane.showMessageDialog(null, new JLabel(new GetImage().creat("developer.png", 500, 450)), "开发者信息", JOptionPane.PLAIN_MESSAGE);
		
		if(value.equals("使用(U)")) 
			//通过把图标加入到JLable中再加入到JFrame中，显示开发者信息
			JOptionPane.showMessageDialog(null, new JLabel(new GetImage().creat("use.png", 500, 250)), "如何使用", JOptionPane.PLAIN_MESSAGE);		
		
		if(value.equals("系统时间")) 
			JOptionPane.showMessageDialog(null, new TimePanel());
			//调用JOptionPane的shoeMessageDialog方法显示时间
			//其中TimePanel可获得动态的时间
	}
	
	private void setFont(int fontSize) {
		//设置字体为宋体，大小为fonSize
		mf.sciencePanel.ta.setFont(new Font("宋体", Font.PLAIN, fontSize));
		mf.relationshipPanel.rta.setFont(new Font("宋体", Font.PLAIN,fontSize));
		mf.itPanel.ita.setFont(new Font("宋体", Font.PLAIN, fontSize));
	}
	
	private void setColor(Color color) {
		//该方法可把菜单栏、各相应的Panel设置为参数color的颜色
		mf.mb.setBackground(color);
		mf.sciencePanel.at.setBorder(BorderFactory.createLineBorder(color));
		mf.sciencePanel.buttonPanel.setBorder(BorderFactory.createLineBorder(color));
		mf.sciencePanel.buttonPanel.setBackground(color);
		mf.itPanel.radixPanel.setBorder(BorderFactory.createLineBorder(color));
		mf.itPanel.btp.setBackground(color);
		mf.relationshipPanel.timePanel.setBorder(BorderFactory.createLineBorder(color));
		mf.relationshipPanel.btPanel.setBackground(color);
		return;
	}
}
