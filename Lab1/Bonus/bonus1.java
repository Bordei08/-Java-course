package lab1.bonus;

import java.util.ArrayList;
import java.util.Random;

public class bonus1 {

    static int countWords, lengthWords;
    static String letters = "";
    static boolean[][] neighbors;
    static int[] visitedWords;
    static ArrayList<String> subset = new ArrayList<>();
    static String[] words;
    static ArrayList<String> subsetDFS = new ArrayList<>();

    public static void main(String[] args) {

        readArgs(args);

        words = new String[countWords];

        for (int i = 0; i < countWords; i++) {
            words[i] = randomWord();
        }

        neighbors = new boolean[countWords][countWords];

        for (int i = 1; i < countWords; i++) {
            for (int j = 0; j < i; j++) {
                if (isNeighbor(words[i], words[j])) {
                    neighbors[i][j] = neighbors[j][i] = true;
                }
            }
        }

        visitedWords = new int[countWords];
        int subsetLength = countWords;

        possibleSubsetWords();

        createSubset();

        System.out.println(subset.size());
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }

    }

    private static void readArgs(String[] args) {
        countWords = stringToInt(args[0]);
        lengthWords = stringToInt(args[1]);
        int count = args.length, idx = 2;
        while (idx < count) {
            char letter = args[idx].charAt(0);
            if (letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122)
                letters += args[idx];
            else {
                System.out.println("Acest simbol : " + letter + " nu este o litera");
                System.exit(0);
            }
            idx++;
        }

    }

    private static int stringToInt(String number) {
        int result = 0;

        try {
            result = Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println("numar invalid");
            System.exit(0);
        }
        return result;
    }

    private static String randomWord() {
        String result = "";
        Random random = new Random();
        for (int i = 0; i < lengthWords; i++) {
            int index = random.nextInt(letters.length());
            result += letters.charAt(index);
        }
        return result;
    }

    private static boolean isNeighbor(String word1, String word2) {
        for (int i = 0; i < lengthWords; i++) {
            char letterWi = word1.charAt(i);
            for (int j = 0; j < lengthWords; j++) {
                char letterWj = word2.charAt(j);
                if (letterWi == letterWj) {
                    return true;
                }
            }

        }
        return false;
    }

    private static void possibleSubsetWords() {
        int countNeighbors;
        for (int i = 0; i < countWords; i++) {
            countNeighbors = 0;
            for (int j = 0; j < countWords; j++) {
                if (neighbors[i][j])
                    countNeighbors++;
            }
            if (countNeighbors < 2) {
                visitedWords[i] = -1;
            } else {
                visitedWords[i] = 0;

            }
        }

    }

    private static void createSubset() {
        int maxSubsetLength = 0;

        for (int i = 0; i < countWords; i++) {
            if (visitedWords[i] == 0) {
                maxSubsetFrom(i);
                if (subsetDFS.size() > maxSubsetLength) {
                    maxSubsetLength = subsetDFS.size();
                    subset.removeAll(subset);

                    subset = (ArrayList<String>) subsetDFS.clone();
                    boolean flag = false;

                    if(!isSubset(subset)) {
                        maxSubsetLength = 0;
                        subset.removeAll(subset);
                    }
                }
                subsetDFS.removeAll(subsetDFS);
                for (int j = 0; j < countWords; j ++) {
                    if (visitedWords[j] == 1) {
                        visitedWords[j] = 0;

                    }
                }

            }


        }
    }

    private static void maxSubsetFrom(int index) {

        visitedWords[index] = 1;
        subsetDFS.add(words[index]);
        for (int i = 0; i < countWords; i++) {
            if (visitedWords[i] == 0 && neighbors[index][i]) {
                maxSubsetFrom(i);
            }
        }

    }

    private static boolean isSubset(ArrayList<String> possibleSubset){
        
        for(int j = 0; j < subset.size() - 1;j ++){
            if(!isNeighbor(subset.get(j), subset.get(j + 1))){
                return false;
            }
        }
        if(!isNeighbor(subset.get(0), subset.get(subset.size() - 1))){
            return false;
        }
        return true;
    }

}




