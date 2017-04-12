package com.offer1;

import com.model.TreeNode;

/**
 * 输入两颗二叉树A，B，判断B是不是A的子结构
 * 
 * /*思路： 1、首先设置标志位result =false，因为一旦匹配成功result就设为true，
 * 剩下的代码不会执行，如果匹配不成功，默认返回false
 * 
 * 2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（）， 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 * 再判断右子树和tree2是否相同
 * 
 * 3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 * DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功， tree1为空有两种情况
 * （1）如果tree1为空&&tree2不为空说明不匹配，
 * 
 * （2）如果tree1为空，tree2为空，说明匹配。
 * 
 * @author XIAO
 *
 */
public class BisAsubTree {

	/**
	 * 当root1.val == root2.val时，看root2是否包含在root1中
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		// 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
		if (root1 != null && root2 != null) {
			// 如果找到了对应Tree2的根节点的点
			if (root1.val == root2.val) {
				result = DoesTree1HaveTree2(root1, root2);
			}
			// 如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			// 如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
	}

	/**
	 * 判断root1中是否含有root，则递归判断 1.如果root1 ==
	 * null,root2!=null，这时候root1已经没有了，但是root还有，显然root2不包含在root1中 2.root2 ==
	 * null,这时是root没有了，说明root2中的节点一个一个的匹配root1的节点（顺序也一致），说明root2包含在root1中
	 * 3.root1.val != root2.val ，显然返回false 4.root1.val == root.val
	 * 这时要继续递归，同时比较root1和root2的左右子树。
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		// 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
		if (root1 == null && root2 != null)
			return false;
		// 如果Tree2已经遍历完了都能对应的上，返回true
		if (root2 == null)
			return true;
		// 如果其中有一个点没有对应上，返回false
		if (root1.val != root2.val)
			return false;
		// 如果根节点对应的上，那么就分别去子节点里面匹配
		return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
	}
}
