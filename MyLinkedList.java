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
	}
}
