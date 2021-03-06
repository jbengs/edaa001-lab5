package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BinarySearchTree<E> {
	BinaryNode<E> root;  // Används också i BSTVisaulizer
	int size;            // Används också i BSTVisaulizer
	private Comparator<E> comp;

	/**
	 * Constructs an empty binary search tree.
	 * E must extend Comparable<E>, otherwise ClassCastException will be generated later.
	 */
	public BinarySearchTree() {
		root = null;
		comp = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
		size = 0;
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comp) {
		root = null;
		this.comp = comp;
		size = 0;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 *
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<>(x);
			size++;
			return true;
		} else {
			return add(root, x);
		}
	}

	private boolean add(BinaryNode<E> n, E x) {
		if (n != null) {
			int i = comp.compare(x, n.element);
			if (i < 0) {
				if (n.left == null) {
					n.left = new BinaryNode<>(x);
					size++;
					return true;
				} else {
					return add(n.left, x);
				}
			} else if (i > 0) {
				if (n.right == null) {
					n.right = new BinaryNode<>(x);
					size++;
					return true;
				} else {
					return add(n.right, x);
				}
			} else {
				return false;
			}
		}
		return false; //not necessary
	}
/*
		private int compareElements(E o1, E o2){
			if (comp == null) {
				return ((Comparable<E>) o1).compareTo(o2);
			} else {
				return comp.compare(o1, o2);
			}
		}

 */

		/**
		 * Computes the height of tree.
		 * @return the height of the tree
		 */
		public int height () {
			return height(root);
		}

		private int height (BinaryNode < E > n) {
			if (n == null) {
				return 0;
			} else {
				return 1 + Math.max(height(n.left), height(n.right));
			}
		}

		/**
		 * Returns the number of elements in this tree.
		 * @return the number of elements in this tree
		 */
		public int size () {
			return size;
		}

		/**
		 * Removes all of the elements from this list.
		 */
		public void clear () {
			root = null;
			size = 0;
		}

		/**
		 * Print tree contents in inorder.
		 */
		public void printTree () {
			printTree(root);
		}

		private void printTree(BinaryNode<E> n) {
			if (n != null)
				printTree(n.left);
				System.out.println(n.element.toString());
				printTree(n.right);
		}

		/**
		 * Builds a complete tree from the elements in the tree.
		 */
		public void rebuild () {
			ArrayList<E> sortedlist = new ArrayList<>();
			toArray(root, sortedlist);
			root = buildTree(sortedlist, 0, sortedlist.size()-1);
		}

		/*
		 * Adds all elements from the tree rooted at n in inorder to the list sorted.
		 */
		private void toArray (BinaryNode < E > n, ArrayList < E > sorted){
			if (n != null) {
				toArray(n.left, sorted);
				sorted.add(n.element);
				toArray(n.right, sorted);
			}
		}

		/*
		 * Builds a complete tree from the elements from position first to
		 * last in the list sorted.
		 * Elements in the list a are assumed to be in ascending order.
		 * Returns the root of tree.
		 */
		private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last){
			if (first > last) {
				return null;
			}
			int mid = first + (last - first)/2;
			BinaryNode<E> root = new BinaryNode<>(sorted.get(mid));
			root.left = buildTree(sorted, first, mid-1);
			root.right = buildTree(sorted, mid+1, last);
			return root;
		}

		//not private, because access needed in BSTVisualizer.java
		static class BinaryNode<E> {
			E element;
			BinaryNode<E> left;
			BinaryNode<E> right;

			private BinaryNode(E element) {
				this.element = element;
				left = right = null;
			}
		}

}

