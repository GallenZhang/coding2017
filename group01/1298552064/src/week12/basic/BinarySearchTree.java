package week12.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class BinarySearchTree<T extends Comparable> {

	BinaryTreeNode<T> root;

	public BinarySearchTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public List<T> levelVisit() {
		BinaryTreeNode<T> node = root;
		List<T> result = new ArrayList<T>();
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()){
			root = queue.poll();
			result.add(root.getData());
			if(root.getLeft() != null){
				queue.offer(root.getLeft());
			}
			if(root.getRight() != null){
				queue.offer(root.getRight());
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public boolean isValid() {
		BinaryTreeNode<T> node = root;
		if(root == null){
			return true;
		}
		
		List<T> list = new ArrayList<>();
		pushToList(node, list);
		for(int i = 1; i < list.size();i++){
			if(list.get(i).compareTo(list.get(i-1)) < 0){
				return false;
			}
		}
		
		return true;
	}
	
	private void pushToList(BinaryTreeNode<T> node, List<T> list){
		if(node == null){
			return ;
		}
		
		if(node.left != null){
			pushToList(node.left, list);
		}
		
		list.add(node.data);
		
		if(node.right != null){
			pushToList(node.right, list);
		}
	}

	
	

	public T getLowestCommonAncestor(T n1, T n2) {
		if(root == null){
			return null;
		}
		BinaryTreeNode<T> node = root;
		return getLowestCommonAncestor(node,n1,n2);
	}
	
	@SuppressWarnings("unchecked")
	private T getLowestCommonAncestor(BinaryTreeNode<T> node , T n1, T n2){
		if(node == null){
			return null;
		}
		
		if(node.data.compareTo(n1) > 0 && node.data.compareTo(n2) > 0){
			return getLowestCommonAncestor(node.left, n1, n2);
		}else if(node.data.compareTo(n1) < 0 && node.data.compareTo(n2) < 0){
			return getLowestCommonAncestor(node.right, n1, n2);
		}else{
			return node.data;
		}
		
	}

	/**
	 * 返回所有满足下列条件的节点的值： n1 <= n <= n2 , n 为 该二叉查找树中的某一节点
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getNodesBetween(T n1, T n2) {
		List<T> list = new ArrayList<>();
		for(T t : levelVisit()){
			if(t.compareTo(n1) >= 0 && t.compareTo(n2) <= 0){
				list.add(t);
			}
		}
		
		Collections.sort(list);
		
		return list;
	}
}
