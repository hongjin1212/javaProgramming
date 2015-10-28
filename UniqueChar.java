import java.util.*;

public class UniqueChar {
    public static void main(String[] args) {
	Boolean unique = true;
	HashSet<Character> c = new HashSet<Character>();
	String s = args[0];
	for(int i = 0; i < s.length(); i++) {
	    if(!c.add(s.charAt(i))) {
		unique = false;
		break;
	    }
	}

	if(unique) {
	    System.out.println(s + " has all unique characters!");
	}
	else {
	    System.out.println(s + " does not have all unique characters!");
	}
    }
}