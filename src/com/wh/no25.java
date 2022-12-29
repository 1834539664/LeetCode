package com.wh;

import java.util.Stack;

/**
 * @author WH
 * @version 1.0
 * @date 2022/11/13 20:38
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，
 * 那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class no25 {
    //受到两两交换启发,尝试使用递归解决
    //因为不知道确切的k值,直接使用指针很不明智,使用栈来进行交换
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.next;
            }
        }
        if (stack.size() < k) {
            return head;
        }
        ListNode newHead = stack.pop();
        ListNode lastNode = newHead;
        while (!stack.isEmpty()) {
            lastNode.next = stack.pop();
            lastNode = lastNode.next;
        }
        lastNode.next = reverseKGroup(temp, k);
        return newHead;
    }
}
