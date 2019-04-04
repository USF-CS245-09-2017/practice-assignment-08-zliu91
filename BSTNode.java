public class BSTNode<T> {
	protected Comparable<T> data;
	protected BSTNode<T> left;
	protected BSTNode<T> right;

	public BSTNode(Comparable<T> data) {//initialize a node
		this.data = data;
		left = null;
		right = null;
	}


}