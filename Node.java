public class Node {
	//Constructor + Instance Variables
	public Node(String value){
		data = value;
	}

	private String data;
	private Node next, prev;

	//Get + Set methods
	public String getData(){
		return data;
	}

	public String setData(String value){
		oldData = data;
		data = value;
		return oldData;
	}

	public Node getNext(){
		return next;
	}

	public Node setNext(Node newNode){
		oldNext = next;
		next = newNode;
		return oldNext;
	}

	public Node getPrev(){
		return prev;
	}

	public Node setPrev(Node newNode){
		oldPrev = prev;
		prev = newNode;
		return oldPrev;
	}
}
