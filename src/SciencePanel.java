import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicButtonUI;

public class SciencePanel extends JPanel{

	JPanel contextPanel, buttonPanel,  anglePanel, at;
	TimePanel  timePanel;
	private JButton button;
	JTextArea ta;
	JRadioButton radian, angle,  grad;
	ScienceListener mal;
	//记录数据之用，减少分配内存，提高程序效率
	
	SciencePanel() {
		radian = new JRadioButton("弧度", true);
		angle = new JRadioButton("角度");
		grad = new JRadioButton("梯度");
		mal = new ScienceListener();
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		contextPanel = new JPanel();
		buttonPanel = new JPanel();
		timePanel = new TimePanel();
		anglePanel = new JPanel();
		at = new JPanel();
		contextPanel.setLayout(new BorderLayout());
		contextPanel.add(sp, BorderLayout.CENTER);
		contextPanel.add(at, BorderLayout.SOUTH);
		at.setLayout(new GridLayout(1, 2));
		at.add(anglePanel);
		at.add(timePanel);
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
		//timePanel.add(new JLabel(Calendar.getInstance().getTime().toString()));
		
		buttonPanel.setLayout(new GridLayout(6, 7, 2, 2));
		//buttonPanel.setBorder(BorderFactory.createTitledBorder("分组框")); //设置面板边框，实现分组框的效果，此句代码为关键代码  

		String value[] = {"x²", "x³", "xⁿ", "√", "³√","CE",
				"C","ln", "lg", "exp", "←", "%", "±", "+", 
				"sin", "asin", "sinh", "7", "8",  "9","-", 
				"cos", "acos", "cosh", "4", "5", "6", "×", 
				"tan", "atan", "tanh", "1", "2", "3", "÷", 
				"Mod", "n!", "10ⁿ", "0", ".", "π", "=" };
		
		for(String i : value) {
			
			button = new JButton(i);
			if(i.equals("CE") || i.equals("C")) 
				button.setBackground(Color.pink);
			button.addActionListener(new ScienceListener(this));
			button.addMouseListener(new MyMouseListener());
			buttonPanel.add(button);
		}
		
		this.setLayout(new GridLayout(2, 1));
		this.add(contextPanel);
		this.add(buttonPanel);
	}
}
