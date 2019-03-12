package Server;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;
import Listener.*;

public class ITPanel extends JPanel implements ActionListener{
	
	//声明变量
	private JRadioButton two, eight, ten, sixteen;
	public JTextArea ita;
	private JScrollPane isp;
    private JPanel ctp;
	public JPanel radixPanel, btp;
	private JButton bt;
	private double result = 0;
	private StringBuffer stb;
	private String value = "=", charactor;
	boolean pressEquals = false, newdigit = true;
	//pressEquals判断是否为非第一次按运算符，为false时，赋值给result，否则把运算结果赋值给result
	//newdigit为true时，重新new stb实例
	
	public ITPanel() {
		
		//实例化各变量
		stb = new StringBuffer();
		ita = new JTextArea();
		isp = new JScrollPane(ita);
		radixPanel = new JPanel();
		btp = new JPanel();
		ctp = new JPanel();
		radixPanel.setLayout(new GridLayout(1, 4));
		btp.setLayout(new GridLayout(3, 6, 2, 2));
		ctp.setLayout(new BorderLayout());
		ctp.add(isp, BorderLayout.CENTER);
		ctp.add(radixPanel, BorderLayout.SOUTH);
		
		//实例化单选按钮
		two = new JRadioButton("二进制");
		eight = new JRadioButton("八进制");
		ten = new JRadioButton("十进制", true);
		//设置十进制按钮为初选
		sixteen = new JRadioButton("十六进制");
		
		//把单选按钮加载在同一个bgtwo组中和radixPanel中
		ButtonGroup bgtwo = new ButtonGroup();
		bgtwo.add(two);
		radixPanel.add(two);
		bgtwo.add(eight);
		radixPanel.add(eight);
		bgtwo.add(ten);
		radixPanel.add(ten);
		bgtwo.add(sixteen);
		radixPanel.add(sixteen);
		
		String[] i = {"+", "-", "×", "÷", "%", "√", "←", "5", "6", "7", "8", "9", "1/x", "C", "0", "1","2",
				"3", "4", ".", "="};
		//定义按钮键值
		
		for(String j : i) {
			//实例化键值为i的按钮
			bt = new JButton(j);
			//设置按钮背景色
			if("+-×÷%√".indexOf(j)>=0)
				bt.setBackground(Color.green);
			else if("←C=".indexOf(j)>=0)
				bt.setBackground(Color.yellow);
			//注册监听器
			bt.addActionListener(this);
			bt.addMouseListener(new MyMouseListener());
			btp.add(bt);
		}
		
		this.setLayout(new GridLayout(2, 1));
		this.add(ctp);
		this.add(btp);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		//charactor得到事件值
		charactor = e.getActionCommand();
		//previousText得到文本域内容
		String previousText = reader();
		//newdigit为true时，重新new stb实例
		if(newdigit)
			stb = new StringBuffer();
		
		if("0123456789.".indexOf(charactor)>=0) {
			//文本域打印上数字
			writer(previousText + charactor);
			//把数字加在stb中
			stb.append(charactor);
			newdigit = false;
		}
		
		else if(charactor.equals("←")) {
			if(stb.length()!=0) {
				//文本域字符串减少一个字符
				writer(previousText.substring(0, previousText.length()-1));
				//stb舍去最后一个数字
				stb.deleteCharAt(stb.length()-1);
			}
		}
		
		else if(charactor.equals("C")) {
			//清空文本域	
			writer("");
			pressEquals = false;
			newdigit = true;
		}
		
		else if(charactor.equals("=")) {
			if(pressEquals) {
				handle(previousText);
				//选择十进制单选按钮，直接打印结果
				if(ten.isSelected())
					writer(previousText + "\n=" + result);
				//非选择十进制单选按钮，getDigit方法判断打印结果进制数
				else 
					writer(previousText + "\n=" + getDigit((int)result));
				pressEquals = false;
			}
			else {
				//没运算符按下等号，调用init方法赋值给stb，并输出进制数
				init(previousText);
				writer(previousText + "\n=" + getDigit((int)result));
				//向文本域打印结果
			}
		}
		
		else {
			//按了求解运算符
			if(pressEquals) {
				handle(previousText);
				//调用handle方法计算结果
				if("√".equals(charactor))
					writer(charactor+"("+previousText+")");
				else if("1/x".equals(charactor))
					writer("1/(" + previousText+")");
				else
					writer(previousText + charactor);
				//打印运算符
			}
				
			else {
			//第一次求解运算符
				if("√".equals(charactor))
					writer(charactor+"("+previousText+")");
				else if("1/x".equals(charactor))
					writer("1/(" + previousText+")");
				else
					writer(previousText + charactor);
					//打印各运算符
				init(previousText);	
			}
			
			newdigit = true;
			pressEquals = true;
			value = charactor;
		}
	}
	
	private void handle(String previousText) {
		if(value.equals("+"))
			//加法运算
			result = Double.valueOf((new BigDecimal(result).add(new BigDecimal(stb.toString()))).toString());
			
		else if(value.equals("-")) 
			//减法运算
			result = Double.valueOf((new BigDecimal(result).subtract(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("×")) 
			//乘法运算
			result = Double.valueOf((new BigDecimal(result).multiply(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("÷"))
			if(Double.valueOf(stb.toString()) == 0)
				//除数为零，报错
				writer("除数不能为零");
			else
				//除法运算
				result = Double.valueOf((new BigDecimal(result).divide(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("%"))
			//求余运算
			result %= Double.valueOf(stb.toString());
		
		else if(value.equals("√"))
			//根号运算
			result = Math.sqrt(result);
		
		else if(value.equals("1/x"))
			if(result == 0)
				writer("除数不能为零");
			else 
				result = 1/result;
	}
	
	private String reader() {
		return ita.getText();
		//返回文本域内容
	}
	
	private void writer(String s) {
		ita.setText(s);
		//设置文本域内容
	}
	
	private void init(String previousText) {
		if(stb.length() > 0)
			result = Double.valueOf(stb.toString());
	}
	private String getDigit(int numble) {
	
	if(two.isSelected()) 
		return Integer.toBinaryString(numble);
		//返回二进制
	
	else if(eight.isSelected())
		return Integer.toOctalString(numble);
		//返回八进制
	
	else if(ten.isSelected())
		return String.valueOf(numble);
		//返回十进制
	
	else
		return Integer.toHexString(Integer.valueOf(numble));
		//返回十六进制
	}    
}
