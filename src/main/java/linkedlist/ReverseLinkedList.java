package linkedlist;

/**
 * 206.反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

    // 遍历的时候把节点存起来，修改curr的next;  时间复杂度O(n)
    public ListNode solutionA(ListNode head) {
        ListNode prev = null;  // 记录前面的节点
        ListNode curr = head;  // 记录当前节点
        while (curr != null) {

            ListNode temp = curr.next;  // 缓存原先的next
            curr.next = prev;  // 修改next为上一个节点
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // 递归的方式  a->b  变成 a<-b  等于是 a.next.next=a
    // 时间复杂度是 O(n)
    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
