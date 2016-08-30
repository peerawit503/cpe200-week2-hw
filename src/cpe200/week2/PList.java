package cpe200.week2;

public class PList {
    public PList()
    {
        head = tail = null;
    }
    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }
    public void pushToTail(char i) {
        PNode temp = new PNode(i,head, null);
        if (tail==null)
        {
            tail = head;
        }
        else
        {
            temp.prev = tail;
            temp.next = null;
            tail.next = temp;
            tail = temp;
            size++;
        }
    }
    public char popHead() {
        char i=head.data;
        PNode tmp = head;
        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }
        size--;
        return i;
    }
    public char popTail() {
        char n = tail.data;
        PNode temp;
        if (tail.prev == null) {
            temp = tail;
            size--;
        }
        else {
            temp = tail;
            tail = temp.prev;
            tail.next = null;
            size--;
        }
        return n;
    }
    public boolean search(char i) {
        PNode temp;
        temp = head;
        if (temp.data == i)
        {
            return true;
        }
        while (temp.next.data != i) {
            temp = temp.next;
            if (temp.next == null) {
                return false;
            }
        }
        return true;
    }
    public boolean isEmpty()
    {
        return (head == null);
    }
    public void printForward() {
        PNode tmp = head;
        while (tmp != null)
        {
            System.out.println(tmp.data) ;
            tmp = tmp.next;
        }
    }
    public void printBackward() {
        PNode tmp = tail;
        while (tmp != null)
        {
            System.out.println(tmp.data) ;
            tmp = tmp.prev;
        }
    }
    public int getSize()
    {
        return size;
    }
    private PNode head, tail;
    private int size=0;
}