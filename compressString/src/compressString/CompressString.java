package compressString;

public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("Please input a String!");
		}
		String s = args[0];
		String result = compress(s);
		System.out.println("Compressed string is " + result);
	}
	
	private static String compress(String s) {
		StringBuffer comp = new StringBuffer();
		char prev = s.charAt(0);
		int count = 1;
		for(int j = 1; j < s.length(); j++) {
			if(s.charAt(j) == prev) {
				count++;
			}
			else if(count == 1) {
				comp.append(prev);
				prev = s.charAt(j);
			}
			else {
				//comp += prev + "" + count;
				comp.append(prev);
				comp.append(count);
				prev = s.charAt(j);
				count = 1;
			}
		}
		if(count == 1) {
			//comp += prev;
			comp.append(prev);
		}
		else {
			//comp += prev + "" + count;
			comp.append(prev);
			comp.append(count);
		}
		return comp.toString();
	}

}
