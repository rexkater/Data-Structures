package Interfaces;

public interface PositionalList<E> {
	
	int size();
	boolean isEmpty();
	
	/**
	 * @returns the first position (reference to it) in the list. 
	 * Returns null if empty.
	 */
	Position<E> first();
	
	/**
	 * @returns the last position in the list, and null if empty.
	 */
	Position<E> last();
	
	/**
	 * @param p is the reference position.
	 * @returns position immediately before p, and null if p is the first position of the list.
	 * @throws IllegalArgumentException if position's not valid.
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @param p is the reference position.
	 * @returns position immediately after p, and null if p is the last position of the list.
	 * @throws IllegalArgumentException
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * @param e element added to the front of the list.
	 * @returns the new position of the added element.
	 */
	Position<E> addFirst(E e);
	
	/**
	 * @param e element added to the end of the list.
	 * @returns the new position of the added element.
	 */
	Position<E> addLast(E e);
	
	/**
	 * @param p reference position.
	 * @param e element to be added before p.
	 * @returns the position of the new element.
	 * @throws IllegalArgumentException
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @param p reference position.
	 * @param e element to be added after p.
	 * @returns the position of the new element.
	 * @throws IllegalArgumentException
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @param p position to be altered.
	 * @param e replaces the element at p.
	 * @returns former element at position p.
	 * @throws IllegalArgumentException
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * @param p position to be removed.
	 * @returns element that was at the invalidated p.
	 * @throws IllegalArgumentException
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
	
}
