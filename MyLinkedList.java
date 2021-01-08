public class MyLinkedList{
	private int size;
	private Node start, end;
	
	public MyLinkedList(){
		size = 0;
	}

	public int size(){
		return size;
	}

	public boolean add(String value){
		if (size == 0){
			start = new Node(value);
			end = start;
			size++;
		} else {
			end.setNext(new Node(value));
			end = end.getNext();
			size++;
		}
		return true;
	}

	public void add(int index, String value){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		
		if (index == 0){
			Node newNext = start;
			start.setPrev(new Node(value));
			start = start.getPrev();
			start.setNext(newNext);
		} else if (index == size){
			Node newPrev = end;
			end.setNext(new Node(value));
			end = end.getNext();
			end.setPrev(newPrev);
		} else {
			Node prevNode = findNthNode(index - 1);
			Node nextNode = prevNode.getNext();
			prevNode.setNext(new Node(value));
			nextNode.setPrev(prevNode.getNext());
		}
		size++;
	}

	private Node findNthNode(int index){
		Node current = start;
		
		for (int i = 0; i < index; i++){
			current = current.getNext();
		}

		return current;
	}
}
