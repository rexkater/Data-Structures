package Lists;
import Interfaces.DoublyLinkedList;

public class DLL<E> implements DoublyLinkedList<E> {
	private int size;
	private DNode<E> header;
	private DNode<E> trailer;
	
	public DLL(){
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(null, header, null);
		header.setNext(trailer);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E getFirst() {
		return header.getNext().getElement();
	}

	@Override
	public E getLast() {
		return trailer.getPrev().getElement();
	}

	@Override
	public void addFirst(E e) {
		DNode<E> nta = new DNode<E>(e);
		DNode<E> nextNode = header.getNext();
		nta.setPrev(header);
		nta.setNext(nextNode);
		header.setNext(nta);
		nextNode.setPrev(nta);
		size++;
	}

	@Override
	public void addLast(E e) {
		DNode<E> nta = new DNode<E>(e);
		DNode<E> prevNode = trailer.getPrev();
		nta.setPrev(prevNode);
		nta.setNext(trailer);
		trailer.setPrev(nta);
		prevNode.setNext(nta);
		size++;
	}

	@Override
	public E removeFirst() {
		if(size() == 0)
			return null;
		E element = header.getNext().getElement();
		header.getNext().getNext().setPrev(header);
		header.setNext(header.getNext().getNext());
		header.getNext().clearNode();
		size--;
		return element;
	}

	@Override
	public E removeLast() {
		if(size() == 0)
			return null;
		E element = trailer.getPrev().getElement();
		trailer.getPrev().getPrev().setNext(trailer);
		trailer.setPrev(trailer.getPrev().getPrev());
		trailer.getPrev().clearNode();
		size--;
		return element;
	}
	
	public class DNode<T>{
		private E element;
		private DNode<E> prev = null;
		private DNode<E> next = null;
		
		public DNode(){}
		public DNode(E element){
			this.element = element;
		}
		
		public DNode(E element, DNode<E> prev, DNode<E> next){
			this(element);
			this.prev = prev;
			this.next = next;
		}
		
		public E getElement(){
			return element;
		}
		
		public DNode<E> getPrev(){
			return prev;
		}
		
		public DNode<E> getNext(){
			return next;
		}
		
		public E setElement(E e){
			E etr = element;
			element = e;
			return etr;
		}
		
		public void setNext(DNode<E> node){
			next = node;
		}
		
		public void setPrev(DNode<E> node){
			prev = node;
		}
		
		public void clearNode(){
			next = prev = null;
		}
		
	}

}
