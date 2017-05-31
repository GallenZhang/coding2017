package week11.basic;

@SuppressWarnings("rawtypes")
public class BinarySearchTree<T extends Comparable> {
	BinaryTreeNode<T> root;

	public BinarySearchTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public T findMin() {
		if(root == null){
			return null;
		}
		
		BinaryTreeNode<T> node = root;
		while(node.left != null){
			node = node.left;
		}
		return node.data;
	}

	public T findMax() {
		if(root == null){
			return null;
		}
		
		BinaryTreeNode<T> node = root;
		while(node.right != null){
			node = node.right;
		}
		return node.data;
	}

	public int height() {
		BinaryTreeNode<T> node = root;
		return height(node);
	}

	private int height(BinaryTreeNode<T> node){
		if(node == null){
			return 0;
		}else{
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public int size() {
		BinaryTreeNode<T> node = root;
		return size(node);
	}

	private int size(BinaryTreeNode<T> node){
		if(node == null){
			return 0;
		}else{
			return size(node.left) + size(node.right) + 1;
		}
	}
	
	public void remove(T e) {
		BinaryTreeNode<T> node = root;
		remove(node,e);
	}
	
	@SuppressWarnings("unchecked")
	private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T e){
		if(node == null){
			return node;
		}
		
		int result = e.compareTo(node.data);
		
		if(result > 0){
			node.right = remove(node.right, e);
		}else if(result < 0){
			node.left = remove(node.left, e);
		}else if(node.left != null && node.right != null){
			node.data = findMin(node.right);
			node.right = remove(node.right, node.data);
		}else{
			node = (node.left != null)? node.left : node.right;
		}
		
		return node;
		
	}
	
	private T findMin(BinaryTreeNode<T> node){
		if(node == null){
			return null;
		}
		
		while(node.left != null){
			node = node.left;
		}
		return node.data;
	}
}
