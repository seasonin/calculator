
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.swing.*;

public class ITPanel extends JPanel implements ActionListener{
	
	private JRadioButton two, eight, ten, sixteen;
	private JTextArea ita;
	private JScrollPane isp;
    JPanel ctp, radixPanel, btp;
	private JButton bt;
	private double result = 0;
	private StringBuffer stb;
	private String value = "=", charactor;
	boolean sign = false, newdigit = true;
	
	ITPanel() {
		
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
		two = new JRadioButton("二进制");
		eight = new JRadioButton("八进制");
		ten = new JRadioButton("十进制", true);
		sixteen = new JRadioButton("十六进制");
		ButtonGroup bgtwo = new ButtonGroup();
		
		//two.addActionListener(this);
		bgtwo.add(two);
		radixPanel.add(two);
		//eight.addActionListener(this);
		bgtwo.add(eight);
		radixPanel.add(eight);
		//ten.addActionListener(this);
		bgtwo.add(ten);
		radixPanel.add(ten);
		//sixteen.addActionListener(this);
		bgtwo.add(sixteen);
		radixPanel.add(sixteen);
		
		String[] i = {"+", "-", "×", "÷", "%", "√", "←", "5", "6", "7", "8", "9", "1/x", "C", "0", "1","2",
				"3", "4", ".", "="};
		
		for(String j : i) {
			/*if("+-multiplydivide%".indexOf(j)>=0) {
				bt = new JButton(new GetImage().creat(j+".png", 50, 30));
				bt.setContentAreaFilled(false);
			}*/
			//else
			bt = new JButton(j);
			if("+-×÷%√".indexOf(j)>=0)
				bt.setBackground(Color.green);
			else if("←C=".indexOf(j)>=0)
				bt.setBackground(Color.yellow);
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
	
		charactor = e.getActionCommand();
		String previousText = reader();
		if(newdigit)
			stb = new StringBuffer();
		
		if("0123456789.".indexOf(charactor)>=0) {
			writer(previousText + charactor);
			stb.append(charactor);
			newdigit = false;
		}
		
		else if(charactor.equals("←")) {
			if(stb.length()!=0) {
				writer(previousText.substring(0, previousText.length()-1));
				stb.deleteCharAt(stb.length()-1);
			}
		}
		
		else if(charactor.equals("C")) {
				writer("");
				sign = false;
				newdigit = true;
		}
		
		else if(charactor.equals("=")) {
			if(sign) {
				handle(previousText);
				if(ten.isSelected())
					writer(previousText + "\n=" + result);
				else 
					writer(previousText + "\n=" + getDigit((int)result));
				sign = false;
			}
			else {
				init(previousText);
				writer(previousText + "\n=" + getDigit((int)result));
			}
		}
		
		else {
		//按了求解运算符
			if(sign) {
				handle(previousText);
				writer(previousText + charactor);
			}
				
			else {
			//第一次求解运算符
				writer(previousText + charactor);
				init(previousText);	
			}
			
			newdigit = true;
			sign = true;
			value = charactor;
		}
	}
	
	private void handle(String previousText) {
		if(value.equals("+"))
			//writer(previousText);
			result = Double.valueOf((new BigDecimal(result).add(new BigDecimal(stb.toString()))).toString());
			
		
		else if(value.equals("-")) 
			result = Double.valueOf((new BigDecimal(result).subtract(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("×")) 
			result = Double.valueOf((new BigDecimal(result).multiply(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("÷")) 
			if(Double.valueOf(stb.toString()) == 0)
				writer("除数不能为零");
			else
				result = Double.valueOf((new BigDecimal(result).divide(new BigDecimal(stb.toString()))).toString());
		
		else if(value.equals("%"))
			result %= Double.valueOf(stb.toString());
		
		else if(value.equals("√"))
			result = Math.sqrt(result);
		
		else if(value.equals("1/x"))
			if(result == 0)
				writer("除数不能为零");
			else 
				result = 1/result;
	}
	
	private String reader() {
		return ita.getText();
	}
	
	private void writer(String s) {
		ita.setText(s);
	}
	
	private void init(String previousText) {
		if(stb.length() > 0)
			result = Double.valueOf(stb.toString());
	}
	private String getDigit(int numble) {
	
	if(two.isSelected()) 
		return Integer.toBinaryString(numble);
	
	else if(eight.isSelected())
		return Integer.toOctalString(numble);
	
	else if(ten.isSelected())
		return String.valueOf(numble);
	
	else
		return Integer.toHexString(Integer.valueOf(numble));
	}    
}
