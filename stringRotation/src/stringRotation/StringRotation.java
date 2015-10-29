package stringRotation;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("Please input two strings!");
		}
		
		if(isRotation(args[0], args[1])) {
			System.out.println(args[1] + " is rotation of " + args[0]);
		}
		
		else {
			System.out.println(args[1] + " is not rotation of " + args[0]);
		}
	}
	
	private static boolean isSubstring(String s1, String s2) {
		if(s2.length() > s1.length()) {
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(0)) {
				for(int j = 0; j < s2.length(); j++) {
					if(s1.charAt(j + i) != s2.charAt(j)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	private static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		String s1s1 = s1 + s1;
		if(isSubstring(s1s1, s2)) {
			return true;
		}
		else {
			return false;
		}
	}

}
