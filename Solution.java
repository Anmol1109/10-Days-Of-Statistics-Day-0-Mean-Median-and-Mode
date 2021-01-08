import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {
    static int[] array;
    static double mean(){
        int sum = 0;
        
        for(int i : array){
            sum += i;
        }
        return (double)sum / array.length;
    }
    static double median(){
        int halfN = array.length / 2;
        if((array.length & 1) == 1)
            return array[halfN];
        return (array[halfN] + array[halfN - 1]) / 2.0;
    }
    static int mode(){
        HashMap<Integer, Integer> occurances = new LinkedHashMap<Integer, Integer>();
        for(int i = 1;i <= array.length;i++){
            int current = array[i - 1];
            int count = 1;
            for(int j = i;j < array.length;j++){
                if(current == array[j])
                    count++;
            }
            if(occurances.get(count) == null)
                occurances.put(count,current);
            }
            return occurances.get(Collections.max(occurances.keySet(),null));
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        array = new int[scan.nextInt()];
        for(int i = 0;i < array.length;i++)
            array[i] = scan.nextInt();
        Arrays.sort(array);
        
        System.out.println(mean());
        System.out.println(median());
        System.out.println(mode());
    }
}
