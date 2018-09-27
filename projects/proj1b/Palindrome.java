public class Palindrome {

    public Deque<Character> wordToDeque(String word){

        Deque<Character> letters = new LinkedListDeque<>();

        for(int i = 0; i< word.length(); i++){

            letters.addLast(word.charAt(i));
        }

        return letters;
    }

    public boolean isPalindrome(String word){

        Deque<Character> letters = wordToDeque(word);

        for(int i = 0; i<letters.size(); i++){

            Character c = letters.removeLast();

            if(word.charAt(i) != c){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){

        Deque<Character> letters = wordToDeque(word);

        while(letters.size() > 1){

            Character front = letters.removeFirst();

            Character back  = letters.removeLast();
            if(cc.equalChars(front, back) != true){
                return false;
            }
        }
        return true;

    }



}
