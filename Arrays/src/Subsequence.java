import java.util.ArrayList;
import java.util.List;

/**
 * Created by amolp on 1/18/18.
 */
public class Subsequence {

    public static List<String> subsequence(String a) {
        List<String> ss = new ArrayList<>();
        for(int i=0; i< a.length(); i++) {
            List<String> iss = new ArrayList<>();
            for(String s : ss) {
                iss.add(s + a.charAt(i));
            }
            ss.add(String.valueOf(a.charAt(i)));
            ss.addAll(iss);
        }
        return ss;
    }

    public static void main(String[] args) {
        String a = "amola";
        List<String> ss = subsequence(a);
        System.out.println("Subsequence of " + a + " size is " + ss.size());
        for(String s : ss) {
            System.out.println(s);
        }
    }
}
