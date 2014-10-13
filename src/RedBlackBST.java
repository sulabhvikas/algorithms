
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		Key key;
		Node left;	
		Node right;
		Value val;
		boolean color;
		
		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;  //color of parent link
		}
	}

	public Value get(Key key) {
		Node x = root;
		
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else return x.val;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node h, Key key, Value val) {
		if (h == null) return new Node(key, val, RED); //insert first node and color red
		int cmp = key.compareTo(h.key);
		if(cmp < 0)
			h.left = put(h.left, key, val);
		if(cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;
		
		if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); //lean left
		if (isRed(h.left) && !isRed(h.left.left)) h = rotateRight(h); //balance 4-node
		if (isRed(h.left) && isRed(h.right)) flipColors(h); //split 4-node
		
		return h;
	}	
	
	private boolean isRed(Node x) {
		if (x == null) return false;  //null links are black
		return x.color == RED;				
	}
	
	private Node rotateLeft(Node h) {
		assert isRed(h.right);
		Node x = h.right;
		h.right = h.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;		
	}

	private Node rotateRight(Node h) {
		assert isRed(h.left);
		Node x = h.left;
		h.left = h.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;		
	}
	
	private void flipColors(Node h) {
		assert !isRed(h);
		assert isRed(h.left);
		assert isRed(h.right);
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;				
	}	
}
