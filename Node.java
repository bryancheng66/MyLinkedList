public class Node {
	//Constructor + Instance Variables
	public Node(String value){
		data = value;
		next = null;
		prev = null;
	}

	private String data;
	private Node next, prev;

	//Get + Set methods
	public String getData(){
		return data;
	}

	public String setData(String value){
		String oldData = data;
		data = value;
		return oldData;
	}

	public Node getNext(){
		return next;
	}

	public Node setNext(Node newNode){
		Node oldNext = next;
		next = newNode;
		return oldNext;
	}

	public Node getPrev(){
		return prev;
	}

	public Node setPrev(Node newNode){
		Node oldPrev = prev;
		prev = newNode;
		return oldPrev;
	}
}
