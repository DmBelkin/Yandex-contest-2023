import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_leetcode {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Comparator<ListNode> comp = Comparator.comparing(o -> o.val);
        ListNode res = new ListNode();
        ListNode ret = res;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comp);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            res.val = node.val;
            if (node.next != null) {
                node = node.next;
                queue.add(node);
            }
            if(!queue.isEmpty()) {
                res.next = new ListNode();
                res = res.next;
            }
        }
        return ret;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
