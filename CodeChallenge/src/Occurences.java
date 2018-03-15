import java.util.*;

/**
 * Created by amolp on 2/23/18.
 */
public class Occurences {

    public static void printOccurences(String input) {
        if(input==null || input.isEmpty()) {
            return;
        }
        input = input.replaceAll("[^a-zA-Z]", "").toUpperCase();
        Map<Character, Integer> occurence = new HashMap<>();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            int count=0;
            if(occurence.containsKey(c)) {
                count = occurence.get(c);
            }
            count++;
            occurence.put(c, count);
        }

        while(!occurence.isEmpty()) {
            int maxOccurenceCount = Integer.MIN_VALUE;
            List<Character> allCharsWithMaxOccuerence = new ArrayList<>();
            for (Character c : occurence.keySet()) {
                int count = occurence.get(c);
                if (count > maxOccurenceCount) {
                    maxOccurenceCount = count;
                }
            }
            for (Character c : occurence.keySet()) {
                if (occurence.get(c) == maxOccurenceCount) {
                    allCharsWithMaxOccuerence.add(c);
                }
            }
            Collections.sort(allCharsWithMaxOccuerence);
            for (Character c : allCharsWithMaxOccuerence) {
                System.out.println(c + " : " + maxOccurenceCount);
                occurence.remove(c);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        printOccurences(input);
        //Please uncomment below line to run the custom test cases;
        //testCases();
    }

    public static void testCases() {
        String nullString = null;
        printOccurences(nullString);

        String emptyString = "";
        printOccurences(emptyString);

        System.out.println();
        String alphanumericString = "@# $";
        printOccurences(alphanumericString);

        System.out.println();
        String mixedString = "@#$amol";
        printOccurences(mixedString);

        System.out.println();
        String randomlyMixedString = "a@m#$o l";
        printOccurences(randomlyMixedString);

        System.out.println();
        String nonAlphanumericString = "amol";
        printOccurences(nonAlphanumericString);

        System.out.println();
        String nonAlphanumericStringWithRepeatingChar = "ammol";
        printOccurences(nonAlphanumericStringWithRepeatingChar);

        System.out.println();
        String nonAlphanumericStringWithMultipleRepeatingChar = "aammol";
        printOccurences(nonAlphanumericStringWithMultipleRepeatingChar);

        System.out.println();
        String singleCharRepeating = "aaa";
        printOccurences(singleCharRepeating);

        System.out.println();
        String threeUniqueOccurenceCount = "ammoool";
        printOccurences(threeUniqueOccurenceCount);
    }
}
