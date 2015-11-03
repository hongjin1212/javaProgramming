import java.util.*;

public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("Please input at least one number!");
		}
		
		Node head = new Node(Integer.parseInt(args[0]));
		Node temp = head;
		for(int i = 1; i < args.length; i++) {
			head.appendToTail(Integer.parseInt(args[i]));
		}
		
		while(head.next != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
		System.out.println(head.getData());
		System.out.println();
		
//		head.next = temp.next.next.next;
//		Node startOfLoop = circleLinkedList(temp);
//		System.out.println("Start of loop is " + startOfLoop.getData());
//		
		
		boolean isPalindrome = palindrome(temp);
		if(isPalindrome) {
			System.out.println("This is a palindrome linkedlist");
		}
		else {
			System.out.println("This is not a palindrome linkedlist");
		}
		
		//Node newHead = addLinkedList(p1, p2);
		
		//Node newHead = partition(temp, 5);
//		deleteFromMiddle(nthToLast(temp, args.length - 5));
//		Node newHead = temp;
//		while(newHead != null) {
//			System.out.print(newHead.getData() + " ");
//			newHead = newHead.next;
//		}
//		
//		System.out.println();
		//Node result = nthToLast(temp, args.length - 1);
		//System.out.println(result.getData());
		
	}
	/* Recursive Version */	
//	private static int nthToLast(Node head, int k) {
//		if(head == null) {
//			return 0;
//		}
//		int i = nthToLast(head.next, k) + 1;
//		if(i == k) {
//			System.out.println("The " + k +"th last element is " + head.getData());
//		}
//		return i;
//	}

	/* Iterative Version*/
	private static Node nthToLast(Node head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i < k; i++) {
			if(p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		
		while(p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	private static void deleteFromMiddle(Node del) {
		if(del.next == null) {
			return;
		}
		del.setData(del.next.getData());
		del.next = del.next.next;
	}
	
	private static Node deleteNode(Node head, int n) {
		Node h = head;
		if(h == null) {
			return head;
		}
		
		else {
			if(h.getData() == n) {
				return head.next;
			}
			else {
				while(h.next != null) {
					if(h.next.getData() == n) {
						h.next = h.next.next;
						//return head;
					}
						h = h.next;
						if(h == null) {
							return head;
						}
				}
				return head;
			}
		}
	}


	private static Node partition(Node head, int val) {
		Node less = null;
		Node p1 = less;
		Node great = null;
		Node p2 = great;
		while(head != null) {
			Node temp = head.next;
			head.next = null;
			if(head.getData() < val) {
				if(less == null) {
					less = head;
					p1 = less;
				}
				else{
					p1.next = head;
					p1 = p1.next;
				}
			}
			
			else {
				if(great == null) {
					great = head;
					p2 = great;
				}
				else{
					p2.next = head;
					p2 = p2.next;
				}
			}
			head = temp;
		}
		
		p1.next = great;
		return less;
	}
//	private static Node removeDup(Node head) {
//		if(head == null) {
//			return head;
//		}
//		Node n = head;
//		Node prev = null;
//		HashSet set = new HashSet();
//		
//		while(n != null) {
//			if(!set.add(n.getData())) {
//				prev.next = n.next;
//			}
//			else {
//				prev = n;
//			}
//			
//			n = n.next;
//		
//		}
//		
//		return head;
//	}
	
	private static Node circleLinkedList(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == null || fast.next == null) {
			System.out.println("There is no circle in this linked list");
			return null;
		}
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	
	private static Node addLinkedList(Node p1, Node p2) {
		Node head = null;
		Node temp = null;
		int digit = 0;
		int carry = 0;
		if(p1 == null && p2 == null) {
			return null;
		}
		while(p1 != null && p2 != null) {
			digit = p1.getData() + p2.getData() + carry;
			if(digit >= 10) {
				digit -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			if(head == null) {
				head = new Node(digit);
				temp = head;
			}
			else {
				temp.next = new Node(digit);
				temp = temp.next;
			}
			p1 = p1.next;
			p2 = p2.next;
			
		}
		
		if(p1 == null && p2 == null) {
			if(carry == 1) {
				temp.next = new Node(1);
			}
		}
		else if(p1 != null) {
			while(p1 != null) {
				digit = p1.getData() + carry;
				if(digit > 10) {
					digit -= 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
				temp.next = new Node(digit);		
				temp = temp.next;
				p1 = p1.next;
			}
			if(carry == 1) {
				temp.next = new Node(1);
			}
			
		}
		else {
			while(p2 != null) {
				digit = p2.getData() + carry;
				if(digit > 10) {
					digit -= 10;
					carry = 1;
				}
				else {
					carry = 0;
				}

				temp.next = new Node(digit);
				temp = temp.next;
				p2 = p2.next;
			}
			if(carry == 1) {
				temp.next = new Node(1);
			}

		}
		
		return head;
	}
	
	private static boolean palindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<Integer> st = new Stack<Integer>();
		while(fast != null && fast.next != null) {
			st.push(slow.getData());
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null) {
			//st.push(slow.getData());
			slow = slow.next;
		}
		while(slow != null) {
			if(st.pop() != slow.getData()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
		
	}
}	
//	private static Node reverse(Node head) {
//		if(head == null || head.next == null) {
//			return head;
//		}
//		
//		Node second = head.next;
//		head.next = null;
//		Node rest = reverse(second);
//		second.next = head;
//		return rest;
//	}
//	
//	
//	private static boolean palindrome(Node head) {
//		//Node oldHead = head;
//		if(head == null) {
//			return false;
//		}
//		
//		if(head.next == null) {
//			return true;
//		}
//		
//		Node newHead = new Node(head.getData());
//		Node n = newHead;
//		Node head1 = head;
//		//Node head11 = head;
//		head = head.next;
//		while(head != null) {
//			Node temp = new Node(head.getData());
//			newHead.next = temp;
//			newHead = newHead.next;
//			head = head.next;
//		}
//		//Node head11 = head1;
//		Node head2 = reverse(head1);
////		
////		while(head2 != null) {
////			System.out.print(head2.getData() + " ");
////			head2 = head2.next;
////		}
////		//System.out.println(head.getData());
////		System.out.println();
//		
////		while(n != null) {
////			System.out.print(n.getData() + " ");
////			n = n.next;
////		}
////		System.out.println();
////		//System.out.println(head.getData());
////		System.out.println();
//		
//		while(head2 != null) {
//			if(head2.getData() != n.getData()) {
//				return false;
//			}
//			n = n.next;
//			head2 = head2.next;
//		}
//		
//		return true;
//		
//	}
//	
//
//
//
