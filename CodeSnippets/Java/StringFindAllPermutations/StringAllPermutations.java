package in.shahhardik;

import java.util.HashSet;

public class StringAllPermutations {
    static HashSet<String> stringHashSet = new HashSet<>();

    public static void main(String args[]) {
        permutations("","ABCDE");
        System.out.println(stringHashSet);
    }

    static void permutations(String prefix, String str) {
        int n = str.length();
        if(n == 0) {
            //System.out.println(""+prefix+"|"+str+" ----------"+0+"/"+n);
            stringHashSet.add(prefix);
        }
        for(int i = 0 ; i < n ; i ++) {
            //System.out.println(""+prefix+"|"+str+" ----------"+i+"/"+n+" ["+str.charAt(i)+"]");
            permutations(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
        }
        //System.out.println("******************************");
    }
}
