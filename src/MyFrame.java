import java.awt.*;
import java.net.MalformedURLException;

import javax.swing.*;

class MyFrame extends JFrame {

	/**
	 * @author (name = "杨辛明")
	 */
	private static final long serialVersionUID = 1L;
	//默认声明serialVersionUID,避免由于版本兼容性带来的问题
	ITPanel itPanel;
	SciencePanel sciencePanel;
	RelationshipPanel relationshipPanel;
	JPanel cardPanel;
	CardLayout cardLayout;
	JMenuBar mb;
	JMenuItem science, it, relationship, quit, green, white, yellow, cyan, pink, clock, message;
	//声明成员变量
	
	MyFrame() {
		
		JMenu view = new JMenu("查看(V)");
		view.setIcon(new GetImage().creat("view.png", 20, 20));
		JMenu set = new JMenu("设置(S)");
		JMenu edit = new JMenu("编辑(E)");
		edit.setIcon(new GetImage().creat("edit.png", 20, 20));
		JMenu help = new JMenu("帮助(H)");
		help.setIcon(new GetImage().creat("help.png", 20, 20));
		//分别对菜单实例化，并设置相应的图标
		science = new JMenuItem("科学型");
		it = new JMenuItem("IT型");
		relationship = new JMenuItem("关系型");
		quit = new JMenuItem("退出(Q)");
		green = new JMenuItem("绿色");
		white = new JMenuItem("白色");
		yellow = new JMenuItem("黄色");
		cyan = new JMenuItem("青色");
		pink = new JMenuItem("粉色");
		clock = new JMenuItem("系统时间");
		message = new JMenuItem("关于 (A)");
		//分别对各菜单项实例化
		mb = new JMenuBar();
		mb.add(view);
		mb.add(edit);
		mb.add(help);
		//实例化菜单栏，把菜单加入到菜单栏中
		view.add(science);
		science.addActionListener(new MenuListen(this));
		view.add(it);
		it.addActionListener(new MenuListen(this));
		view.add(relationship);
		relationship.addActionListener(new MenuListen(this));
		view.add(quit);
		quit.setBackground(Color.RED);
		quit.addActionListener(new MenuListen(this));
		green.setBackground(Color.GREEN);
		green.addActionListener(new MenuListen(this));
		set.add(green);
		white.setBackground(Color.WHITE);
		white.addActionListener(new MenuListen(this));
		set.add(white);
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(new MenuListen(this));
		set.add(yellow);
		cyan.setBackground(Color.CYAN);
		cyan.addActionListener(new MenuListen(this));
		set.add(cyan);
		pink.setBackground(Color.PINK);
		pink.addActionListener(new MenuListen(this));
		set.add(pink);
		//set.addActionListener(new MenuListen(this));
		edit.add(set);
		clock.addActionListener(new MenuListen(this));
		help.add(clock);
		message.addActionListener(new MenuListen(this));
		help.add(message);
		//把菜单项加入到菜单中，并注册MenuLListen监听器
		//其中green,yellow,cyan,pink,white菜单项设置为相应的背景色
	
		itPanel = new ITPanel();
		//实例化itPanel，用于装载it型计算器，可进行进制转换
		sciencePanel = new SciencePanel();
		//实例化sciencePanel，用于装载科学计算器，可进行数学上多种运算
		relationshipPanel = new RelationshipPanel();
		//实例化relationshipPanel，用于计算亲戚称呼关系
		//new MenuListen(this).setColor(Color.GREEN);
		//new MenuListen，调用其setColor方法，使计算器整个面板显示青色
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.add("Science", sciencePanel);
		cardPanel.add("ITPanel", itPanel);
		cardPanel.add("relationshipPanel", relationshipPanel);
		//new CradLayout，是三种计算器为卡布布局，可通过其show方法显示特定的Panel
		//把三种Panel依次加入cardLayout中
		getContentPane().add(mb, BorderLayout.NORTH);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		//把菜单栏加入到BorderLayout的北边，cardPanel加入到BorderLayout的中间
		setTitle("科学型");
		//第一张默认卡布为sciencePanel，故设计MyFrame的标题为科学型
		setBounds(500, 200, 490, 430);
		//设置出现位置
		setVisible(true);
		//设置可见
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//正常退出
	}
	
	public static void main(String args[]) {
		new MyFrame();
		//在main方法启动MyFrame  
	}
	
}
