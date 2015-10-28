
public class TestMySB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuffer sb = new MyStringBuffer();
		for(int i = 0; i < args.length; i++) {
			sb.append(args[i]);
		}
		
		System.out.println(sb.toString());
	}

}
