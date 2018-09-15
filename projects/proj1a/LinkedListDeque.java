public class LinkedListDeque <generic> {

    // variable declarations, size will be cached and sentinel will be circular

    private int size;

    private IntNode sentinel;


    // IntNode nested class

    private class IntNode{

        private IntNode previous;

        private generic item;

        private IntNode next;

        private IntNode(IntNode previous, generic item, IntNode next){

            this.previous = previous;

            this.item = item;

            this.next = next;
        }

    }

    // Constructor creates an empty LinkedListDeque

    public LinkedListDeque(){

        size = 0;

        sentinel = new IntNode(null, null, null);

        sentinel.next = sentinel;

        sentinel.previous = sentinel;

    }

    // adds IntNode to the front of the deque

    public void addFirst(generic item){

        size = size + 1;

        IntNode newLink = new IntNode(sentinel, item, sentinel.next);

        // reassign the pointers
        /*
        assigns the old first.previous to new link
        or if empty list it will be sentinel.previous
         */
        sentinel.next.previous = newLink;

        // newLink is first from sentinel

        sentinel.next = newLink;

    }

    // adds new IntNode to the back of the deque

    public void addLast(generic item){

        size = size + 1;

        IntNode newLink = new IntNode(sentinel.previous, item, sentinel);

        // reassign pointers
        // old last IntNode points to newLink

        sentinel.previous.next = newLink;

        // sentinel points to back of deque with newLink

        sentinel.previous = newLink;

    }

    public boolean isEmpty(){

        return size == 0;

    }

    public int size(){

        return size;
    }

    public void printDeque(){

        IntNode p = sentinel.next;

        System.out.print(p.item);

        for(int i = 1; i < size; i++ ){

            p = p.next;

            System.out.print(" " + p.item);

        }

    }

    public generic removeFirst(){

        size = size - 1;

        generic item = sentinel.next.item;

        // reassign pointers

        sentinel.next.next.previous = sentinel;

        sentinel.next = sentinel.next.next;

        return item;

    }

    public generic removeLast(){

        size = size - 1;

        generic item = sentinel.previous.item;

        // reassign pointers

        sentinel.previous.previous.next = sentinel;

        sentinel.previous = sentinel.previous.previous;

        return item;

    }

    public generic get(int index){

        // could speed up by making a special case for empty deque

        IntNode p = sentinel;

        for(int i = 0; i <= index; i++){

            p = p.next;
        }

        return p.item;
    }

    private generic helperGetRecursive(IntNode p, int index){

        if(index == 0){

            return p.item;
        }

        return helperGetRecursive(p.next, index - 1);


     }

    public generic getRecursive(int index){

        return helperGetRecursive(sentinel.next, index);

    }

}
