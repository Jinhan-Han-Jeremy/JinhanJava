package linked;

import java.util.HashSet;
import java.util.Set;

public class CharLinkedList {
	private CharNode head; // Empty if head and
	private CharNode tail; // tail are null

	public CharLinkedList() {
	}

	public CharLinkedList(String s) {
		for (int i = s.length() - 1; i >= 0; i--)
			insertAtHead(s.charAt(i));
	}

	public void insertAtHead(char ch) {
		assert hasIntegrity(); // Precondition

		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node; // Corner case: inserting into empty node

		assert hasIntegrity(); // Postcondition
	}

	public String toString() {
		String s = "";
		CharNode node = head;
		while (node != null) {
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}

	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no
	// loops,
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems.
	//
	boolean hasIntegrity() {
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null || tail == null)
			return head == null && tail == null;

		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;

		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null) {
			if (visitedNodes.contains(node))
				return false; // Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}

		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}

	public CharNode find(char ch) {
		CharNode nod = head;
		// Set head
		while (nod != null) {
			if (nod.getData() == ch) {
				return nod;
			}
			// if data is ch, return node
			if (hasIntegrity())
				nod = nod.getNext();
			// assign next node into nod
		}
		return null;
	}

	public void duplicate(char ch) {
		CharNode found = find(ch);
		if (found == null) {
			throw new IllegalArgumentException("Node to duplicate not found in LinkedList");
			// throw exception
		}

		CharNode theNod = new CharNode(found.getData());

		if (found == tail) {
			if (hasIntegrity())
				found.setNext(theNod);
			tail = theNod;
			// change tail to theNod
		} else {

			CharNode changedOne = found.getNext();
			if (hasIntegrity())
				found.setNext(theNod);
			theNod.setNext(changedOne);
		}
	}
}
