package dsf19Exam2;

import java.io.PrintStream;

public class ProblemQueue3Wrapper {
	public interface Queue<E> {

		public int size();

		public boolean isEmpty();

		public E front();

		public void enqueue(E e);

		public E dequeue();

		public void makeEmpty();

		public void print(PrintStream P);

	}

	public static class DoublyLinkedQueue<E> implements Queue<E> {

		private static class Node<E> {
			private E element;
			private Node<E> next;
			private Node<E> prev;

			public Node() {
				this.element = null;
				this.next = this.prev = null;

			}

			public E getElement() {
				return element;
			}

			public void setElement(E element) {
				this.element = element;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> next) {
				this.next = next;
			}

			public Node<E> getPrev() {
				return prev;
			}

			public void setPrev(Node<E> prev) {
				this.prev = prev;
			}

		}

		private Node<E> header;
		private Node<E> tail;
		private int currentSize;

		public DoublyLinkedQueue() {
			this.currentSize = 0;
			this.header = new Node<>();
			this.tail = new Node<>();

			this.header.setNext(this.tail);
			this.tail.setPrev(this.header);
		}

		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public E front() {
			return (this.isEmpty() ? null : this.header.getNext().getElement());
		}

		@Override
		public E dequeue() {
			if (this.isEmpty()) {
				return null;
			} else {
				Node<E> target = null;
				target = this.header.getNext();
				E result = target.getElement();
				this.header.setNext(target.getNext());
				target.getNext().setPrev(this.header);
				target.setNext(null);
				target.setPrev(null);
				target.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void enqueue(E e) {
			Node<E> newNode = new Node<E>();
			newNode.setElement(e);
			newNode.setNext(this.tail);
			newNode.setPrev(this.tail.getPrev());
			this.tail.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			this.currentSize++;
		}

		@Override
		public void makeEmpty() {
			while (this.dequeue() != null)
				;

		}

		@Override
		public void print(PrintStream P) {
			// TODO Auto-generated method stub
			Node<E> temp = this.header.getNext();
			while (temp != this.tail) {
				P.println(temp.getElement());
				temp = temp.getNext();
			}
		}
	}

	/*
	 * Hindu-Arabic decimal numbers use the digits 0,1,2,3,5,6,7,8,9. We form
	 * decimal numbers creating strings with these digits. For example: 102, 88, 12.
	 * Recall that, for example, 12 is 1x101 + 2 x 100 . Binary numbers use only 0
	 * and 1. We can create numbers by creating strings with 0s and 1s. For example,
	 * 1 is expressed as 1 (1 x 20), 2 is expressed as 10 (1x21 + 0x20), 3 is
	 * expressed as 11 (1x21 + 1x20). The first 5 integers are 1, 10, 11, 100, 101.
	 * The first 8 integers are expressed as 1, 10, 11, 100, 101, 110, 111, 1000.
	 * The first 16 integers are expressed as 1, 10, 11, 100, 101, 110, 111, 1000,
	 * 1001, 1010, 1011, 1100, 1101, 1110, 1111, 10000. Write a non-member method
	 * binaryNumberSequence() that produces the sequence of the first N integers.
	 * The method receives as parameter the number N, and returns a Queue<String>
	 * with N strings representing the first N integers. The elements in the queue
	 * come in the increasing sequence order of the number. For example, a call to
	 * binaryNumberSequence(5) returns Q = {1, 10, 11, 100, 101}.
	 */
	public static Queue<String> binaryNumberSequence(int N) {
		Queue<String> newQueue = new DoublyLinkedQueue<String>();
		String s = "";
		int quotient = N;
		while (quotient != 0) {
			s = quotient % 2 + s;
			quotient = quotient / 2;
		}
		if (N == 0) {
			s = quotient + s;
		}
		for (int i = 0; i <= N; i++) {
			newQueue.enqueue(s);
		}
		return newQueue;
	}

	public static void main(String[] args) {
		Queue<String> q = new DoublyLinkedQueue<String>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.enqueue("5");
		q.enqueue("6");
		q.enqueue("7");
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("10");
		q.enqueue("11");
		q.enqueue("12");
		q.enqueue("13");
		q.enqueue("14");
		q.enqueue("15");
		q.enqueue("16");
		q.enqueue("17");
		q.enqueue("18");
		for (int i = 0; i < q.size(); i++) {
			System.out.println(binaryNumberSequence(i).dequeue());
		}

	}
}