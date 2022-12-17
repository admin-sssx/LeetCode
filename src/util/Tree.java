package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Tree<T> {
    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    TreeNode<T> root;

    /**
     * 给定list构造满二叉树
     */
//    Tree() {
//
//    }


    /**
     * 层次遍历
     */
//    public void levelDraversal (TreeNode<T> root) {
//
//
//    }

    /**
     * 返回满二叉树第一个未满的节点
     */
    public TreeNode<T> levelDraversal (TreeNode<T> root) {
        TreeNode<T> result = root;
        LinkedBlockingQueue<TreeNode<T>> queue = new LinkedBlockingQueue();
        queue.add(root);
        while(queue.size()>0) {
            TreeNode<T> x = queue.remove();
            if(x.left==null) {
                return x;
            }
            else if(x.right==null) {
                return x;
            }
            else if(x.left!=null) {
                queue.add(x.left);
            }
             if(x.right!=null) {
                queue.add(x.right);
            }
            System.out.println(x.getVal());
            result = x;
        }
        System.out.println("------");
        System.out.println();

        return result;
    }

    /**
     * 二叉树每一层的元素
     */
    public TreeNode<T> levelGroup (TreeNode<T> root) {
        TreeNode<T> result = root;
        LinkedBlockingQueue<TreeNode<T>> q = new LinkedBlockingQueue();
        List<LinkedBlockingQueue<TreeNode<T>>> queueList = new ArrayList<>();
        queueList.add(q);
        q.add(root);
        for (int i = 0; i < queueList.size(); i++) {
            LinkedBlockingQueue<TreeNode<T>> queue = queueList.get(i);
            LinkedBlockingQueue<TreeNode<T>> nextQueue = null;
            System.out.println("i="+i);
            while(queue.size()>0) {
                TreeNode<T> x = queue.remove();
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
                System.out.println("x="+x.getVal());
                result = x;
            }
            System.out.println();
            if(nextQueue!=null)
            queueList.add(nextQueue);
        }

        System.out.println("------");
        System.out.println();

        return result;
    }

    public TreeNode<T> fullTreeAddNode(List<T> list) {
        TreeNode<T> root = new TreeNode<>();
        root.setVal(list.get(0));
        list.remove(0);
        list.forEach(
                x->{
                    TreeNode<T> node = new TreeNode<>();
                    node.setVal(x);
                    System.out.println("xxx");
                    TreeNode<T> position = levelDraversal(root);
                    if(position.left == null) {
                        position.left = node;
                    } else if(position.right == null) {
                        position.setRight(node);
                    }
                }
        );
        return root;
    }



}
