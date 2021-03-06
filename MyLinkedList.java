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
		} else {
			Node oldEnd = end;
			end.setNext(new Node(value));
			end = end.getNext();
			end.setPrev(oldEnd);
		}
		size++;
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
			prevNode.getNext().setNext(nextNode);
			prevNode.getNext().setPrev(prevNode);
		}
		size++;
	}

	public String get(int index){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}
		
		Node current = start;
		for (int i = 0; i < index; i++){
			current = current.getNext();
		}
		return current.getData();
	}

	public String set(int index, String value){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}

		Node currentNode = findNthNode(index);
		return currentNode.setData(value);
	}

	public String toString(){
		String result = "{";

		for (int i = 0; i < size; i++){
			result += get(i);
			if (i != size - 1){
				result += ", ";
			}
		}
		
		return result + "}";
	}

	public String toStringReversed(){
		String result = "{";

		for (int i = size - 1; i >= 0; i--){
			result += get(i);
			if (i != 0){
				result += ", ";
			}
		}
		
		return result + "}";
	}

	public String remove(int index){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
		}

		String result = get(index);

		if (size == 1) {
			start = null;
			end = null;
		} else if (index == 0){
			Node removee = findNthNode(index);
			removee.getNext().setPrev(null);
			start = removee.getNext();
		} else if (index == size - 1){
			Node removee = findNthNode(index);
			removee.getPrev().setNext(null);
			end = removee.getPrev();
		} else {
			Node frontNode = findNthNode(index - 1);
			Node backNode = frontNode.getNext().getNext();
			frontNode.setNext(backNode);
			backNode.setPrev(frontNode);
		}

		size--;
		return result;
	}

	public void extend(MyLinkedList other){
		if (this.size == 0){
			this.start = other.start;
			this.end = other.end;
		} else if (other.size != 0){
			this.end.setNext(other.start);
			other.start.setPrev(this.end);
			this.end = other.end;
		}
		other.start = null;
		other.end = null;
		this.size += other.size;
		other.size = 0;
	}

	private Node findNthNode(int index){
		Node current = start;
		
		for (int i = 0; i < index; i++){
			current = current.getNext();
		}

		return current;
	}
}
