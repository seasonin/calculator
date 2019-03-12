package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Server.*;
import DAO.*;

public class ScienceListener implements ActionListener {
	
	SciencePanel scp;
	private Calculator clt = new Calculator();
	private String value = null;
	private String previousText;
	private StringBuffer sb; 
    private double num1, num2;
	private boolean sign = true;
	private boolean result = false;
	private ScienceListener slt;
	private int product;
	
	public ScienceListener() {} 
	public ScienceListener(SciencePanel scp) {
		this.scp = scp;
		this.slt = scp.slt;
	}
	//重构构造方法
	
	public void actionPerformed(ActionEvent e) {
		
		previousText = reader();//得到文本域的内容
		value = e.getActionCommand();//得到监听事件的内容
		if(slt.sign) 
			slt.sb = new StringBuffer();
		//如果sign为true，重新new一个实例，储存新数
		
		if(value.length() == 1 && value.equals("π")) {
			
				slt.sb = new StringBuffer();
				slt.sb.append(String.valueOf(Math.PI));
				writer(previousText + value);
				slt.sign = false;
				
				return;
		}
		
		if(value.length() == 1 && value.equals(".")) {
	
				slt.sb.append(".");
				writer(previousText + value);
				slt.sign = false;
				
				return;
		}
		
		if(value.length() == 1 && (Character.isDigit(value.charAt(0)))) {
		
			slt.sb.append(value);
			writer(previousText + value);
			slt.sign = false;
			
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("±")) {
			double b = Double.valueOf(slt.sb.toString())*(-1);
			writer(previousText.substring(0, previousText.length()-slt.sb.length())+b);
			slt.sb.delete(0, slt.sb.length());
			slt.sb.append(b);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("+")) {
			this.initialize("+", Calculator.mto.add);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("-")) {
			this.initialize("-", Calculator.mto.subtract);
			return;
		}
				
		if(slt.sb.length()>0 && value.equals("×")) {
			this.initialize("*", Calculator.mto.multiply);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("÷")) {
			this.initialize("/", Calculator.mto.divide);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("√")) {
			
			writer("√(" + reader() + ")\n" + Math.sqrt(Double.valueOf(slt.sb.toString())));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("³√")) {
			
			writer("³√(" + reader() + ")\n" + Math.cbrt(Double.valueOf(slt.sb.toString())));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("ln")) {
			
			writer("log(" + reader() + ")\n" + Math.log(Double.valueOf(slt.sb.toString())));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("lg")) {
			
			writer("lg(" + reader() + ")\n" + Math.log10(Double.valueOf(slt.sb.toString())));
			
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("sin")) {
			
			writer("sin(" + reader() + ")\n" + Math.sin(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("asin")) {
			
			writer("asin(" + reader() + ")\n" + Math.asin(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("sinh")) {
			
			writer("sin(" + reader() + ")\n" + Math.sinh(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("cos")) {
			
			writer("cos(" + reader() + ")\n" + Math.cos(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("acos")) {
			
			writer("acos(" + reader() + ")\n" + Math.acos(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("cosh")) {
			
			writer("cos(" + reader() + ")\n" + Math.cosh(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("tan")) {
			
			writer("tan(" + reader() + ")\n" + Math.tan(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("atan")) {
			
			writer("atan(" + reader() + ")\n" + Math.atan(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("tanh")) {
			
			writer("atan(" + reader() + ")\n" + Math.tanh(judge()));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("exp")) {
			writer("exp(" + reader() + ")\n" + Math.exp(Double.valueOf(slt.sb.toString())));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("x²")) {
			writer(reader() + "^2\n" + Math.pow(Double.valueOf(slt.sb.toString()), 2));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("x³")) {
			writer(reader() + "^3\n" + Math.pow(Double.valueOf(slt.sb.toString()), 3));
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("xⁿ")) {
			this.initialize("^", Calculator.mto.pow);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("10ⁿ")) {
			writer("10^" + reader() + "\n" + Math.pow(10, Double.valueOf(slt.sb.toString())));
			return;
		}
		
		if(slt.sb.length()>0 && (value.equals("Mod")||value.equals("%"))) {
			
			this.initialize("%", Calculator.mto.mod);
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("n!")) {
			int i;
			for(i=1, product=1; i<=Integer.valueOf(slt.sb.toString()); i++)
				 product *= i;
			writer(reader() + "! =\n" + product);
			return;
		}
		
		if(value.equals("CE")) {
			writer(reader().substring(0,reader().length()-slt.sb.length()));
			slt.sb.delete(0, slt.sb.length());
			slt.sign = true; 
			return;
		}
		
		if(value.equals("C")) {
			writer("");
			slt.num1 = 0;
			slt.num2 = 0;
			slt.sb.delete(0, slt.sb.length());
			slt.sign = true; 
			slt.result = false;
			return;
		}
		
		if(value.equals("←") && slt.sb.length()>=0) {
			try {
				slt.sb.deleteCharAt(slt.sb.length()-1);
				writer(reader().substring(0, reader().length()-1));
			}	catch(StringIndexOutOfBoundsException se) {}
			return;
		}
		
		if(slt.sb.length()>0 && value.equals("=")) {
			slt.num2 = Double.valueOf(slt.sb.toString());
			clt.initial(slt.num1, slt.num2);
			slt.sign = true; 
			slt.result = false;
			writer(reader() + "\n=" + clt.calculate() + "\n");
			return;
		}	
	}
	
	private void initialize(String sign, Calculator.method name) {
		if(slt.result) {
			slt.num2 = Double.valueOf(slt.sb.toString());
			clt.initial(slt.num1, slt.num2);
			slt.num1 = Double.valueOf(clt.calculate());
		}
		
		else
			slt.num1 = Double.valueOf(slt.sb.toString());
		
		writer(reader() + sign);
		Calculator.mto = name;
		slt.sign = true; 
		slt.result = true;
	}
	
	private double judge() {
		if(scp.radian.isSelected())
			return Double.valueOf(slt.sb.toString());
		//弧度
		else if(scp.angle.isSelected())
			return Math.toRadians(Double.valueOf(slt.sb.toString()));
		//角度
		else 
			return 9*Math.toRadians(Double.valueOf(slt.sb.toString()))/10;
		//梯度
	}
	
	private String reader() {
		return scp.ta.getText();
	}
	
	private void writer(String s) {
		scp.ta.setText(s);
	}
}