package com.jackzhang.leetcode;

import com.google.gson.Gson;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long value1 = l1.val;
        long tmp = 1L;
        while (true) {
            if (l1.next != null) {
                l1 = l1.next;
                tmp = tmp*10L;
                value1 += l1.val*tmp;
            } else {
                break;
            }
        }

        long value2 = l2.val;
        tmp = 1L;
        while (true) {
            if (l2.next != null) {
                l2 = l2.next;
                tmp = tmp*10L;
                value2 += l2.val*tmp;
            } else {
                break;
            }
        }
        long value = value1 + value2;
        System.out.println(value);
        if (value == 0) {
            return new ListNode(0);
        }
        ListNode listNode = null;
        boolean isFirst = true;
        while (value > 0) {
            if (isFirst) {
                listNode = new ListNode((int)(value%10L));
                isFirst = false;
            } else {
                ListNode flag = listNode;
                while (flag.next != null) {
                    flag = flag.next;
                }
                flag.next = new ListNode((int)(value%10L));
            }
            value = value / 10L;
        }
        return listNode;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }

        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    public static void main(String args[]) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);

//        System.out.println(new Gson().toJson(addTwoNumbers(l1, l2)));
        System.out.println(Integer.MAX_VALUE);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
