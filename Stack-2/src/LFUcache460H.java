/*
import java.util.HashMap;
import java.util.Map;

public class LFUcache460H
{
    public static void main(String[] args)
    {
        Lfu cash = new Lfu(3);
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

class Lfu
{
   class DLLNode
   {
       int key;
       int value;
       int frequency;
       DLLNode next;
       DLLNode prev;

       public DLLNode(int key, int value)
       {
           this.key = key;
           this.value = value;
           this.next = null;
           this.prev = null;
           this.frequency =1;
       }
   }

    class DoubleLinkedList
    {
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList()
        {
            this.listSize = 0;
            head = new DLLNode(0, 0);
            tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode curNode)
        {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(DLLNode curNode)
        {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

        Map<Integer, DLLNode> cache;
        Map<Integer, DoubleLinkedList> frequencyMap;
        int capacity;
        int curSize;
        int minFrequency;

        public Lfu(int capacity)
        {
            cache = new HashMap<>();
            frequencyMap = new HashMap<>();
            this.capacity = capacity;
            this.curSize = 0;
            this.minFrequency = 0;
        }

        public int get(int key)
        {
            DLLNode curNode = cache.get(key);
            if (curNode == null)
                return -1;
            updateNode(curNode);
            return curNode.value;
        }

        public void updateNode(DLLNode curNode)
        {
            int curFreq = curNode.frequency;
            DoubleLinkedList curList = frequencyMap.get(curFreq);
            curList.removeNode(curNode);

            if (curFreq == minFrequency && curList.listSize == 0)
                minFrequency++;

            curNode.frequency++;
            DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
            newList.addNode(curNode);
            frequencyMap.put(curNode.frequency, newList);
        }


        public void put(int key, int value) {
            if (capacity == 0)
                return;
            if (cache.containsKey(key))
            {
                DLLNode curNode = cache.get(key);
                curNode.value = value;
                updateNode(curNode);
            }
            else
            {
                curSize++;
                if (curSize > capacity)
                {
                    DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                    cache.remove(minFreqList.tail.prev.key);
                    minFreqList.removeNode(minFreqList.tail.prev);
                    curSize--;
                }

                minFrequency = 1;

                DLLNode newNode = new DLLNode(key, value);
                DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
                curList.addNode(newNode);
                frequencyMap.put(1, curList);
                cache.put(key, newNode);
            }
        }
}
*/
