class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    private Node deleteNode(Node node) {
        Node oldPrev = node.prev;
        Node oldNext = node.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
        node.next = null;
        node.prev = null;
        return node;
    }

    private void addNode(Node node) {
        Node oldNext = head.next;
        head.next = node;
        oldNext.prev = node;
        node.prev = head;
        node.next = oldNext;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node mru = this.map.get(key);
            mru = deleteNode(mru);
            addNode(mru);
            return mru.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (this.map.containsKey(key)) {
            deleteNode(this.map.get(key));
            this.map.remove(key);
        }
        if (this.map.size() >= this.capacity) {
            Node lru = tail.prev;
            lru = deleteNode(lru);
            this.map.remove(lru.key);
        }
        addNode(newNode);
        this.map.put(newNode.key, newNode);
    }
}