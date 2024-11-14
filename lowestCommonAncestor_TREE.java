
 // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 // Output: 3
 // Explanation: The LCA of nodes 5 and 1 is 3.

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
         if(left == null){
            return right;
         }
          if(right == null){
            return left;
         }
         else{
            return root;
         }        
    }
}
