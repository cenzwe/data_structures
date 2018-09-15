public class ArrayDeque <generic> {

    // variable declarations

    // front will be next box in front of actual front item and vice versa for back

    private int nextFront;

    private int nextBack;

    private int size;

    private generic[] items;


    // empty constructor

    public ArrayDeque(){

        nextFront = 4;

        nextBack = 5;

        size = 0;

        items = (generic[]) new Object[8];

    }

    public int length(){

        return items.length;
    }


    public int forward(int i){

        return Math.floorMod(i - 1, items.length);

    }

    public int backward(int i){

        return  Math.floorMod(i + 1, items.length);
    }


    public void addFirst(generic thing){

        size = size +1;

        items[nextFront] = thing;

        nextFront = forward(nextFront);

        if(size == items.length){

            this.resizeIncrease();

        }

    }

    public void addLast(generic thing){

        size = size + 1;

        items[nextBack] = thing;

        nextBack = backward(nextBack);

        if(size == items.length){

            this.resizeIncrease();

        }
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public int size(){

        return size;
    }

    public void printDeque(){

        // iterate from front to back

        int front = backward(nextFront);

        for(int i = 1; i <= size; i++){

            System.out.print(items[front] + " ");

            front = backward(front);
        }

    }

    public generic removeFirst(){

        size = size - 1;

        nextFront = backward(nextFront);

        generic pop = items[nextFront];

        items[nextFront] = null;

        if(size == items.length/4 && items.length > 8){

            this.resizeDecrease();
        }

        return pop;

    }

    public generic removeLast(){

        size = size - 1;

        nextBack = forward(nextBack);

        generic pop = items[nextBack];

        items[nextBack] = null;

        if(size == items.length/4 && items.length > 8){

            this.resizeDecrease();
        }

        return pop;

    }

    public generic get(int index){

        int correctedIndex = Math.floorMod(index + backward(nextFront), items.length);

        return items[correctedIndex];

    }

    private void resizeIncrease(){

        int front = backward(nextFront);

        int back = forward(nextBack);

        int frontToEnd = items.length - front;

        int startToBack = items.length - frontToEnd;

        generic[] newArray = (generic[]) new Object[items.length * 2];

        System.arraycopy(items, front, newArray, items.length, frontToEnd);

        System.arraycopy(items, 0, newArray, items.length + frontToEnd, startToBack);

        nextFront = forward(items.length);

        nextBack = 0;

        items = newArray;

    }

    private void resizeDecrease(){

        int front = backward(nextFront);

        int back = forward(nextBack);

        generic[] newArray = (generic[]) new Object[items.length / 2];

        int frontToEnd = items.length - front;

        if(frontToEnd >= items.length/4) {

            System.arraycopy(items, front, newArray, items.length / 4, items.length / 4);


        } else {

            System.arraycopy(items, front, newArray, items.length/4, frontToEnd);

            System.arraycopy(items, 0, newArray, front + frontToEnd,items.length/4 - frontToEnd);

        }

        nextFront = forward(items.length/4);

        nextBack = 0;

        items = newArray;

    }


    public static void main(String[] args){

        ArrayDeque<Integer> j = new ArrayDeque<>();

        j.addFirst(1);

        j.addFirst(2);

        j.addLast(3);

        j.addFirst(4);

        j.addFirst(5);

        j.addLast(6);

        j.addLast(7);

        j.addFirst(8);

        j.addFirst(9);

        System.out.print(j.length());




    }








}
