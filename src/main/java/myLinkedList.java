

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class myLinkedList<E> implements List {
     Knot<E> theFirst;
     Knot<E> theLast;
    private int listSize =0;

    public myLinkedList(){

    }

    public myLinkedList(myLinkedList<E> list){
        Object[]listToObject=list.toArray();
        for(int x=0; x<list.size(); x++)
        {
            addLast((E)listToObject[x]);
        }

    }
    public void addLast(E e) {
        Knot<E> l= theLast;
        Knot<E> newKnot = new Knot<>(null, e);
        theLast = newKnot;
        if(l==null) {
            theFirst = newKnot;
        }
        else {
            l.next= newKnot;
        }
        listSize++;

    }
    public void removeFirst() {
        if(listSize ==0)
            throw new RuntimeException();
        Knot<E> next = theFirst.next;
        theFirst.item=null;
        theFirst.next=null;
        if(next ==null)
            theLast =null;
        theFirst =next;
        listSize--;
    }
    public void addFirst(E e) {
        Knot<E> f= theFirst;
        Knot<E> newKnot = new Knot<>(theFirst, e);
        theFirst = newKnot;
        if(f==null)
            theLast = newKnot;
        listSize++;
    }




    private void unlink(Knot<E> x, Knot<E> previous)
    {
        if (previous == null)
            theFirst = x.next;
        else
            previous.next = x.next;
        if (x.next == null)
            theLast = previous;
        else
            x.next = null;
        x.item = null;
        listSize--;
        //previous = x;
    }
    public void removeAll(){
        if(listSize ==0)
            throw new RuntimeException();
        Knot<E> x= theFirst;
        while( x!=null)
        {
            Knot<E> elem = x;
            x=x.next;
            elem.item=null;
            elem.next=null;
            listSize--;
        }
    }


    public int size() {
        return this.listSize;
    }


    public boolean isEmpty() {
        return size()==0;
    }


    public boolean contains(Object o) {
        return false;
    }


    public Iterator iterator() {
        return null;
    }


    public Object[] toArray() {
        Object[] myArray = new Object[listSize];
        int y=0;
        for(Knot<E> x = theFirst; x!=null; x=x.next)
        {
            myArray[y]=x.item;
            y++;
        }
        return myArray;
    }


    public boolean add(Object o) {
        return false;
    }


    public boolean remove(Object o) {
        if(o==null){
            Knot<E> previous= null;
            for(Knot<E> x = theFirst; x!=null; x=x.next) {
                if (x.item==null) {
                    unlink(x,previous);
                    return true;
                }
            }
        }
        else
        {
            Knot<E> prev=null;
            for(Knot<E> x = theFirst; x!=null; x=x.next) {
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
        if (listSize >0) {
            for (Knot<E> x = theFirst; x != null; x = x.next) {
                result += x.getItem().toString();
            }
        }
        return result;
    }

    private static class Knot<T> {
        Knot next;
        T item;

        Knot(){
            this.next=null;
        }

        Knot(Knot<T> next, T element){
            this.next=next;
            this.item = element;

        }

        Knot getNext() {
            return next;
        }

        void setNext(Knot next) {
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
