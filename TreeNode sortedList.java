import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        if (head.next == null) return new TreeNode(head.val);
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public List<String> treeToList(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
                continue;
            }

            result.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i--);
        }

        return result;
    }

    public ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        System.out.println("Enter the number of elements in the sorted linked list:");
        int n = scanner.nextInt();

        int[] input = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        ListNode head = solution.createList(input);
        TreeNode bst = solution.sortedListToBST(head);

        System.out.println("Input: head = " + Arrays.toString(input));
        System.out.println("Output (level-order BST): " + solution.treeToList(bst));
    }
}