
public class MyStringBuffer {
	private char[] charArray;
	private int capacity;
	private int length;
	
	public MyStringBuffer() {
		this(16);
	}
	
	public MyStringBuffer(int c) {
		capacity = c;
		charArray = new char[capacity];
		length = 0;
	}
	
	public synchronized MyStringBuffer append(String s) {
		if(s == null) {
			return this;
		}
		if(length + s.length() > capacity) {
			int newCapacity = Math.max(length + s.length(), capacity * 2);
			capacity = newCapacity;
			char[] c = new char[capacity];
			for(int i = 0; i < length; i++) {
				c[i] = charArray[i];
			}
			charArray = c;
		}
		
		for(int i = 0; i < s.length(); i++) {
			charArray[i + length] = s.charAt(i);
		}
		length += s.length();
		
		return this;
	}
	
	public String toString() {
		return new String(charArray, 0, length);
	}
}
