package week10.tree;

public class BinaryTreeNode<T> {
	
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data){
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T> insert(T data){
		int comparaResult = (Integer)this.data - (Integer)data;
		if(comparaResult > 0){
			if(this.left == null){
				this.left = new BinaryTreeNode<T>(data);
				return this.left;
			}else{
				return this.left.insert(data);
			}
		}else if(comparaResult < 0){
			if(this.right == null){
				this.right = new BinaryTreeNode<T>(data);
				return this.right;
			}else{
				return this.right.insert(data);
			}
		}else{
			return this;
		}
	}
	
}
