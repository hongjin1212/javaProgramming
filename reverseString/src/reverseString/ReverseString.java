package reverseString;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("Please input a String!");
			System.exit(0);
		}
		String s = args[0];
//		char[] c = new char[s.length()];
//		for(int i = 0; i < s.length(); i++) {
//			c[i] = s.charAt(i);
//		}
		char[] c = s.toCharArray();
		
		for(int i = 0; i < s.length() / 2; i++) {
			swapChar(i, s.length() - 1 - i, c);
		}
		s = String.valueOf(c);
		System.out.println("Reversed string is " + s);
	
	}
	
	private static void swapChar(int i, int j, char[] c) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}
