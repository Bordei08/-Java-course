# Cuprins
 * [Informatii generale](#informatii-generale)
 * [Tehnologii](#tehnologii)

## Informatii generale

Algoritmul propus reduce problema crearii un orar fara suprapuneri la problema colorarii unui graf.
Evenimentele vor reprezenta nodurile grafului si camerele sunt culorile.
Programul este impartit in 7 clase :
  * [Bonus](#bonus)
  * [Event](#event)
  * [Room](#room)
  * [ComputerLab](#computerlab)
  * [LectureHall](#lecturehall)
  * [Graph](#graph)
  * [Solution](#solution)

## Bonus
  Este clasa principala care contine urmatoarele metode :
  * [main](#main)

In metoda main are rolul de a sincroniza toate metodele pentru a obtine rezultatul problemei.
Aici vom declara o lista cu evenimente, events, una cu camere, rooms, si un obiect de tipul Solution, pentru rezolvarea instantelor date.
  * [creatEvents](#createvents)

Aceasta metoda generaza evenimente random in lista events.

 * [creatRooms](#creatrooms)

Aceasta metoda genereaza camere random in lista rooms.

 * [creatStartTime](#creatstarttime)

Aceasta metoda genereaza o ora de inceput pentru un anumit eveniment, ora este generata random. Aceasta poate sa primeasca valori dintr-un interval de 24 ore - durat evenimentului.

 * [creatEndTime](#creatEndTime)

Aceasta metoda calculeaza timpul de final al unui eveniment (statTime + durataEveniment).

  * [creatCapacity](#creatcapacity)

Aceasta metoda alege care va fi capacitatea evenimentului sau a camerei (30 sau 100 cu sansa de 50/ 50).

 * [creatEventName](#creatEventName)

Acesta metoda genereaza un nume evenimentului in fucntie de capacitatea acestuia :
     
     Daca capacity = 30, atunci eventName = "Lab".
     
     Daca capacity = 100, atunci eventName = "Curs".
     
  * [creatRoomName](#creaatroomName)

Aceasta metoda genereaza un nume random pentru fiecare camera, fiecare nume generat este unic.

  * [isUnic](#isunic)

Aceasta metoda este una de tip boolean si va returna :
   
     Daca numele este unic in lista de evenimente sau daca lista este goala valoare true.
     
     In caz contrar false.
     
## Event
Clasa Event doreste sa defineasca un eveniment cu toate propietatile sale :
   * intervalul orar in care se desfasoara
   * Capacitatea evenimentului
   * Numele evenimentului
  
 ## Room
 Clasa Room este o clasa abstracta care defineste o camera cu toate propietatile sale :
    * Capacitate 
    * Nume camera
    
 ## ComputerLab
 Este o clasa extinsa din clasa Room cu o propietate in plus, sistemul folosit de calculatoarele din aceasta.
 Acestui obiect ii este specifica o capacitate de 30.
 
 ## LectureHall
 Este o clasa extinsa din clasa Room cu o propietate in plus, daca exista sau nu un video proiector.
Acestui obiect ii este specifica o capacitate de 100.

## Graph
Aceasta clasa defineste un graf neorientat si contine urmatoarele:

 * adjacentMatrix un tablou bidimensional care va retine daca nodul i este adiacent cu nodul j.
    
 * nods o lista de evenimente (List<Event>) ce va memora nodurile grafului.
  
Si 4 metode mai interesante :
  
  * [adjacentMatrixInitialization](#adjacentMatrixInitialization)
  
 Aceasta metoda formeaza matricea de adiacenta verficand doar jumatate din aceasta deoarece matricea adjacentMatrix este simetrica.
  
  * [areAdjacent](#areAdjacent)
  
  Aceasta metoda verifica daca doua noduri sunt adiacente, avand in vedere ca nodurile sunt evenimente acestea sunt adiacente daca :
     
     * cele doua evenimente se suprapun din punctul de vedere al timpului in care se desfasoara.
  
     * au aceasi capacitate.
  
  * [sort](#sort)
  
  Aceasta metoda sorteaza lista cu noduri in ordine descrescatoare.
  
   * [degree](#degree)
  
 Aceasta metoda returneaza gradul unui nod primit ca parametru. 
   

 ## Solution 
  
  Aceasta clasa propune o solutie problemei noastre, reduce problema la problema colorarii unui graf.
  
 Aceasta clasa contine urmatoarele :
  
  [timeTAble](#timeTable) un vector bidimensional care va retine nodul si culoarea acestuia.
  
  Si 5 metode :
  
  *[solving](#solving)
  
  Aceasta metoda este "functia main" a clasei Solution, aceasta defineste un graf pe baza  evenimentelor si formeaza o lista de culori pe baza listei rooms.
  
   *[DSatur](#Dsatur)
  
  Aceasta metoda sorteaza nodurile grafului in ordine descrescatoare si incepe colorarea acestora.
  
  * [colorNods](#colorNods)
  
   Aceasta metoda pentru fiecare nod al grafului cauta o culoarea care are aceasi capacitatea cu a sa si verifica daca poate fi colorat cu aceasta.
  
  * [match](#match)
  
  Aceasta metoda verifica daca o culoare poate colora un nod :
  
    Nodul colorat cu culoarea curent nu trebuie sa mai abia noduri adiacente cu aceasi culoare
  
    Nodul colorat cu culoarea curent trebuie sa aiba o singura culoare.
  
  ## Tehnologii
  
  * java.time.LocalTime
  * java.util.ArrayList
  * java.util.List
  * java.util.Random
  * java.util.Collections
  
  
  
