package View;

public class Test {
	static int a=9;
	public static void main(String[] args) {
		a = run(5);
		System.out.println(a);
	}
	
	public static int run(int n) {
		if(n==1)
			return 1;
		else {
			return run(n-1)+1;
			//System.out.println(n);
			//return run(n-1)+1;
		}
		
	}
}
