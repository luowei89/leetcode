/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map;
        map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = head;
        while(p != null){
            map.put(p,new RandomListNode(p.label));
            p = p.next;
        }
        RandomListNode newHead = map.get(head);
        p = head;
        RandomListNode q = newHead;
        while(p != null){
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}