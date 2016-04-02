public class Solution {
    // TreeSet (binary search tree) O(nlgk)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= t + floor) {
                return true;
            }
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= t + nums[i]) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     LinkedList list = new LinkedList();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (i > k) {
    //             list.remove(i-k-1);
    //         }
    //         int diff = list.insert(i, nums[i]);
    //         if (diff <= t) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // LinkedList O(nk)
    // public class ListNode {
    //     int id;
    //     int val;
    //     ListNode next;
    //     public ListNode(int id, int val) {
    //         this.id = id;
    //         this.val = val;
    //     }
    // }
    // public class LinkedList {
    //     ListNode head;
    //     int size;
    //     public LinkedList() {
    //         head = new ListNode(-1, 0);
    //         size = 0;
    //     }
    //     public int insert(int id, int val) {
    //         ListNode p = head;
    //         ListNode q = head.next;
    //         while (q != null && q.val < val) {
    //             p = p.next;
    //             q = q.next;
    //         }
    //         ListNode newNode = new ListNode(id, val);
    //         newNode.next = q;
    //         p.next = newNode;
    //         int diffRight = q == null ? Integer.MAX_VALUE : q.val - val;
    //         int diffLeft = p.id == -1 ? Integer.MAX_VALUE : val - p.val;
    //         size++;
    //         return Math.min(diffLeft, diffRight);
    //     }
    //     public void remove(int id) {
    //         ListNode p = head;
    //         ListNode q = head.next;
    //         while (q != null && q.id != id) {
    //             p = p.next;
    //             q = q.next;
    //         }
    //         p.next = q.next;
    //         size--;
    //     }
    // }
}
