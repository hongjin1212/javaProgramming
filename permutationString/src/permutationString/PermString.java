package permutationString;

public class PermString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("Please input two Strings!");
			System.exit(0);
		}
		if(isPermutation(args[0], args[1])) {
			System.out.println(args[0] + " is the permutation of " + args[1]);
		}
		
		else {
			System.out.println(args[0] + " is not the permutation of " + args[1]);
		}
		
	}
	
	private static boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int[] count = new int[256];
		for(int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
		}
//		
		for(int i = 0; i < s2.length(); i++) {
			count[s2.charAt(i)]--;
			if(count[s2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
//		if(sort(s1).equals(sort(s2))) {
//			return true;
//		}
//		else {
//			return false;
//		}
		
		
	}
//	
//	private static String sort(String s) {
//		char[] c = s.toCharArray();
//		java.util.Arrays.sort(c);
//		s = String.valueOf(c);
//		return s;
//	}
}
