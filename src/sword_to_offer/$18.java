package sword_to_offer;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.List;

/**
 * Created by Yang Liu on 2019/2/27
 */
// 删除链表的结点
public class $18 {
    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(ListNode listHead, ListNode toBeDeleted) {
        if (listHead == null || toBeDeleted == null) {
            return;
        }

        // 要删除的结点不是尾结点
        if (toBeDeleted.next != null) {
            ListNode pNext = toBeDeleted.next;
            toBeDeleted.value = pNext.value;
            toBeDeleted.next = pNext.next;

            pNext = null;
        } else if (listHead == toBeDeleted) {
            // 链表中只有一个结点
            toBeDeleted = null;
            listHead = null;
        } else {
            // 链表有多个结点，删除尾结点
            ListNode node = listHead;
            while (node.next != toBeDeleted) {
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        deleteNode(node1, node3);

        ListNode node = node1;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}

