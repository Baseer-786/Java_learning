//Binary Tree Inorder Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
               List<Integer> res = new ArrayList<>();

        inorder(root, res);
        return res;        
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);

        
    }
}

//Same Tree

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        
        return false;        
    }
}

//Symmetric Tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ){
            return true;
        }     
        return isSymmetricHelp(root.left,root.right);
    }
    public boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right ;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetricHelp(left.left , right.right) && isSymmetricHelp(left.right,right.left);
    }
}

// Maximum Depth of Binary Tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
}

//Balanced Binary Tree
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right) ? true : false;

    }
}

// Minimum Depth of Binary Tree
class Solution {
    public int minDepth(TreeNode root) {
       
        if(root == null){
            return 0;
        }
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        if(lh == 0){
            return rh+1;
        }
        if(rh == 0){
            return lh+1;
        }
        return  Math.min(lh,rh)+1;
    }

        
    }

// Binary Tree Maximum Path Sum
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0]= Integer.MIN_VALUE;
        maxPathDown (root , maxValue);
        return maxValue[0] ;
        
    }
  private int maxPathDown(TreeNode node ,int maxValue[] ){
        if(node == null ){
            return 0 ;
        }
        int left = Math.max(0,maxPathDown(node.left,maxValue));
        int right = Math.max(0,maxPathDown(node.right,maxValue));
        maxValue[0] = Math.max(maxValue[0],left + right + node.val);
        return Math.max(left,right) + node.val;
        

    }
}

//Binary Tree Right Side View
// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:
// Input: root = []
// Output: []
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root , result ,0 );
        return result;       
    }
    public void rightView(TreeNode node ,List<Integer> result , int treeDepth){
        if(node == null){ return; }
        if(treeDepth == result.size()){  result.add(node.val); }
        rightView(node.right,result,treeDepth + 1);
        rightView(node.left,result,treeDepth + 1);
    }
}

// Lowest Common Ancestor of a Binary Tree
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.

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

// Binary Tree Paths
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null){
       searchBT(root, "", answer);
    } 
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null){
        answer.add(path + root.val);
    } 
    if (root.left != null) {
        searchBT(root.left, path + root.val + "->", answer);
    }
    if (root.right != null) {
        searchBT(root.right, path + root.val + "->", answer);
    }
}
        
    }








