package Junit;

public class demo {
	String primeChecker (int n) {
		int prime = 1;
		if (n >= 0 && n <= 1) {
			
		}
		else if (n > 1) {
			for (int i=n-1; i > 1; i--) {
				if (n%i == 0) {
					prime = 0;
					break;
				}
			}
		}
		else {
			return ("Enter Positive Number");
		}
		if (prime == 0) {
			return "Not Prime";
		}
		else {
			return "Prime";
		}
	}
	
	public static void main (String args[]) {
		demo d = new demo ();
		System.out.println (d.primeChecker(5));
	}
}

