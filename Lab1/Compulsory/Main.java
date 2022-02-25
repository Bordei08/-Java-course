package com.company;

/** Functia helloWorld afiseaza  mesajul Hello world.
 * Functia intRandom returneaza o valoare intreaga pozitiva mai mica ca 1_000_000.
 * Functia convertToDecimal este o functie cu doi parametri:
 *    - number, care este primit ca un string si reprezinta numarul ce va fi dus in baza 10.
 *    - base, un numar intreg pozitiv ce reprezinta baza in care este numarul primit ca prim argument.
 *    Asa cum reiese din numele  functiei, acesta returneaza numarul primit ca paramentru in baza 10.Functia convertToDecimal realizeaza conversia cu ajutorul metodei Integer.parseInt()
 */


public class Main {

    public static void main(String[] args) {

       helloWorld();

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = intRandom();
        int result = n * 3;

        result += convertToDecimal("10101",2);
        result += convertToDecimal("FF", 16);

        result *= 6;
        result %= 9;

        if (result == 0)
            result = 9;

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);


    }
      private static void helloWorld(){
          System.out.println("Hello world");
      }

      private static int intRandom(){
        return (int) (Math.random() * 1_000_000);
      }

      private static int convertToDecimal(String number, int base){
        return Integer.parseInt(number, base);
      }
}
