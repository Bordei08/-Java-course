## Cuprins
* [Informatii generale](#informatii-generale)
* [Tehnologie](#tehnologie)


## Informatii generale
Programul este impartit intr-o clasa si 5 metode :
   * [main](#main)
   * [readArgs](#readargs)
   * [stringToInt](#stringtoint)
   * [randomWord](#randomword)
   * [setNeighbors](#setneighbors)

Totodata clasa homework1 contine si 4 variabile globale :
   * [n]() numarul de cuvinte generate
   * [p]() lungimea cuvintelor generate
   * [letters]() un string unde memorez literele cu care voi forma cuvintele
   * [neighbors]() un tablou bidimensional cu valori true / false care va retine vecini unui cuvant

### main
    Metoda main "ansambleaza" toate apelurile de functii pentru a obtine rezultatul dorit.
    
### readArg
    Metoda readArgs prelucreaza argumentele primite de la consola si totodata verifica daca sunt valide.
  
### stringToInt
   Metoda stringToInt face conversia unui  numar intreg primit ca string intr-o variabila int.
   
   In cazul in care string-ul primit  nu este un numar intreg  programul se va opri.
	
### randomWord
    Metoda randomWord returneaza cuvinte random de lungime p formate  cu literele din string-ul letters
    
### setNeighbors
metoda setNeighbors prelucreaza tabloul bidimensional neighbors astfel :


          - daca cuvantul i este vecin cu cuvantul j atunci neighbors = true.


          - in caz contrat valoarea ramane aceasi, false.


 Vom parcurge doar elementele de sub diagonala principala deoarece matricea este simetrica.
   
## Tehnologie
  - java.util.Random

  - System.nanoTime
  
  
