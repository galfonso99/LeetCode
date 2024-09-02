import java.util.HashMap;

public class lru_cache_part_2_146 {
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

class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        var node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            add(new Node(key, value));
        } else if (map.size() == capacity) {
            remove(tail.prev);
            add(new Node(key, value));
        } else {
            add(new Node(key, value));
        }
    }

    public void add(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }

    public void remove(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        map.remove(node.key);
    }
}

/* Solution from the web

public class LRUCache {
    private class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
        Node(){
            this(0, 0);
        }
    }
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
}

*/
