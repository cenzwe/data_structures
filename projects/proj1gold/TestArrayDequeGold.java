import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void autograde(){

        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        String message = "";

        for(int i = 0; i<50; i++){

            Integer x = StdRandom.uniform(4);
            Integer y = StdRandom.uniform(100);

            if(x == 0){

                student.addFirst(y);
                solution.addFirst(y);

                message = message + "addFirst()/n";


                assertEquals(message, solution.get(0), student.get(0));
                assertEquals(message, solution.size(), student.size());


            }else if(x == 1){

                student.addLast(y);
                solution.addLast(y);

                message = message + "addLast()/n";

                assertEquals(message, solution.get(solution.size()-1), student.get(student.size()-1));
                assertEquals(message, solution.size(), student.size());

            }else if(x == 2){

                Integer p = student.removeLast();
                Integer l = solution.removeLast();

                message = message + "removeLast()/n";

                assertEquals(message, l, p);
                assertEquals(message, solution.size(), student.size());

            }else{

                Integer k = solution.removeFirst();
                Integer w = student.removeFirst();

                message = message + "removeFirst/n";

                assertEquals(message, k, w);
                assertEquals(message, solution.size(), student.size());
            }


        }




    }




}
