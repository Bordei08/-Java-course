# Cuprins
  * [Informatii generale](#informatii-generale)
  * [Tehnologii](#tehnologii)

## Informatii generale
Algoritmul propus va memora toate match-urile dintre camere si evenimente ( match = capacitatea camerei este egala cu size-ul evenimentului ) apoi pentru fiecare eveniment va aloca o camera potrivita, dupa fiecare alocare vom evita cazul de suprapunere eliminand match-ul dintre un alt eveniment de la aceasi ora si camera ocupata.


Programul este impartit in 6 clase :
   * [homework2](#homework2)
   * [room](#room)
   * [event](#event)
   * [computerLab](#computerlab)
   * [lectureHall](#lecturehall)
   * [solution](#solution)


# homework2

     
 Este clasa principala unde in metoda main se declara listele de evenimente si de camere, apoi prin diferite apeluri de metode se obtine rezultatul dorit

  Clasa homework2 are 4 metode :
  * [main](#main)
        
    In aceasta metoda doar declaram lsitele events si room, un obiect solution pentru a utiliza metodele clasei cu acelasi nume si apelam diferite metode pentru obtinerea rezultatului.
  

  * [creatEventsAndRooms](#creatEventsAndRooms)

  In aceasta metoda alocam cate 5 obiecte pentru fiecare lista.

  * [checkEvents](#checkevents)

  In aceasta metoda verificam elementele din events, trebuie sa avem evenimente distincte.

  * [checkRooms](#checkrooms)

 In aceasta metoda verificam elementele din rooms, trebuie sa avem camere distincte (cu nume diferit ).

# room

 Este o clasa abstracta care contine metode si date membru care reprezinta propietatile unei camere.

# event

Aceasta clasa contine propietatile unui eveniment.

# computerLab

ComputerLab este o clasa extinsa din clasa room, deci are toate propietatile unei camere.

# lectureHall

LectureHall este o clasa extinsa din clasa room, deci are toate propietatile unei camere.

# solution

Aceasta metoda cuprinde algoritmul care ne asigura ca vom putea creea un orar fara suprapuneri.

Aceasta clasa detine in componenta sa un tablou bidimensional [timeTable](#timetable) si 4 metode:

* [timeTable](#timetable)

Un tablou bidimensional de tip boolean cu propietatile descrise la [imeTabelInitialization](#imeTabelInitialization).

 * [solving](#solving)

Aceasta metoda va coordona pasi de rezolvare a problemei prin apelare celorlalte metode din clasa solution.

 * [imeTabelInitialization](#imeTabelInitialization)

Aceasta metoda formeaza timeTable :

    * Daca evenimentul i  are aceasi capacitate cu camera j timeTable[i][j] = true.
    
    * In caz contrar timeTable[i][j] = false.


  * [solvingTimeTable](#solvingTimeTable)
  
  Aceasta metoda aloca fiecarui eveniment o camera pe baza timeTable si totodata exclude suprapunerile.
  
  * [occupiedRoom](#occupiedRoom)
  
  Aceasta metoda elimina valorile de true din timeTable pentru o camera ocupata de un eveniment cu alte camere care incep odata cu evenimentul deja alocat camerei
  
  # Tehnologii
   
   * java.util.List
   * java.util.ArrayList
  
