package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :12:00:21 pm
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

//Program to Count Vowels in a String - a e i o u
public class CountVowels {

 public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);

     System.out.println("Enter a Sentence : ");
     String s = scanner.nextLine();
     String s2 = s.toLowerCase();
     scanner.close();

     int count = 0;
     System.out.println("The Length of the String is : " + s2.length());

     for (int i = 0; i < s2.length(); i++) {
         // Check if the current character is a vowel
         if (s2.charAt(i) == 'a' || s2.charAt(i) == 'e' || s2.charAt(i) == 'i' || s2.charAt(i) == 'o' || s2.charAt(i) == 'u') {
             count = count + 1;
         }
     }

     System.out.println("Total number of vowels: " + count);
 }
}
