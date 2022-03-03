# Cuprins
* [Informatii generale](#informatii-generale)
* [Tehnologii](#tehnologii)

## Informatii generale
Algoritmul descris este impartit intr-o singura clasa cu 9 metode :
* [main](#main)
* [readArgs](#readargs)
* [stringToInt](#stringtoint)
* [randomWords](#randomwords)
* [isNeighbor](#isneighbor)
* [possibleSubsetWords](#possiblesubsetwords)
* [createSubset](#createsubset)
* [maxSubsetFrom](#maxsubsetfrom)
* [isSubset](#issubset)

si contine 8 variabile globale :

* countWords, retine numarul de cuvinte. 
* lengthWords, retine lungimea cuvintelor.
* letters[], retine intr-un string alfabetul cuvintelor.
* words[], un vector de string care retine cuvintele generate random.
* visitedWords[], tine evidenta nodurilor vizitate si a nodurilor care nu pot forma un subset

 visitedWords[i] = 0, daca cuvantul i nu a fost folosit in formarea subset-ul maxim.
 
 visitedWords[i] = -1, cuvantul i are mai putin de 2 vecini, deci nu poate face parte din subset-ul maxim.
 
 visitedWords[i] = 1, cuvantul i face parte din subset-ul maxim.
 
 * subset, retine subset-ul maxim intr-un ArrayList de string-uri.
 * subsetDFS, este un ArrayList de string-uri folosit pentru aflarea subsetului maxim, acesta memoreaza temporar subset-ul generat de parcurgerea DFS  a fiecarui cuvant nevizitat.
  
  ### main
     Metoda principala unde se apeleaza restul metodelor pentru obtinerea subsetului maxim.
     
  ### readArgs
     Metoda care se ocupa cu verificarea si citirea inputului.
     
  ### stringToInt
     Metoda care se ocupa cu conversia unui string in integer, daca este posibil.
     
  ###   randomWords
  
      Metoda care se ocupa cu generarea de cuvinte random .
      
  ### isNeighbor
      Metoda care verifica daca doua cuvinte sunt vecine.
      
   ### possibleSubsetWords
     Metoda care "elimina" cuvintele care au mai putin de 2 vecini.
    
  ### createSubset
    Metoda care compara fiecare subset pana il gaseste pe cel maxim.
    
 ### maxSubsetFrom
    Metoda care genereaza un subset incepand cu cuvantul i, dat ca parametru. Aceasta metoda are la baza un algoritm  DFS.
    
 ### isSubset
   Metoda care verifica daca un ArrayList de string-uri este un subset.
   
  ## Tehnologii
  
  * java.util.ArrayList
  * java.util.Random
      
    
 
 

