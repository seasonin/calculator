package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Listener.*;

public class SciencePanel extends JPanel{

	public JPanel buttonPanel, anglePanel, at, contextPanel;
	public TimePanel  timePanel;
	private JButton button;
	public JTextArea ta;
	public JRadioButton radian, angle, grad;
	public ScienceListener slt;
	//slt记录数据之用，避免重复使用静态变量，减少分配内存，提高程序效率
	
	public SciencePanel() {
		radian = new JRadioButton("弧度", true);
		angle = new JRadioButton("角度");
		grad = new JRadioButton("梯度");
		//实例化单选按钮，并设置弧度为初选值
		slt = new ScienceListener();
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		contextPanel = new JPanel();
		buttonPanel = new JPanel();
		timePanel = new TimePanel();
		anglePanel = new JPanel();
		at = new JPanel();
		//实例化给个JPanel
		contextPanel.setLayout(new BorderLayout());
		contextPanel.add(sp, BorderLayout.CENTER);
		contextPanel.add(at, BorderLayout.SOUTH);
		//把带有滚动条的文本域加在contextPanel的中间，把at加在南边
		at.setLayout(new GridLayout(1, 2));
		at.add(anglePanel);
		at.add(timePanel);
		//把角度面板和时间面板加入到at面板中
		anglePanel.setLayout(new GridLayout(1, 3));
		ButtonGroup bgone = new ButtonGroup();
		radian.addActionListener(new ScienceListener(this));
		bgone.add(radian);
		anglePanel.add(radian);
		angle.addActionListener(new ScienceListener(this));
		bgone.add(angle);
		anglePanel.add(angle);
		grad.addActionListener(new ScienceListener(this));
		bgone.add(grad);
		anglePanel.add(grad);
		//把弧度、角度、梯度按钮加入到角度面板和按钮组中，并注册ScienceListner监听器
		
		buttonPanel.setLayout(new GridLayout(6, 7, 2, 2));

		String value[] = {"x²", "x³", "xⁿ", "√", "³√","CE",
				"C","ln", "lg", "exp", "←", "%", "±", "+", 
				"sin", "asin", "sinh", "7", "8",  "9","-", 
				"cos", "acos", "cosh", "4", "5", "6", "×", 
				"tan", "atan", "tanh", "1", "2", "3", "÷", 
				"Mod", "n!", "10ⁿ", "0", ".", "π", "=" };
		//定义按钮键值
		
		for(String i : value) {
			button = new JButton(i);
			//new 以i为名的按钮
			if(i.equals("CE") || i.equals("C")) 
				button.setBackground(Color.pink);
				//设置C、CE按钮为粉红色
			button.addActionListener(new ScienceListener(this));
			button.addMouseListener(new MyMouseListener());
			buttonPanel.add(button);
			//button注册监听器，加入到buttonPanel中
		}
		
		this.setLayout(new GridLayout(2, 1));
		this.add(contextPanel);
		this.add(buttonPanel);
	}
}
