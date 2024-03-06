import java.util.Arrays;

public class App {

    public static int[] sortList(int[] list, int pointer){
        int[] sortedlist = new int[pointer];
        for(int x = 0; x<pointer; x++){
            sortedlist[x] = list[x];
        }
        return sortedlist;
    }

    public static int[] findFactors(int x){

        int[] factorUnsorted = new int[x];
        int pointer = 0;

        for(int counter = 2; counter<x; counter++){
            if(x%counter == 0){
                factorUnsorted[pointer] = counter;
                pointer++;
            }
        }

        int[] factorsorted = sortList(factorUnsorted, pointer);
        return factorsorted;

    }

    public static int[] findPrimeList(int[] sortedlist){
        int[] primeUnsorted = new int[sortedlist.length];
        int pointer = 0;
        for(int x = 0; x < sortedlist.length; x++){
            int[] checklist = findFactors(sortedlist[x]);
            if(checklist.length < 2){
                primeUnsorted[pointer] = sortedlist[x];
                pointer++;
            }
        }
        int[] primeSorted = sortList(primeUnsorted, pointer);
        return primeSorted;
    }

    public static int[] findPrimeFactors(int x){
        int[] factors = findFactors(x);
        int[] primefactors = findPrimeList(factors);
        return primefactors;
    }

    public static void main(String[] args) throws Exception {
        int x = 60;
        int[] primefactors = findPrimeFactors(30);
        System.out.println(Arrays.toString(primefactors));
    }
}
