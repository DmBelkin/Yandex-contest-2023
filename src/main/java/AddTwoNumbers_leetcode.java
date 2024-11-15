import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers_leetcode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();
        List<ListNode> list1 = new ArrayList<>();
        while (l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            list1.add(l2);
            l2 = l2.next;
        }
        List<ListNode> biggestList = list.size() > list1.size() ? list : list1;
        List<ListNode> smallestList = list.size() > list1.size() ? list1 : list;
        ListNode node = null;
        int index = smallestList.size() - 1;
        int transfer = 0;
        for (int i = biggestList.size() - 1; i >= 0; i--) {
            int value;
            ListNode node1 = new ListNode();
            if (index >= 0) {
                value = biggestList.get(i).val + smallestList.get(index--).val
                        + transfer;
            } else {
                value = biggestList.get(i).val + transfer;
            }
            if (value >= 10) {
                value -= 10;
                transfer = 1;
            } else {
                transfer = 0;
            }
            node1.val = value;
            node1.next = node;
            node = node1;
            if (i == 0 && transfer == 1) {
                ListNode nextNode = new ListNode(transfer);
                nextNode.next = node;
                node = nextNode;
            }
        }
        return node;
    }

    public class ListNode {
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
}
