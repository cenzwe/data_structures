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

        if (word.length() == 0 || word.length() == 1){

            return true;
        }

        Character frontDeque = letters.removeFirst();

        Character backDeque = letters.removeFirst();

        Character frontWord = word.charAt(1);

        Character backWord = word.charAt(word.length() - 1);

        if(!cc.equalChars(frontDeque, backWord) || !cc.equalChars(backDeque, frontWord)){

            return false;
        }

        String endsRemoved = word.substring(1, word.length());
        return isPalindrome(endsRemoved, cc);




    }



}
