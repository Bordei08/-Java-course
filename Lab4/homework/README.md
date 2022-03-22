# Cuprins

 * [Informatii generale](#informatii-generale)
 * [Tehnologii](#Tehnologii)


## Informatii generale

Problema strabaterii unui oras cu n strazi si m intersecti fara sa trecem prin aceasi intersectie de doua ori am redus o la problema generari arborelui de cost minim.

In acest sens am creat doua soluti:

   :star: Solutia care foloseste algoritmul lui Kruskal cu complexitatea [O(M * log2N)].
   
   :star: Solutia care foloseste pachetul JGraphT.
    
Programul este creat folosind [Maven](#maven) si este impartit in 8 clase :    

### Homework
    
   Este clasa principala care contine metoda main. In metoda main doar vom apela alte metode pentru a ajunge la rezultat.
   
   
  ## Street
  
  Clasa Street defineste un obiect street cu propietatile sale specifice.
  
  Un lucru mai interesant folosit aici este faker - ul care genereaza numele random pentru un obiect Street.
  
  ## Intersection
  
  Clasa Intersection defineste un obiect intersection ccu propietatile sale specifice.
  
  ## City
  
  Clasa City defineste un obiect city care are urmatoarele propietati :
   * un nume, nameCity
   * o LinkedList<Street> care va retine strazile orasului, streets
   * un HashSet<Intersection> care va retine intersectile orasului, intersections
  
  Unele lucruri mai interesante la aceasta clasa sunt :
   * constructorul clasei  genereaza intersectile folosind stream-uri
   * lista straziilor este sortata folosind o functie lambda
   * metoda filterStreets care filteaza strazile care au lungimea mai mare deact un numar dat si care sunt adiacente cu cel putin 3 strazi.
  
  ## Edge
   
  Clasa Edge defineste un obiect de tip edge cu toate propietatile sale specifice.
  
  ## Graph
  
  Clasa Graph transforma un obiect de tip City intr-un graf.
  
      Strazile vor deveni muchi
  
      Intersectile vor deveni noduri
  
  ## SolutionKruskal
  
  Clasa solution este clasa care reduce problema data la problemat MST. Am folosit o lista de liste pentru a forma MST- ul
  
  Initial lista va fi initializata cu nodurile grafului deci fiecare nod va avea alocata o lista.Dupa vom parcurge muchile in ordine crescatoare si vom reuni listele nodurilor care reprezinta capetele muchiei, vom repeta acest proces pana cand vom ramane cu o singura lista .
  
  
   Clasa contine 4 metode :
   
   * SolutionKruskal, constructorul clasei
   * aplyKruska, aceasta metoda parcurge muchile in ordine crescatoare si le uneste daca acestea nu am mai fost unite deja
   * find, aceasta functie verifica daca nodurile unei muchi sunt deja intr-un arbore partial
   * union, uneste o muchie la un arbore partial fara a forma un ciclu
    
    
  
## Tehnologii
  * java.util.List;
  * java.util.ArrayList;
  * java.util.*;
  * org.jgrapht.Graph;
  * org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
  * org.jgrapht.graph.DefaultWeightedEdge;
  * org.jgrapht.graph.SimpleWeightedGraph;
  * Maven
