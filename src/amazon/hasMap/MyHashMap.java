package amazon.hasMap;

//only get put for now
public class MyHashMap<K, V> {
    public  static final int INITIAL_SIZE= 1<<4; // 16 as initial size
    public static final int  MAX_CAPAXITY=1<<30;
    public class Entry<K,V>{
        K key;
        V value;
        public Entry next;
        Entry(K key_, V value_){
            key=key_;
            value=value_;
            next=null;
        }
    }
    public Entry[] hashTable;
    public int getNextCapacity(int cap){
        int mostSignificantSetBit=cap-1;
        mostSignificantSetBit |= mostSignificantSetBit >>> 1;
        mostSignificantSetBit |= mostSignificantSetBit >>> 2;
        mostSignificantSetBit |= mostSignificantSetBit >>> 4;
        mostSignificantSetBit |= mostSignificantSetBit >>> 8;
        mostSignificantSetBit |= mostSignificantSetBit >>> 16;
        return  (mostSignificantSetBit<0)? 1 :(mostSignificantSetBit>MAX_CAPAXITY ? MAX_CAPAXITY : mostSignificantSetBit+1);
    }
    MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }
    MyHashMap(int capacity){
        int nextCapacity=getNextCapacity(capacity);
        hashTable = new Entry[nextCapacity];
    }
    public void put(K key , V value){
        int hasCode=Math.abs(key.hashCode()) % hashTable.length;
        Entry node = hashTable[hasCode];
        Entry prevNode=node;
        if(node==null){
            Entry newNode= new Entry(key,value);
            hashTable[hasCode]=newNode;
        }else {
            while (node != null) {
                if (node.key.equals(key)){
                    node.value=value;
                    return;
                }
                prevNode=node;
                node=node.next;
            }
            Entry newNode= new Entry(key,value);
            prevNode.next=newNode;
        }
    }

    public V get(K key){
        int hasCode=Math.abs(key.hashCode()) % hashTable.length;
        Entry node = hashTable[hasCode];
        while (node!=null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node=node.next;
        }
        return null;
    }

    public boolean remove (K key){
        // check if exist thorugh out if exist delte that node
        int hasCode=Math.abs(key.hashCode()) % hashTable.length;
        Entry node = hashTable[hasCode];
        Entry prevNode=null;
        while (node != null) {
                if (node.key.equals(key)) {
                    if(prevNode!=null)
                      prevNode.next=node.next;
                    else
                        hashTable[hasCode] = node.next;
                    return true;
                }
                prevNode=node;
                node=node.next;
        }
       return false;
    }

}

