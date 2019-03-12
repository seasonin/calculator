package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import Server.*;
import DAO.*;

public class ScienceListener implements ActionListener {
	
	SciencePanel scp;
	private Calculator clt = new Calculator();
	private String value = null;
	private String previousText;
	private StringBuffer stb; 
	private LinkedList<Double> numList = new LinkedList<Double>();;
    private LinkedList<Character> optList = new LinkedList<Character>();
    private double number;
	private boolean sign = true;
	//如果sign为true，重新new一个stb实例，储存新数
	private ScienceListener slt;
	
	//构造方法重构
	public ScienceListener() {} 
	public ScienceListener(SciencePanel scp) {
		this.scp = scp;
		this.slt = scp.slt;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		previousText = reader();//得到文本域的内容
		value = e.getActionCommand();//得到监听事件的内容
		if(slt.sign) 
			slt.stb = new StringBuffer();
		//重新new一个StringBuffer实例，储存新数
		
		if(("π.0123456789+-×÷%Modxⁿ").indexOf(value)>=0) {
			if(("+-×÷%Modxⁿ").indexOf(value)>=0) {
				slt.numList.add(Double.valueOf(slt.stb.toString()));
				//把数字加入到numList中
				if(("%Mod").indexOf(value)>=0) {
					slt.optList.add('%');
					//求余运算符加入optList链表中
					writer(previousText + "%");
					//文本末尾追加运算符%
				}
				else if(("xⁿ").indexOf(value)>=0) {
					slt.optList.add('^');
					//幂运算符加入optList链表中
					writer(previousText + "^");
					//文本末尾追加运算符^
				}
				else {
					slt.optList.add(value.charAt(0));
					//把操作符加入到optList中
					writer(previousText + value);
					//文本末尾追加运算符
				}
				slt.sign = true;
			}
			else {
				if("π".indexOf(value)>=0)
					slt.stb.append(Math.PI);
					//stb加入数学π值
				else
					slt.stb.append(value);
					//在stb后添加数字
				writer(previousText + value);
				slt.sign = false;
			}
			return;	
		}
	
		if(slt.stb.length()>0 && value.equals("±")) {
			//正负号
			number = Double.valueOf(slt.stb.toString())*(-1);
			//在原有的数值上乘于-1
			writer(previousText.substring(0, previousText.length()-slt.stb.length())+number);
			//文本域打印新的数值
			slt.stb.delete(0, slt.stb.length());
			slt.stb.append(number);
			//加入新的数值
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("√")) {
			number = Math.sqrt(Double.valueOf(slt.stb.toString()));
			//调用开平方运算
			foreInsert("√(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("³√")) {
			number = Math.cbrt(Double.valueOf(slt.stb.toString()));
			//调用开立方运算
			foreInsert("³√(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("ln")) {
			number = Math.log(Double.valueOf(slt.stb.toString()));
			//java的log函数以e为底，即为数学ln函数
			foreInsert("log(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("lg")) {
			number = Math.log10(Double.valueOf(slt.stb.toString()));
			//求以10为底的对数
			foreInsert("lg(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("sin")) {
			number = Math.sin(judge());
			//求正弦函数
			foreInsert("sin(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("asin")) {
			number = Math.asin(judge());
			//求反正弦函数
			foreInsert("asin(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("sinh")) {
			number = Math.sinh(judge());
			//求双曲正弦函数
			foreInsert("sinh(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("cos")) {
			number = Math.cos(judge());
			//求余弦函数
			foreInsert("cos(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("acos")) {
			number = Math.acos(judge());
			//求反余弦函数
			foreInsert("acos(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("cosh")) {
			number = Math.cosh(judge());
			//求双曲余弦函数
			foreInsert("cosh(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("tan")) {
			number = Math.tan(judge());
			//求正切函数
			foreInsert("tan(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("atan")) {
			number = Math.atan(judge());
			//求反正切函数
			foreInsert("atan(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("tanh")) {
			number = Math.tanh(judge());
			//求双曲正切函数
			foreInsert("tanh(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("exp")) {
			number = Math.exp(Double.valueOf(slt.stb.toString()));
			//以e为底的幂运算
			foreInsert("exp(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("x²")) {
			number = Math.pow(Double.valueOf(slt.stb.toString()), 2);
			//平方运算
			backInsert("^2", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("x³")) {
			number = Math.pow(Double.valueOf(slt.stb.toString()), 3);
			//立方运算
			backInsert("^3", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("10ⁿ")) {
			number = Math.pow(10, Double.valueOf(slt.stb.toString()));
			//求以10为底的幂运算
			foreInsert("10^(", number);
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("n!")) {
			int i;
			for(i=1, number=1; i<=Integer.valueOf(slt.stb.toString()); i++)
				 number *= i;
			//通过for循环求阶乘
			backInsert("!", number);
			return;
		}
		
		if(value.equals("CE")) {
			writer(reader().substring(0,reader().length()-slt.stb.length()));
			//文本域删去最近输入的数值
			slt.stb.delete(0, slt.stb.length());
			//stb清空
			slt.sign = true; 
			return;
		}
		
		if(value.equals("C")) {
			writer("");
			//清空文本域
			slt.optList.clear();
			slt.numList.clear();
			//清空链表
			slt.stb.delete(0, slt.stb.length());
			slt.sign = true; 
			//slt.result = false;
			return;
		}
		
		if(value.equals("←") && slt.stb.length()>=0) {
			try {
				slt.stb.deleteCharAt(slt.stb.length()-1);
				//stb删除最近一个数字
				writer(reader().substring(0, reader().length()-1));
				//文本域删除最后一个字符
			}	catch(StringIndexOutOfBoundsException se) {}
			return;
		}
		
		if(slt.stb.length()>0 && value.equals("=")) {
			slt.numList.add(Double.valueOf(slt.stb.toString()));
			boolean havePriSign = true;
			while (havePriSign == true) {
				//当optList链表中有优先运算符时，havePriSign为true，循环继续
	            havePriSign = false;
	            for (int index = 0; index <= slt.optList.size() - 1; index++) {
	            	//下列判断是否为优先运算符，如果是则调用cutList方法
	                if (slt.optList.get(index) == '×') {
	                	cutList(Calculator.method.multiply, index);
	                    havePriSign = true;
	                }
	                else if (slt.optList.get(index) == '÷') {
	                	cutList(Calculator.method.divide, index);
	                    havePriSign = true;
	                }
	                else if (slt.optList.get(index) == '%') {
	                	cutList(Calculator.method.mod, index);
	                    havePriSign = true;
	                }
	                else if (slt.optList.get(index) == '^') {
	                	cutList(Calculator.method.pow, index);
	                    havePriSign = true;
	                }
	            }
	        }
			
	        while (slt.optList.isEmpty() == false) {
	            for (int index = 0; index <= slt.optList.size() - 1; index++) {
	            	//optList链表中的优先运算符删除完后，检查+、-运算符
	                if (slt.optList.get(index) == '+') {
	                	cutList(Calculator.method.add, index);
	                    break;
	                }
	                
	                if (slt.optList.get(index) == '-') {
	                	cutList(Calculator.method.subtract, index);
	                    break;
	                }
	            }
	        }
	        if (slt.numList.size() == 1) 
	            writer(reader() + "\n=" + slt.numList.get(0) + "\n");
	        	//循环调用cutList方法完成后，numList链表中应该只有一个数字
			return;
		}	
	}
	
	private void cutList(Calculator.method mto, int index) {
		Calculator.mto =  mto;
		//初始化Calculator中的美剧变量mto
		Double result = Double.valueOf(clt.calculate(Double.valueOf(slt.numList.get(index)), Double.valueOf(slt.numList.get(index + 1))));
    	//调用Calculator的calculate方法计算numList中下标为index和index+1的数字
		slt.numList.remove(index + 1);
		//numList删除下标为index+1的数字
    	slt.numList.set(index, result);
    	//numList删除下标为index的数字
    	slt.optList.remove(index);
    	//optList删除下标为index的操作符
	}
	
	private void foreInsert(String s, Double num) {
		writer(reader().substring(0,reader().length()-slt.stb.length()) + s + Double.valueOf(slt.stb.toString()) + ")");
		//在数字前加入运算符
		slt.stb.delete(0, slt.stb.length());
		slt.stb.append(num);
	}
	
	private void backInsert(String s, Double num) {
		writer(reader() + s);
		//在数字后加入运算符
		slt.stb.delete(0, slt.stb.length());
		slt.stb.append(num);
	}
	
	private double judge() {
		if(scp.radian.isSelected())
			return Double.valueOf(slt.stb.toString());
		//弧度
		else if(scp.angle.isSelected())
			return Math.toRadians(Double.valueOf(slt.stb.toString()));
		//角度
		else 
			return 9*Math.toRadians(Double.valueOf(slt.stb.toString()))/10;
		//梯度
	}
	
	private String reader() {
		return scp.ta.getText();
		//返回文本域内容
	}
	
	private void writer(String s) {
		scp.ta.setText(s);
		//设置文本域内容
	}
}