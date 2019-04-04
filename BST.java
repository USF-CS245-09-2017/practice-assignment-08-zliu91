public class BST<T> {
	protected BSTNode<T> root;//root is the top node of the tree

	public boolean find(Comparable<T> value) {
		return find(root, value);
	}

	private boolean find(BSTNode<T> node, Comparable<T> value) {
		if (node == null) {//base case
			return false;
		}
		if (node.data.compareTo((T)value) == 0) { //find it!
			return true;
		} else if (node.data.compareTo((T)value) > 0) {//go left when the value is smaller than the data
			return find(node.left, value);
		} else {//go right
			return find(node.right, value);
		}
	}

	public void insert(Comparable<T> value) {
		root = insert(root, value);
	}

	private BSTNode<T> insert(BSTNode<T> node, Comparable<T> value) {
		if (node == null) {//find the right place! create a new node;
			BSTNode<T> newNode = new BSTNode<T>(value);
			return newNode;
		} else if (node.data.compareTo((T)value) < 0) {//go right and return itself
			node.right = insert(node.right,value);
			return node;
		} else {//go left and return itself
			node.left = insert(node.left,value);
			return node;
		}
	}

	public void delete(Comparable<T> value) {
		root=delete(root, value);
	}

	private BSTNode<T> delete(BSTNode<T> node, Comparable<T> value) {
		if(node==null) {//can not find the value
			return null;
		}
		if(node.data.compareTo((T)value)==0) {//find the value!
			if(node.left==null) {//delete it and replace it by right
				return node.right;
			} else if(node.right==null) {//replace it by left
				return node.left;
			} else {
				if(node.right.left==null) {//connect right and left, then delete it;
					node.data=node.right.data;
					node.right=node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if(node.data.compareTo((T)value)>0) {//go right
			delete(node.right,value);
		} else {//go left
			delete(node.left,value);
		}
		return node;
	}

	public void print() {
		print(root);
	}

	private void print(BSTNode<T> node) {
		if (node != null) {
			print(node.left);//go left
			System.out.println(node.data);//print itself
			print(node.right);//go right
		}
	}

	public Comparable<T> removeSmallest(BSTNode<T> node) {
		if(node.left.left==null){
			BSTNode smallest = node.left.right;
			node.right = node.left.right;
			return smallest.data;
		} else {
			return removeSmallest(node.left);
		}
	}










}