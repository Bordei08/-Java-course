package lab1.homework;


/**
 * n si p sunt doua numere intregi pozitive, n reprezinta numarul de cuvinte pe care trebuie sa l generam, iar p  lungimea cuvintelor.
 * letters un string unde memorez literele cu care voi forma cuvintele.
 * neighbors un tablou bidimensinoal pentru a retine cuvintele vecine .
 * words un un tablou de string-uri unde voi memora cuvintele generate random
 *
 */


import java.util.Random;

public class homework1 {

    static int n, p;
    static String letters = "";
    static boolean[][] neighbors ;

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        readArgs(args);
        /**
         * metoda readArgs prelucreaza argumentele primite de la consola si totodata verifica daca sunt valide
         */

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = randomWord();
            /**
             * metoda randomWord() returneaza cuvinte random de lungime p formate  cu literele din string-ul letters
             */
            // System.out.println(words[i]);
        }
         neighbors = new boolean[n][n];
        setNeighbors(words);
        /**
         * metoda setNeighbors prelucreaza tabloul bidimensional neighbors astfel :
         * - daca cuvantul i este vecin cu cuvantul j atunci neighbors = true
         * - in caz contrat valoarea ramane aceasi. false
         * Vom parcurge doar elementele de sub diagonala principala deoarece matricea este simetrica.
         */
        if(n >= 30_000) {
            /**
             * pentru n >= 30_000 vom afisa doar timpul de executie al programului
             */
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println(timeElapsed);
        }
        else{
            /**
             * Iar pentru n < 30_000 vom afisa cuvintele generate si vecinii acestora
             */
            System.out.println("Cuvintele generate sunt : ");
            for(int i = 0; i < n; i ++){
                System.out.print(words[i] + " ");
            }
            System.out.println(" ");
            System.out.println("Vecinii : ");
            for(int i = 0; i < n; i ++){
                System.out.print(words[i] + " : ");
                for(int j = 0 ; j < n; j++){
                    if(neighbors[i][j]){
                        System.out.print(words[j] + ", ");
                    }

                }
                System.out.println(" ");
            }
        }
    }

    private static void readArgs(String[] args) {
        n = stringToInt(args[0]);
        p = stringToInt(args[1]);
        int count = args.length, idx = 2;
        while (idx < count) {
            char letter = args[idx].charAt(0);
            if (letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122) letters += args[idx];
            else {
                System.out.println("Acest simbol : " + letter + " nu este o litera");
                System.exit(0);
            }
            idx++;
        }

    }

    /**
     * metoda stringToInt face conversia unui  numar intreg primit ca string intr o variabila int.
     * In cazul in care string-ul primit  nu este un numar intreg  programul se va opri.
     */
    private static int stringToInt(String number) {
        int result = 0;

        try {
            result = Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println("N sau/si P invalid");
            System.exit(0);
        }
        return result;
    }

    private static String randomWord() {
        String result = "";
        Random random = new Random();
        for (int i = 0; i < p; i++) {
            int index = random.nextInt(letters.length());
            result += letters.charAt(index);
        }
        return result;
    }

    private static void setNeighbors(String[] words) {
        boolean isNeighbor;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                isNeighbor = false;
                for(int idxWi = 0; idxWi < p && isNeighbor == false; idxWi ++){
                    char letterWi = words[i].charAt(idxWi);
                    for(int idxWj = 0; idxWj < p && isNeighbor == false; idxWj ++){
                        char letterWj = words[j].charAt(idxWj);
                        if(letterWi == letterWj){
                            isNeighbor = true;
                            neighbors[i][j] =neighbors[j][i] =  true;
                        }
                    }
                }

            }
        }
    }
}
