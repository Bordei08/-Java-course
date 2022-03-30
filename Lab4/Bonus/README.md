# Cuprins

 * [Informatiii generale](#informatii-generale)
 * [Tehnologii](#Tehnologii)


## Informatii generale

Algoritmul propus se bazeaza pe o parcurgere a MST-ului generat de Algoritmul lui Kruskal (solutia optima pentru aceasta problema era generata de problema TSP).

Programul  foloseste Maven si este impartit in 8 clase (Din cele 8 clase doar 2 clase sunt diferite fata de cele din Homework ) :

### Bonus
   Clasa principala unde avem si functia main.
   
### Street

  Defineste un obiect de tip strada
  
### Intersection

   Defineste un obiect de tip intersectie
   
### City

 Clasa City defineste un obiect de tip city, aceasta clasa implementeaza doi constructori :
     
     City(String name) care primeste un nume si construieste un oras baza pe graful din cerinta problemei.
     
     City(Integer ccountIntersections , Integer countStreets) primeste doua numere ce reprezinta numarul de intersectii si de strazi care vor fi generate random .
     
     
 Chiar daca generare eeste una random , in cazul celui de al doilea constructor, instanta generata respecta urmatoarele reguli :
 
   * Orasul trebuie sa fie un graf conexm deci trebuie sa putem sa ajungem din orice intersectie in oricare alta.
   * Daca 3 intersecti formeaza un ciclu de lungime 3 atunci muchiile ciclului trebuie sa respecte conditia de triunghi.

### Graph

Aceasta clasa "reduce" un obiect de tip City la unul de tip Graph pentru a usura aplicarea algoritmilor.

### Edge
 
 Defineste un obiect de tip Edge cu toate propietatile sale. (sau "reduce" un obiect de tip Street la unul de tip Edge).
 
 ### SolutionKruskal
 
 Este fix clasa din Homework dar care implementeaza un getter pentru MST-ul creat.
 
 ### SolutionTSP
 
 Aceasta clasa primeste MST-ul grafului care reprezinta city-ul nostru si face o parcurgere pentru a afla drumul minim.
 
 
 # Tehnologii
* java.util.List;
  * java.util.ArrayList;
  * java.util.*;
  * org.jgrapht.Graph;
  * org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
  * org.jgrapht.graph.DefaultWeightedEdge;
  * org.jgrapht.graph.SimpleWeightedGraph;
  * Maven

