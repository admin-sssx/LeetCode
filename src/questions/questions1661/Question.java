package questions.questions1661;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Definition for a binary tree node.
 * */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
 this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int maxLevelSum(TreeNode root) {
        int res =0 ;
        TreeNode result = root;
        LinkedBlockingQueue<TreeNode> q = new LinkedBlockingQueue();
        List<LinkedBlockingQueue<TreeNode>> queueList = new ArrayList<>();
        queueList.add(q);
        q.add(root);
        for (int i = 0; i < queueList.size(); i++) {
            LinkedBlockingQueue<TreeNode> queue = queueList.get(i);
            LinkedBlockingQueue<TreeNode> nextQueue = null;
            System.out.println("i="+i);
            int temp = 0;
            while(queue.size()>0) {
                TreeNode x = queue.remove();
                temp = temp+x.val;
                if(x.left!=null) {
                    if(nextQueue == null) {
                        nextQueue = new LinkedBlockingQueue();
                    }
                    nextQueue.add(x.left);
                }
                if(x.right!=null) {
                    if(nextQueue == null) {
                        nextQueue = new LinkedBlockingQueue();
                    }
                    nextQueue.add(x.right);
                }
                result = x;
            }
            System.out.println();
            if(nextQueue!=null)
                queueList.add(nextQueue);
            if(temp>res) {
                res = temp;
            }
        }
        return res;
    }

//    public TreeNode levelGroup (TreeNode root) {
//
//    }
}

public class Question{


}
