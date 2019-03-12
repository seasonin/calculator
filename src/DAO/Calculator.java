package DAO;

import java.math.BigDecimal;

public class Calculator {
	public static method mto;
	
	public enum method {
		add, subtract, multiply, divide, pow, mod;
		//定义枚举变量
	}
	
	public String calculate(double num1, double num2) {
	
		if(mto == method.add)
			return new BigDecimal(num1).add(new BigDecimal(num2)).toString();
			//枚举变量mto为add时，返回加法运算结果
		if(mto == method.subtract)
			return new BigDecimal(num1).subtract(new BigDecimal(num2)).toString();
			//返回减法运算结果
		if(mto == method.multiply)
			return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
			//返回乘法运算结果
		if(mto == method.divide)
			if(Double.valueOf(num2) == 0)
				return "除数不能为零";
			else
				return new BigDecimal(num1).divide(new BigDecimal(num2)).toString();
				//返回除法运算结果
		if(mto == method.pow)
			return String.valueOf(Math.pow(num1, num2));
			//返回num1和num2的幂运算结果
		if(mto == method.mod)
			return String.valueOf(num1%num2);
			//返回num1和num2的求余运算结果
		return "";
	}
}
