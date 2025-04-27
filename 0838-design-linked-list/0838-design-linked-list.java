class MyLinkedList {
    // Node class represents a single node in the linked list
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    // Constructor to initialize the linked list
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Get the value at the specified index
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1; // index is out of bounds
        }

        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // Add a node at the beginning (head)
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add a node at the end (tail)
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode; // If list is empty, the new node is the head
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Attach the new node to the last node
        }
        size++;
    }

    // Add a node at a specific index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return; // Index is out of bounds
        }

        if (index == 0) {
            addAtHead(val); // If inserting at the head
        } else {
            ListNode newNode = new ListNode(val);
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Delete the node at a specific index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return; // Index is out of bounds
        }

        if (index == 0) {
            head = head.next; // If deleting the head node
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next; // Remove the node at the index
        }
        size--;
    }
}
