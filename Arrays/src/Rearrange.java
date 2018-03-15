import java.util.Arrays;

/**
 * Created by amolp on 1/14/18.
 */
public class Rearrange {

    public static int[] rearrangeAlternatePositiveNegative(int [] array) {
        int negativeNos =0;
        for (int i=0; i< array.length; i++) {
            if(array[i]<0) {
                negativeNos++;
            }
        }

        int lastRange=0;
        boolean negativeMore = false;
        if(negativeNos*2<array.length) {
            lastRange = negativeNos*2;
        } else {
            lastRange = (array.length - negativeNos)*2;
            negativeMore = true;
        }

        int negativeIndex=1;
        for(int i=0; i<array.length; i++) {
            if(i%2==0 && array[i]<0 && !negativeMore) {
                while (array[negativeIndex]<0) {
                    negativeIndex+=2;
                }
            }
        }

        return array;
    }


    public static int[] rearrangeAlternate(int [] array) {

        int negativeNos =0;
        for (int i=0; i< array.length; i++) {
            if(array[i]<0) {
                negativeNos++;
            }
        }

        int lastRange=0;
        boolean negativeMore = false;
        if(negativeNos*2<array.length) {
            lastRange = negativeNos*2;
        } else {
            lastRange = (array.length - negativeNos)*2;
            negativeMore = true;
        }

        int negativeIndex=1;
        for(int i=0; i< array.length && negativeIndex < array.length ; i+=2) {
            if(array[i]<0) {
                while(negativeIndex < array.length && array[negativeIndex]<0) {
                    negativeIndex+=2;
                }
                int temp = array[i];
                array[i] = array[negativeIndex];
                array[negativeIndex] = temp;
                negativeIndex+=2;
            }
        }
        int positiveIndex=0;
        for(int i=1; i< array.length && positiveIndex < array.length ; i+=2) {
            boolean positivesAtEnd = false;
            if(array[i]>=0) {
                while(array[positiveIndex]>=0) {
                    positiveIndex+=2;
                    if(positiveIndex >= array.length) {
                        positivesAtEnd = true;
                    }
                }
                int temp = array[i];
                array[i] = array[positiveIndex];
                array[positiveIndex] = temp;
                positiveIndex+=2;
            }
        }
        return array;
    }

    public static int[] rearrangeAlternate2(int [] array) {
        int negativeNos =0;
        for (int i=0; i< array.length; i++) {
            if(array[i]<0) {
                negativeNos++;
            }
        }

        int lastRange=0;
        boolean negativeMore = false;
        if(negativeNos*2<array.length) {
            lastRange = negativeNos*2;
        } else {
            lastRange = (array.length - negativeNos)*2;
            negativeMore = true;
        }

        int negativeIndex = 1;
        for(int i=0; i<array.length; i+=2) {
            boolean shortCircuit = negativeIndex>=array.length;
            if(array[i]<0) {
                if(!shortCircuit) {
                    while(array[negativeIndex] < 0) {
                        negativeIndex+=2;
                        if(negativeIndex>=array.length) {
                            shortCircuit = true;
                            break;
                        }
                    }
                }
                if(negativeIndex>=array.length) {
                    shortCircuit = true;
                }
                if(shortCircuit) {
                    negativeIndex = lastRange;
                }
                int temp = array[negativeIndex];
                array[negativeIndex] = array[i];
                array[i] = temp;
                if(shortCircuit) {
                    negativeIndex++;
                } else {
                    negativeIndex+=2;
                }
            }
        }

        int positiveIndex = 0;
        for(int i=1; i<array.length; i+=2) {
            boolean shortCircuit = positiveIndex>=array.length;
            if(array[i]>=0) {
                if(!shortCircuit) {
                    while(array[positiveIndex] >= 0) {
                        positiveIndex+=2;
                        if(positiveIndex>=array.length) {
                            shortCircuit = true;
                            break;
                        }
                    }
                }
                if(positiveIndex>=array.length) {
                    shortCircuit = true;
                }
                if(shortCircuit) {
                    positiveIndex = lastRange;
                }
                int temp = array[positiveIndex];
                array[positiveIndex] = array[i];
                array[i] = temp;
                if(shortCircuit) {
                    positiveIndex++;
                } else {
                    positiveIndex+=2;
                }
            }
        }

        return array;
    }

    public static int[] rearrangeHalves(int[] array) {
        int positiveIndex = 0;
        for(int i=0; i< array.length ; i++) {
            if(array[i]>=0) {
                int temp = array[positiveIndex];
                array[positiveIndex] = array[i];
                array[i] = temp;
                positiveIndex++;
            }
        }
        return array;
    }

    public static int[] rearrangeAlternate3(int[] array) {
        int positiveIndex = 0;
        for(int i=0; i< array.length ; i++) {
            if(array[i]>=0) {
                int temp = array[positiveIndex];
                array[positiveIndex] = array[i];
                array[i] = temp;
                positiveIndex++;
            }
        }

        int negativeIndex = positiveIndex;
        positiveIndex=0;
        for(; positiveIndex<array.length && negativeIndex < array.length && positiveIndex < negativeIndex && array[positiveIndex]>=0; positiveIndex+=2, negativeIndex++) {
            int temp = array[positiveIndex];
            array[positiveIndex] = array[negativeIndex];
            array[negativeIndex] = temp;
        }
        return array;
    }

    public static void main(String [] args) {
        System.out.print(Arrays.toString(rearrangeAlternate3(new int[]{20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -13, -14, -15, -16, -17, -18, -19, -20})));
    }
}
