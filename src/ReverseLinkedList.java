/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * https://leetcode.com/problems/reverse-linked-list/submissions/1423739102
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        processList(new int[]{1, 2, 3, 4, 5});
        processList(new int[]{1, 2});
        processList(new int[]{});
    }

    /**
     * Creates a reverted list of nodes and displays their values.
     *
     * @param input Array of values to create the list from.
     */
    public static void processList(int[] input) {
        ListNode head = input.length == 0 ? null : new ListNode();
        ListNode currentNode = head;
        for (int i = 0; i < input.length; i++) {
            currentNode.val = input[i];
            if (i != input.length - 1) {
                currentNode.next = new ListNode();
            }
            currentNode = currentNode.next;
        }
        ListNode newHead = reverseList(head);
        if (newHead == null) {
            System.out.print("Empty List");
        }
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    };

    /**
     * Performs reversing the list.
     *
     * @param head Head element of the input list.
     * @return Head element of the reverted list.
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode lastAdded = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = lastAdded;
            lastAdded = current;
            current = next;
        }
        return lastAdded;
    }
}

