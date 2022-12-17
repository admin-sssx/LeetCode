package test;

import util.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        int a[] = {7,2,0,8,3,9};

        List<Integer> resultList = new ArrayList<>(a.length);

        for (Integer s : a) {

            resultList.add(s);

        }
        tree.setRoot(tree.fullTreeAddNode(resultList));
        tree.levelGroup(tree.getRoot());
    }
}
