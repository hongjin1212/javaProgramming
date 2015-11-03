
public class Node {
	Node next = null;
	int data;
	
	public Node(int n) {
		data = n;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node head = this;
		while(head.next != null) {
			head = head.next;
		}
		
		head.next = end;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setData(int n) {
		data = n;
	}
}
