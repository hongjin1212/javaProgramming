package replaceWhiteSpace;

public class ReplaceWhiteSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		if(args.length == 0) {
			System.out.println("Please input a String!");
			System.exit(0);
		}
		
		for(int i = 0; i < args.length - 1; i++) {
			sb.append(args[i]);
			sb.append(' ');
		}
		sb.append(args[args.length -1 ]);
		
		String s = sb.toString();
		
		//char[] c = s.toCharArray();
		int length = s.length();
		int count = 0;
		for(int i = 0; i < length; i++) {
			if(s.charAt(i) == ' ') {
				count++;
			}
		}
		length += 2 * count;
		char[] c = new char[length];
		for(int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}
		
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(c[i] == ' ') {
				c[length - 1] = '0';
				c[length - 2] = '2';
				c[length - 3] = '%';
				length -= 3;
			}
			else{
				c[length - 1] = c[i];
				length--;
			}
		}
		
		s = String.valueOf(c);
		System.out.println(s);
		
		
	}

}
