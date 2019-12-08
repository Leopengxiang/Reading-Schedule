import java.util.Stack;

public class PrintListRerversly {

    public static void printReversely(ListNode n) {
        if (n == null) {
            return;
        }
        if (n.next != null) {
            printReversely(n.next);
        }
        System.out.print(n.value + "->");
    }

    public static void printReverseIterately(ListNode n) {
        Stack<Integer> x = new Stack<>();
        while (n != null) {
            x.push(n.value);
            n = n.next;
        }
        while (!x.isEmpty()) {
            System.out.print(x.pop() + "->");
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        ListNode pre = l;
        for (int i = 4; i > 0; i--) {
            l.next = new ListNode(i);
            l = l.next;
        }
        printReverseIterately(pre);
    }
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int v) {
        value = v;
    }
}