

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by EgaMen on 07.10.2017.
 */
public class myLinkedList<E> implements List {
     Node<E> first;
     Node<E> last;
    private int size=0;

    public myLinkedList(){

    }

    public myLinkedList(myLinkedList<E> list){
        Object[]listArray=list.toArray();
        for(int x=0; x<list.size(); x++)
        {
            addLast((E)listArray[x]);
        }

    }
    public void addFirst(E e) {
        Node<E> f=first;
        Node<E> newNode = new Node<>(first, e);
        first = newNode;
        if(f==null)
            last = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> l=last;
        Node<E> newNode = new Node<>(null, e);
        last=newNode;
        if(l==null) {
            first=newNode;
        }
        else {
            l.next=newNode;
        }
        size++;

    }

    public void removeFirst() {
        if(size==0)
            throw new RuntimeException();
        Node<E> next = first.next;
        first.item=null;
        first.next=null;
        if(next ==null)
            last=null;
        first=next;
        size--;
    }
    private void unlink(Node<E> x, Node<E> prev)
    {
        if (prev == null)
            first = x.next;
        else
            prev.next = x.next;
        if (x.next == null)
            last = prev;
        else
            x.next = null;
        x.item = null;
        size--;
        //prev = x;
    }
    public void removeAll(){
        if(size==0)
            throw new RuntimeException();
        Node<E> x=first;
        while( x!=null)
        {
            Node<E> elem = x;
            x=x.next;
            elem.item=null;
            elem.next=null;
            size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] myArray = new Object[size];
        int y=0;
        for(Node<E> x = first; x!=null; x=x.next)
        {
            myArray[y]=x.item;
            y++;
        }
        return myArray;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o==null){
            Node<E> prev= null;
            for(Node<E> x = first; x!=null; x=x.next) {
                if (x.item==null) {
                    unlink(x,prev);
                    return true;
                }
            }
        }
        else
        {
            Node<E> prev=null;
            for(Node<E> x=first; x!=null; x=x.next) {
                if(o.equals(x.item))
                {
                    unlink(x,prev);
                    return true;
                }
                prev=x;

            }
        }
        throw new IllegalArgumentException();

    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        String result = "";
        if (size>0) {
            for (Node<E> x = first; x != null; x = x.next) {
                result += x.getItem().toString();
            }
        }
        return result;
    }

    private static class Node<T> {
        Node next;
        T item;

        Node(){
            this.next=null;
        }

        Node(Node<T> next, T element){
            this.next=next;
            this.item = element;

        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        T getItem() {
            return item;
        }

        void setItem(T item) {
            this.item = item;
        }
    }
}
