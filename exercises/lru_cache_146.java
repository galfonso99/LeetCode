// import java.util.LinkedList;
import java.util.HashMap;

public class lru_cache_146 {
    public static void main(String[] args) {
        var lru = new LRUCache(1);
        lru.put(2, 1);
        int res1 = lru.get(2);
        lru.put(3,2);
        int res2 = lru.get(2);
        int res3 = lru.get(3);
        System.out.printf("res: %d, %d, %d \n", res1, res2, res3);
        // var res = sol.reverseList(list);
        // out.printf("The result is %d %n", res.val);
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode prev;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class MyLinkedList {
    int size;
     ListNode head;
     ListNode tail;
     MyLinkedList() {this.size = 0;}
 }

class LRUCache {
    int capacity;
    MyLinkedList list;
    HashMap<Integer, ListNode> lookup;
    HashMap<ListNode, Integer>  reverseLookup;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new MyLinkedList();
        this.lookup = new HashMap<Integer, ListNode>();
        this.reverseLookup = new HashMap<ListNode, Integer>();
    }


    public int get(int key) {

        var node = this.lookup.get(key);
        if (node == null) {
            return -1;
        }
        moveNodeFront(node);
        return node.val;

    }
    void put (int key, int value) {
        var node = this.lookup.get(key);
        if (node != null) {
            moveNodeFront(node);
            this.list.head.val = value;
        } else if (this.list.size == this.capacity) {
            insertNodeFront(key, value);
            deleteLastNode();
        }else {
            insertNodeFront(key, value);
        }
    }
    public void moveNodeFront(ListNode node) {
        if (this.list.size < 2) {
            return;
        }
        if (this.list.head == node) {
            return;
        }
        var next = node.next;
        var prev = node.prev;
        if (node == this.list.tail) {
            this.list.tail = this.list.tail.prev;
        }
        node.prev = null;
        node.next = this.list.head;
        this.list.head.prev = node;
        this.list.head = node;
        // Remove the reference at the very end so that the list never becomes empty
        if (next != null) {
            next.prev = prev;
        }
        if (prev != null) {  
             prev.next = next;
        }
    }

    void insertNodeFront(int key, int value) {
        var node = new ListNode(value);
        node.next = this.list.head;
        if (this.list.head == null) {
            this.list.head = node;
            this.list.tail = node;
        } else {
            this.list.head.prev = node;
            this.list.head = node;
        }
        if (this.list.size == 1) {
            this.list.tail.prev = node;
        }
        this.list.size++;
        this.lookup.put(key, node);
        this.reverseLookup.put(node, key);
    }

    boolean deleteLastNode () {
        var curr_tail = this.list.tail;
        if (this.list.size == 0) {
            return false;
        }
        if (this.list.tail != null && this.list.tail.prev != null) {
            this.list.tail.prev.next = null;
            this.list.tail = this.list.tail.prev;
        } else {
            this.list.head = null;
            this.list.tail = null;
        }
        this.list.size--;
        var key = this.reverseLookup.get(curr_tail);
        this.lookup.remove(key);
        this.reverseLookup.remove(curr_tail);
        return true;
    }
}

