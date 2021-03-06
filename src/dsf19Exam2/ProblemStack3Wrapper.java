package dsf19Exam2;

import java.io.PrintStream;

public class ProblemStack3Wrapper {
	public interface Stack<E> {

		public int size();

		public boolean isEmpty();

		public E top();

		public E pop();

		public void push(E e);

		public void clear();

		public void print(PrintStream out);

	}

	public static class SingleLinkedStack<E> implements Stack<E> {

		// node class
		@SuppressWarnings("hiding")
		private class Node<E> {
			private E element;
			private Node<E> next;

			@SuppressWarnings("unused")
			public Node(E element, Node<E> next) {
				super();
				this.element = element;
				this.next = next;
			}

			public Node() {
				super();
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

		}

		private Node<E> header;
		private int currentSize;

		public SingleLinkedStack() {
			this.header = new Node<>();
			this.currentSize = 0;
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
		public E top() {
			if (this.isEmpty()) {
				return null;
			} else {
				return this.header.getNext().getElement();
			}
		}

		@Override
		public E pop() {
			if (this.isEmpty()) {
				return null;
			} else {
				E result = this.header.getNext().getElement();
				Node<E> temp = this.header.getNext();
				this.header.setNext(temp.getNext());
				temp.setNext(null);
				temp.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void push(E e) {
			Node<E> newNode = new Node<>();
			newNode.setElement(e);
			newNode.setNext(this.header.getNext());
			this.header.setNext(newNode);
			this.currentSize++;
			return;
		}

		@Override
		public void clear() {
			while (this.pop() != null)
				;

		}

		@Override
		public void print(PrintStream out) {
			Node<E> temp = this.header.getNext();
			while (temp != null) {
				out.println(temp.getElement());
				temp = temp.getNext();
			}

		}
	}

	/*
	 * Write a non-member function stackTop() which returns a new stack with the top
	 * N elements from another stack S. The function receives as parameters the
	 * target stack S and the number of top elements to find. The function must
	 * verify that the target stack has at least N elements, and return an empty
	 * stack if not. After completion, the original stack must have the same
	 * elements and structure as it had at the beginning. In addition, the relative
	 * structure of the resulting stack with the top N element must be same at that
	 * in the original stack. For example, if the original stack S = {Joe, Ned, Jil,
	 * Ned, Apu}, where Joe is the top, then a call to stackTop(S, 3) will return
	 * the stack {Joe, Ned, Jil}. A tester can be found in this link.
	 */
	public static Stack<String> stackTop(Stack<String> S, int N) {
		Stack<String> newStack = new SingleLinkedStack<String>();
		Stack<String> copyStack = new SingleLinkedStack<String>();
		Stack<String> result = new SingleLinkedStack<String>();

		if (S.size() < N) {
			return newStack;
		}
		if (S.isEmpty()) {
			return newStack;
		}
		int count = 0;
		while (!S.isEmpty()) {
			if (count < N) {
				newStack.push(S.top());
				count++;
			}
			copyStack.push(S.pop());
		}
		while (!newStack.isEmpty()) {
			result.push(newStack.pop());
		}
		S = copyStack;
		return result;
	}

	public static void main(String[] args) {
		Stack<String> S = new SingleLinkedStack<String>();
		// S = {Joe, Ned, Jil, Ned, Apu}
		S.push("Apu");
		S.push("Ned");
		S.push("Jil");
		S.push("Ned");
		S.push("Joe");
		int size = S.size();

		Stack<String> S2 = stackTop(S, 3);
		int size2 = S2.size();
		for (int i = 0; i < size2; i++) {
			System.out.println(S2.pop());
		}
	}
}