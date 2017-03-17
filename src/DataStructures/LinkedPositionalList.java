package DataStructures;
import Interfaces.Position;
import Interfaces.PositionalList;

public class LinkedPositionalList<E> implements PositionalList<E> {
	
	private DNode<E> header, trailer; // Dummy header and trailer nodes.
	private int size;
	
	public LinkedPositionalList(){
		header = new DNode<E>(null, null, null, null);
		trailer = new DNode<E>(null, header, null, null);
		header.setNext(trailer);
		size = 0;
	}

	private DNode<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof DNode))
			throw new IllegalArgumentException("Illegal p");
		@SuppressWarnings("unchecked")
		DNode<E> node = (DNode<E>) p;
		if(node.getNext() == null || node.getPrev() == null)
			throw new IllegalArgumentException("p is not a position in the list");
		return node;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	private Position<E> position(DNode<E> node){
		if(node == header || node == trailer)
			return null;
		return node;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		return position(node.getNext());
	}
	
	private Position<E> addBetween(E e, DNode<E> pred, DNode<E> succ){
		DNode<E> newest = new DNode<>(e, pred, succ, null);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		E etr = node.getElement();
		node.setElement(e);
		return etr;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		DNode<E> node = validate(p);
		DNode<E> prev = node.getPrev();
		DNode<E> succ = node.getNext();
		succ.setPrev(prev);
		prev.setNext(succ);
		E etr = node.getElement();
		node.clearNode();
		size--;
		return etr;
	}

	public class DNode<T> implements Position<E> {
		private E element;
		private DNode<E> prev = null;
		private DNode<E> next = null;
		
		public DNode(){}
		public DNode(E element){
			this.element = element;
		}
		
		public DNode(E element, DNode<E> prev, DNode<E> next, LinkedPositionalList<E> list){
			this(element);
			this.prev = prev;
			this.next = next;
		}
		
		public E getElement(){return element;}
		public DNode<E> getPrev(){return prev;}
		public DNode<E> getNext(){return next;}
		
		public E setElement(E e){
			E etr = element;
			element = e;
			return etr;
		}
		
		public void setNext(DNode<E> node){next = node;}
		public void setPrev(DNode<E> node){prev = node;}
		public void clearNode(){next = prev = null;}
		
	}
	
}
