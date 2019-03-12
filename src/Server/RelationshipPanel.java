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
		
		rsl = new RelationshipListener();
		rta = new JTextArea("我的");
		rt = new JPanel();
		timePanel = new TimePanel();
		//timePanel.setBackground();
		btPanel = new JPanel();
		//btPanel.setBackground(Color,);
		setLayout(new GridLayout(2, 1));
		add(rt);
		add(btPanel);
		rt.setLayout(new BorderLayout());
		rt.add(rta, BorderLayout.CENTER);
		rt.add(timePanel, BorderLayout.SOUTH);
		btPanel.setLayout(new GridLayout(3, 4, 2, 2));
		String[] address = {"夫", "妻", "←", "C", "父",
			   "母", "子", "女", "兄", "弟", "姐", "妹"};
		for(String i : address) {
			rsb = new JButton(i);
			if(i=="←")
				rsb.setBackground(Color.green);
			else if(i=="C")
				rsb.setBackground(Color.yellow);
			rsb.addActionListener(new RelationshipListener(this));
			rsb.addMouseListener(new MyMouseListener());
			btPanel.add(rsb);
		}
	}
}
