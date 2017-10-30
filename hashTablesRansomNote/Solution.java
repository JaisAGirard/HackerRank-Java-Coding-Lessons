package hashTablesRansomNote;

import java.util.*;

/*Lesson: A kidnapper wrote a ransom note but is worried it will be traced back to him. 
He found a magazine and wants to know if he can cut out whole words from it and use them 
to create an untraceable replica of his ransom note. The words in his note are case-sensitive 
and he must use whole words available in the magazine, meaning he cannot use substrings or 
concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate
his ransom note exactly using whole words from the magazine; otherwise, print No.

Source: https://www.hackerrank.com/challenges/ctci-ransom-note/problem*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        System.out.println(replicate(magazine, ransom));
        in.close();
    }
    
    public static String replicate(String[] magazine, String[] ransom) {
        Map<String, Integer> feqMagazine = new HashMap<String, Integer>();
        Map<String, Integer> feqRansom = new HashMap<String, Integer>();

        for (String word : magazine){
            Integer f = feqMagazine.get(word);
            if(f==null) 
                f=0;
            feqMagazine.put(word,f+1);
        }

        for (String word : ransom){
            Integer f = feqRansom.get(word);
            if(f==null) 
                f=0;
            feqRansom.put(word,f+1);
        }

        for(String word : feqRansom.keySet()) {
            if(!feqMagazine.containsKey(word)) {
                return "No";
            }
            else if (feqMagazine.get(word) < feqRansom.get(word)) {
                return "No";
            }
        }
        return "Yes";
    }
}