package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/11 9:17
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class no23 {
    //三种思路:
    //1.基于两个链表合并,直接按顺序两两合并即可
    //2.基于连个链表合并,分治合并即可
    //3.使用集合保存每一个链表的第一个未保存节点,然后将较小的弹出
    //此处演示基于第三种思路的方法
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        //初始化,将每一个链表的头结点放入listNodes中
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                listNodes.add(node);
            }
        }
        //比较并取出元素
        ListNode head = new ListNode();//head的next节点是真正的头节点
        ListNode node = head; //指向最后一个保存的节点
        while (listNodes.size() != 0) {
            //临时变量,用来比较大小
            ListNode temp = new ListNode(Integer.MAX_VALUE);
            int index = -1;//保存下标
            for (int i = 0; i < listNodes.size(); i++) {
                if (temp.val > listNodes.get(i).val) {
                    temp = listNodes.get(i);
                    index = i;
                }
            }
            node.next = temp;
            node = node.next;
            //移除已保存节点
            if (temp.next==null){
                listNodes.remove(index);
            }else {
                listNodes.set(index, temp.next);
            }

        }

        return head.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

class Test23 {
    @Test
    void test23() {
        no23.ListNode node1 = new no23.ListNode(1);
        no23.ListNode node2 = new no23.ListNode(4);
        no23.ListNode node3 = new no23.ListNode(5);
        no23.ListNode node4 = new no23.ListNode(1);
        no23.ListNode node5 = new no23.ListNode(3);
        no23.ListNode node6 = new no23.ListNode(4);
        no23.ListNode node7 = new no23.ListNode(2);
        no23.ListNode node8 = new no23.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;

        no23.ListNode[] lists = {};
        no23.ListNode node = new no23().mergeKLists(lists);
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }

    }
}