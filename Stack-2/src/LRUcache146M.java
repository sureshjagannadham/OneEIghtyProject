import java.util.HashMap;
import java.util.Map;

public class LRUcache146M
{
    public static void main(String[] args)
    {
        Cache cash = new Cache(4);
        cash.put(2,6);
        cash.put(4,7);
        cash.put(8,11);
        cash.put(7,10);
        System.out.println(cash.get(2));
        System.out.println(cash.get(8));
        cash.put(5,6);
        System.out.println(cash.get(7));
        cash.put(5,7);
    }
}

class Cache
{
    private class Node
    {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> mpp;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public Cache(int capacity) {
        mpp = new HashMap<>();;
        head = new Node(0,0);
        tail = new Node(0,0);
        this.size =0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev= head;
    }

    int get(int key)
    {
        if(!mpp.containsKey(key))
            return -1;
        Node node = mpp.get(key);
        deleteHead(node);
        afterHead(node);
        return node.val;
    }

    void put(int key, int val)
    {
        if(mpp.containsKey(key))
        {
            Node node = mpp.get(key);
            node.val = val;
            deleteHead(node);
            afterHead(node);
        }

        else {
            if(size >= capacity)
            {
                Node node = tail.prev;
                mpp.remove(node.key);
                deleteHead(node);
                size--;
            }

            Node node = new Node(key, val);
            mpp.put(key, node);
            afterHead(node);
            size++;
        }
    }

    void afterHead(Node node)
    {
        Node curafterHead = head.next;
        head.next = node;
        node.next = curafterHead;
        node.prev = head;
        if (curafterHead != null)
            curafterHead.prev = node;
    }

    void deleteHead(Node node)
    {
        Node prevNode = node.prev;
        Node afterNode = node.next;
        if(prevNode != null)
            prevNode.next = afterNode;
        if(afterNode != null)
            afterNode.prev = prevNode;
    }
}
