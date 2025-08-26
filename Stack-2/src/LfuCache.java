import java.util.HashMap;
import java.util.Map;

public class LfuCache
{
    public static void main(String[] args)
    {
        LFU cash = new LFU(3);
        cash.put(1,10);
        cash.put(2,20);
        cash.put(3,30);
        cash.put(4,40);
        System.out.println(cash.get(3));
        System.out.println(cash.get(2));
        System.out.println(cash.get(4));
        cash.put(5,50);
        cash.put(2,25);
    }
}

class LFU
{
    class DLLNode
    {
        int key; int value; int frequency; DLLNode next; DLLNode prev;
        public DLLNode(int key, int value)
        {
            this.key = key; this.value = value; this.frequency = 1;
            this.next = null; this.prev = null;
        }
    }

    class DoubleLL
    {
        int listSize; DLLNode head; DLLNode tail;
        public DoubleLL()
        {
            this.listSize =0;
            head = new DLLNode(0,0);
            tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void removeNode(DLLNode curNode)
        {
            DLLNode prevNode = curNode.prev;
            DLLNode afterNode = curNode.next;
            if(prevNode != null)
                prevNode.next = afterNode;
            if(afterNode != null)
                afterNode.prev = prevNode;
            listSize--;
        }

        public void addNode(DLLNode curNode)
        {
            DLLNode curafterHead = head.next;
            head.next = curNode;
            curNode.next = curafterHead;
            curNode.prev = head;
            curafterHead.prev = curNode;
            listSize++;
        }
    }

    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLL> frequencyMap;
    int capacity;
    int curSize;
    int minFrequency;

    public LFU(int capacity)
    {
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
    }

    public void updateNode(DLLNode curNode)
    {
        int curFreq = curNode.frequency;
        DoubleLL curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if(curFreq == minFrequency && curList.listSize == 0)
            minFrequency++;
        curNode.frequency++;

        DoubleLL newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLL());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

    public void put(int key, int value)
    {
        if(capacity == 0)
            return;
        if(cache.containsKey(key))
        {
            DLLNode curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }

        else {
            curSize++;
            if(curSize > capacity)
            {
               DoubleLL minFreqList = frequencyMap.get(minFrequency);
               cache.remove(minFreqList.tail.prev.key);
               minFreqList.removeNode(minFreqList.tail.prev);
               curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLL curList = frequencyMap.getOrDefault(1, new DoubleLL());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public int get(int key)
    {
        DLLNode curNode = cache.get(key);
        if(curNode == null)
            return -1;
        updateNode(curNode);
        return curNode.value;
    }
}
