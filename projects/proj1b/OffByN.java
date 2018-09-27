public class OffByN implements CharacterComparator {

    public int n;

    public OffByN(int x){
        n = x;
    }

    @Override
    public boolean equalChars(char x, char y){

        if(this.n == Math.abs(x - y)){
            return true;
        }

        return false;
    }
}
