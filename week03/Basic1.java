package week03;

class BasicEx{
	private int a, b, c;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public BasicEx(int a) {
		super();
		this.a = a;
	}

	public BasicEx(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "BasicEx [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	
	
}

public class Basic1 {
	public static void main(String[] args) {
		BasicEx b = new BasicEx(1);
		System.out.println(b);
		outer:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(i+j == 5)
					break outer;
				System.out.print("i = " + i + ", j = " + j + " ");
			}
			System.out.println();
		}
		
	}
}
