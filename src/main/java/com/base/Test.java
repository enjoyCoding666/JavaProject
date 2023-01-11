package com.base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 右视图遍历二叉树
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *
 */
public class Test {


    public List<Integer> getList(ListNode node) {
        if (node==null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<ListNode> queue = new ArrayDeque<>();
        while (queue.size()!=0) {
            queue.add(node);
            int size = queue.size();
            for (;size>0;size--) {
                ListNode listNode = queue.poll();
                if (size==1 && listNode!=null && listNode.right!=null) {
                    list.add(listNode.val);
                    queue.add(listNode.right);
                } else if (size==1 && listNode!=null) {
                    list.add(listNode.val);
                    queue.add(listNode.left);
                }
            }

        }
        return list;


    }


    class ListNode {
        private ListNode left;

        private ListNode right;

        private Integer val;

    }

}
