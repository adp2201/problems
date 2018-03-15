import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingElements {

    public static final int RANGE = 100;

    public void findMissingElements(int[] input) {
        int length = input.length;
        if(length==0) {
            System.out.print("["+1+","+RANGE+"]");
            return;
        }
        int index=0;
        for(int i=1; i<=RANGE; i++) {
            if(index>=length) {
                if(input[index-1]==RANGE-1) {
                    System.out.print(RANGE);
                } else {
                    System.out.print("[" + (input[index-1]+1) + "," + RANGE + "]");
                }
                break;
            }
            if(input[index]!=i) {
                if(input[index]==i+1) {
                    System.out.print(i + (i==RANGE ? "" : ","));
                    i++;
                } else {
                    System.out.print("[" + i + "," + (input[index]-1) + "]" + (input[index]-1==RANGE ? "" : ","));
                    i=input[index];
                }
            }
            index++;
        }
    }


    public static void main(String[] args) {
        MissingElements a = new MissingElements();
        a.testCases();

    }

    public void testCases() {
        int[] emptyArray = {};
        findMissingElements(emptyArray);
        System.out.println();
        int[] onlyFirstElement = {1};
        findMissingElements(onlyFirstElement);
        System.out.println();
        int[] onlyRandomElement = {40};
        findMissingElements(onlyRandomElement);
        System.out.println();
        int[] onlyLastElement = {100};
        findMissingElements(onlyLastElement);
        System.out.println();
        int[] missingFirstElement = new int[99];
        for(int i=2 ; i<=100; i++) {
            missingFirstElement[i-2]=i;
        }
        System.out.println();
        findMissingElements(missingFirstElement);

        int[] missingLastElement = new int[99];
        for(int i=1 ; i<=99; i++) {
            missingLastElement[i-1]=i;
        }
        System.out.println();
        findMissingElements(missingLastElement);

        int[] multipleSingleElementMissing = new int[98];
        for(int i=1 ; i<=39; i++) {
            multipleSingleElementMissing[i-1]=i;
        }
        for(int i=41 ; i<=69; i++) {
            multipleSingleElementMissing[i-2]=i;
        }
        for(int i=71 ; i<=100; i++) {
            multipleSingleElementMissing[i-3]=i;
        }
        System.out.println();
        findMissingElements(multipleSingleElementMissing);

        int[] beginningRangeMissing = new int[91];
        for(int i=10 ; i<=100; i++) {
            beginningRangeMissing[i-10]=i;
        }
        System.out.println();
        findMissingElements(beginningRangeMissing);

        int[] lastRangeMissing = new int[91];
        for(int i=1 ; i<=91; i++) {
            lastRangeMissing[i-1]=i;
        }
        System.out.println();
        findMissingElements(lastRangeMissing);
    }

}
