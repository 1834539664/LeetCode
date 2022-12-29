package com.wh.no19;

import java.util.Stack;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/10 23:22
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class no19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> nodes = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        for (int i = 0; i < n; i++) {
            nodes.pop();
        }
        if (nodes.isEmpty()) {
            head = head.next;
        }else {
            ListNode deleteNodeParent = nodes.pop();
            deleteNodeParent.next = deleteNodeParent.next.next;
        }
        return head;
    }
}


class ListNode {
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