package offer.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class CopyRandomListMain {

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node p = head;
        while (p!=null){
            Node clon = new Node(p.val);
            clon.next=null;
            clon.random=null;
            map.put(p,clon);
            p=p.next;
        }
        p=head;
        while (p!=null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
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