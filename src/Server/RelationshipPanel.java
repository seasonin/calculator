package Server;

import java.awt.*;
import javax.swing.*;
import Listener.*;

public class RelationshipPanel extends JPanel{
	
	public JTextArea rta;
	private JButton rsb;
	private JPanel rt;
	public JPanel btPanel;
	public TimePanel timePanel;
	public boolean pressed = false;
	public RelationshipListener rsl;
	
	public RelationshipPanel() {
		
		//各变量实例化
		rsl = new RelationshipListener();
		rta = new JTextArea("我的");
		rt = new JPanel();
		timePanel = new TimePanel();
		btPanel = new JPanel();
		
		setLayout(new GridLayout(2, 1));
		add(rt);
		add(btPanel);
		rt.setLayout(new BorderLayout());
		rt.add(rta, BorderLayout.CENTER);
		//把rta面板加在中间
		rt.add(timePanel, BorderLayout.SOUTH);
		btPanel.setLayout(new GridLayout(3, 4, 2, 2));
		String[] address = {"夫", "妻", "←", "C", "父",
			   "母", "子", "女", "兄", "弟", "姐", "妹"};
		//各按钮键值
		
		for(String i : address) {
			rsb = new JButton(i);
			//实例化按钮
			if(i=="←")
				rsb.setBackground(Color.green);
				//设置按钮背景为绿色
			else if(i=="C")
				rsb.setBackground(Color.yellow);
			rsb.addActionListener(new RelationshipListener(this));
			//注册RelationshipListener监听器
			rsb.addMouseListener(new MyMouseListener());
			//注册MyMouseListener监听器
			btPanel.add(rsb);
			//把按钮加载在btPanel中
		}
	}
}
