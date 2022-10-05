package com.yk.algorithm.main.hot100;

import sun.nio.cs.ext.MacHebrew;

/**
 * @author al864
 */
public class Question5 {
    public String longestPalindrome1(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        char [] ch = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(j - i + 1 > maxLen && isPalindrome(ch,i,j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private boolean isPalindrome(char [] ch, int i, int j){
        while(i < j){
            if(ch[i] != ch[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char [] ch = s.toCharArray();
        boolean dp [][] = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int j = 1; j< len;j++){
            for(int i = 0; i < j; i++){
                if(ch[i] != ch[j]){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = j - i + 1 <= 3 || dp[i+1][j-1];
                }
                if(dp[i][i] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public String longestPalindrome3(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char [] ch = s.toCharArray();
        for(int i =1; i<len-1;i++){
            int len1 = getPalindromeCenterLen(ch,len,i,i);
            int len2 = getPalindromeCenterLen(ch,len,i,i+1);
            len1 = Math.max(len1,len2);
            if(len1 > maxLen){
                maxLen = len1;
                begin = i - (maxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private int getPalindromeCenterLen(char[] ch ,int len,int left, int right){
        int i = left;
        int j = right;
        while(i > 0 && j < len){
            if(ch[i] == ch[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        return j-i-1;
    }



    public static void main(String[] args) {
        String s=  "abcba";
        String s1 = new Question5().longestPalindrome2(s);
        System.out.println(s1);
    }

}
