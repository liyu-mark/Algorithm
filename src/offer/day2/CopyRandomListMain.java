package offer.day2;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class CopyRandomListMain {

    public Node copyRandomList(Node head) {
        Node dumpy = new Node(-1);
        Node p = dumpy;
        while (head!=null){
            p.next = head;
            p = head;
            head = head.next;
        }
        return dumpy.next;
    }

}
class Node {
     int val;
     Node next;
     Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}