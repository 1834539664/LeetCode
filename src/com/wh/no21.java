package com.wh;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/11 0:08
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class no21 {
    //思路:连个指针分别指向list1 和 list2 中的元素,比较大小,然后合成即可

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();//head的next是真正的头节点
        ListNode temp = head;//指向新链表的最后一个节点
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            }
        }
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
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

class Test21 {
    @Test
    void test21() {
        no21.ListNode listNode1 = new no21.ListNode(1);
        no21.ListNode listNode2 = new no21.ListNode(2);
        no21.ListNode listNode3 = new no21.ListNode(4);
        no21.ListNode listNode4 = new no21.ListNode(1);
        no21.ListNode listNode5 = new no21.ListNode(3);
        no21.ListNode listNode6 = new no21.ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        no21.ListNode listNode = new no21().mergeTwoLists(listNode1, listNode4);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}