import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class ScienceListener implements ActionListener {
	
	SciencePanel scp;
	Calculator clt = new Calculator();
	String value = null;
	String previousText;
	JButton button;
	StringBuffer sb; 
	double num1, num2;
	boolean sign = true;
	boolean result = false;
	ScienceListener mal;
	private int product;
	
	ScienceListener() {} 
	ScienceListener(SciencePanel scp) {
		this.scp = scp;
		this.mal = scp.mal;
	}
	
	public void actionPerformed(ActionEvent e) {
		previousText = reader();

		value = e.getActionCommand();
		if(mal.sign) 
			mal.sb = new StringBuffer();
		/*
		if(mf..isSelected()) {
			writer(this.getDigit(mal.sb.toString()));
			return;
		}
		*/
		if(value.length() == 1 && value.equals("π")) {
			
				mal.sb = new StringBuffer();
				mal.sb.append(String.valueOf(Math.PI));
				writer(previousText + value);
				mal.sign = false;
				
				return;
		}
		
		if(value.length() == 1 && value.equals(".")) {
	
				mal.sb.append(".");
				writer(previousText + value);
				mal.sign = false;
				
				return;
		}
		
		if(value.length() == 1 && (Character.isDigit(value.charAt(0)))) {
		
			mal.sb.append(value);
			writer(previousText + value);
			mal.sign = false;
			
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("±")) {
			double b = Double.valueOf(mal.sb.toString())*(-1);
			writer(previousText.substring(0, previousText.length()-mal.sb.length())+b);
			mal.sb.delete(0, mal.sb.length());
			mal.sb.append(b);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("+")) {
			this.initialize("+", Calculator.mto.add);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("-")) {
			this.initialize("-", Calculator.mto.subtract);
			return;
		}
				
		if(mal.sb.length()>0 && value.equals("×")) {
			this.initialize("*", Calculator.mto.multiply);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("÷")) {
			this.initialize("/", Calculator.mto.divide);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("√")) {
			
			writer("√(" + reader() + ")\n" + Math.sqrt(Double.valueOf(mal.sb.toString())));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("³√")) {
			
			writer("³√(" + reader() + ")\n" + Math.cbrt(Double.valueOf(mal.sb.toString())));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("ln")) {
			
			writer("log(" + reader() + ")\n" + Math.log(Double.valueOf(mal.sb.toString())));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("lg")) {
			
			writer("lg(" + reader() + ")\n" + Math.log10(Double.valueOf(mal.sb.toString())));
			
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("sin")) {
			
			writer("sin(" + reader() + ")\n" + Math.sin(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("asin")) {
			
			writer("asin(" + reader() + ")\n" + Math.asin(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("sinh")) {
			
			writer("sin(" + reader() + ")\n" + Math.sinh(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("cos")) {
			
			writer("cos(" + reader() + ")\n" + Math.cos(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("acos")) {
			
			writer("acos(" + reader() + ")\n" + Math.acos(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("cosh")) {
			
			writer("cos(" + reader() + ")\n" + Math.cosh(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("tan")) {
			
			writer("tan(" + reader() + ")\n" + Math.tan(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("atan")) {
			
			writer("atan(" + reader() + ")\n" + Math.atan(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("tanh")) {
			
			writer("atan(" + reader() + ")\n" + Math.tanh(judge()));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("exp")) {
			writer("exp(" + reader() + ")\n" + Math.exp(Double.valueOf(mal.sb.toString())));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("x²")) {
			writer(reader() + "^2\n" + Math.pow(Double.valueOf(mal.sb.toString()), 2));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("x³")) {
			writer(reader() + "^3\n" + Math.pow(Double.valueOf(mal.sb.toString()), 3));
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("xⁿ")) {
			this.initialize("^", Calculator.mto.pow);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("10ⁿ")) {
			writer("10^" + reader() + "\n" + Math.pow(10, Double.valueOf(mal.sb.toString())));
			return;
		}
		
		if(mal.sb.length()>0 && (value.equals("Mod")||value.equals("%"))) {
			
			this.initialize("%", Calculator.mto.mod);
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("n!")) {
			int i;
			for(i=1, product=1; i<=Integer.valueOf(mal.sb.toString()); i++)
				 product *= i;
			writer(reader() + "! =\n" + product);
			return;
		}
		
		if(value.equals("CE")) {
			writer(reader().substring(0,reader().length()-mal.sb.length()));
			mal.sb.delete(0, mal.sb.length());
			mal.sign = true; 
			return;
		}
		
		if(value.equals("C")) {
			writer("");
			mal.num1 = 0;
			mal.num2 = 0;
			mal.sb.delete(0, mal.sb.length());
			mal.sign = true; 
			mal.result = false;
			return;
		}
		
		if(value.equals("←") && mal.sb.length()>=0) {
			try {
				mal.sb.deleteCharAt(mal.sb.length()-1);
				writer(reader().substring(0, reader().length()-1));
			}	catch(StringIndexOutOfBoundsException se) {}
			return;
		}
		
		if(mal.sb.length()>0 && value.equals("=")) {
			mal.num2 = Double.valueOf(mal.sb.toString());
			clt.initial(mal.num1, mal.num2);
			mal.sign = true; 
			mal.result = false;
			writer(reader() + "\n=" + clt.calculate() + "\n");
			return;
		}	
	}
	
	private void initialize(String sign, Calculator.method name) {
		if(mal.result) {
			mal.num2 = Double.valueOf(mal.sb.toString());
			clt.initial(mal.num1, mal.num2);
			mal.num1 = Double.valueOf(clt.calculate());
		}
		
		else
			mal.num1 = Double.valueOf(mal.sb.toString());
		
		writer(reader() + sign);
		Calculator.mto = name;
		mal.sign = true; 
		mal.result = true;
	}
	
	private double judge() {
		if(scp.radian.isSelected())
			return Double.valueOf(mal.sb.toString());
		//弧度
		else if(scp.angle.isSelected())
			return Math.toRadians(Double.valueOf(mal.sb.toString()));
		//角度
		else 
			return 9*Math.toRadians(Double.valueOf(mal.sb.toString()))/10;
		//梯度
	}
	
	private String reader() {
		return scp.ta.getText();
	}
	
	private void writer(String s) {
		scp.ta.setText(s);
	}
}