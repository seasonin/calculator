import java.math.BigDecimal;

public class Calculator {
	double num1, num2;
	public static method mto;
	
	public enum method {
		add, subtract, multiply, divide, pow, mod;
	}
	
	public void initial(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public String calculate() {
		
		if(mto == method.add)
			return new BigDecimal(num1).add(new BigDecimal(num2)).toString();
		
		if(mto == method.subtract)
			return new BigDecimal(num1).subtract(new BigDecimal(num2)).toString();
		
		if(mto == method.multiply)
			return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
		
		if(mto == method.divide)
			if(Double.valueOf(num2) == 0)
				return "除数不能为零";
			else
				return new BigDecimal(num1).divide(new BigDecimal(num2)).toString();
		
		if(mto == method.pow)
			return String.valueOf(Math.pow(num1, num2));
		
		if(mto == method.mod)
			return String.valueOf(num1%num2);
		
		return "";
	}
}
