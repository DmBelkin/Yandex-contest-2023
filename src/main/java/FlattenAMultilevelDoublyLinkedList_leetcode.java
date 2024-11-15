import java.util.ArrayList;
import java.util.List;

public class FlattenAMultilevelDoublyLinkedList_leetcode {

     List<Node> stack = new ArrayList<>();

    public Node flatten(Node head) {
        while (head != null) {
            if (head.child != null) {
                if (head.next != null) {
                    stack.add(head.next);
                }
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
            }
            if (head.next == null && !stack.isEmpty()) {
                head.next = stack.get(stack.size() - 1);
                head.next.prev = head;
                stack.remove(stack.size() - 1);
            }
            if (head.next == null) {
                return reverse(head);

            }
            head = head.next;
        }
        return head;
    }

    public Node reverse(Node head) {
        while (head != null) {
            head = head.prev;
            if (head.prev == null) {
                return head;
            }
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
