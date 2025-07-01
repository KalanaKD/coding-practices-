import java.util.HashSet;
import java.util.Set;

public class Main {
    public int possibleStringCount(String word) {
        Set<String> possibleOriginals = new HashSet<>();
        possibleOriginals.add(word);

        for (int i=0; i< word.length();){
            int j = i + 1 ;
            while(j<word.length() && word.charAt(j) == word.charAt(i)){
                j++;
            }
            int len = j - i ;
            if( len > 1){
                for (int removeCount = 1; removeCount < len; removeCount++){
                    String shortend = word.substring(0,i) + word.substring(i,j - removeCount) +
                            word.substring(j);
                    possibleOriginals.add(shortend);
                }
            }
            i= j;
        }
        return possibleOriginals.size();
    }


    public static void main(String[] args) {
        Main methodCall = new Main();
        int result = methodCall.possibleStringCount("wooorddiiiee");
        System.out.println("result : " + result);
    }
}