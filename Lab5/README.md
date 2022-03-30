# Laboratorul 5

 * [Compulsory](#Compulsory) :heavy_check_mark:
 * [Homework](#homework) :heavy_check_mark:
 * [Bonus](#bonus) ❌

## Enunt 
Write an application that can manage a catalog of resources (bibliographic references), such as books, articles, etc.
These resources might be represented by files in the local file system or a Web address. Apart from a unique identifier, a title and its location, a resource may have additional properties such as author(s), what year it was publihsed, description, etc.
You may read more about reference management software, see a comparison of notable implementations, such as JabRef.

Example of entries in the catalog might be:

    {"id":"knuth67", "title":"The Art of Computer Programming", "location":"d:/books/programming/tacp.ps", "year":"1967", "author":"Donald E. Knuth", "type": "book"};  

    {"id":"java17", "title":"The Java Language Specification", "location":"https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "year":"2021", "author":"James Gosling & others"};  
The main specifications of the application are:

## Compulsory

### Enunt

Create an object-oriented model of the problem. You should have at least the following classes: Catalog and Item. The items should have at least a unique identifier, a title and its location. Consider using an interface or an abstract class in order to describe the items in a catalog. :heavy_check_mark:

Implement the following methods representing commands that will manage the content of the catalog:

* add: adds a new entry into the catalog; :heavy_check_mark:
* toString: a textual representation of the catalog; :heavy_check_mark:
* save: saves the catalog to an external file using JSON format; you may use Jackson or other library; :heavy_check_mark:
* load: loads the catalog from an external file. :heavy_check_mark:


## Homework

### Enunt

Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command. :heavy_check_mark:

Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.). :heavy_check_mark:

 * list: prints the list of items on the screen; :heavy_check_mark:
 * view: opens an item using the native operating system application (see the Desktop class); :heavy_check_mark:
 * report: creates (and opens) an HTML report representing the content of the catalog. :heavy_check_mark:
 * Use a template engine such as FreeMarker or Velocity, in order to create the HTML report. :heavy_check_mark:
 * (+1p) Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them. :heavy_check_mark:
 * The application will signal invalid date or the commands that are not valid using custom exceptions. :heavy_check_mark:
 * The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR. :heavy_check_mark:
 
 
 Pentru aceasta instanta : 
 ![image](https://user-images.githubusercontent.com/79217056/160911359-2b74c4c5-6397-4f23-a643-0096e8f61c0d.png)

Va afisa efectul comenzii List :

![image](https://user-images.githubusercontent.com/79217056/160911528-d8d0e61c-5c94-476c-a98d-739f5fb93504.png)

Efectul comenzii View :

![image](https://user-images.githubusercontent.com/79217056/160911663-5e928c3c-a390-4893-9610-3fa870867423.png)

Efectul comenzii Report :

![image](https://user-images.githubusercontent.com/79217056/160911962-8f6237c9-da63-41f1-ae56-17910d1aa156.png)

Efectul comenzii Info : 

![image](https://user-images.githubusercontent.com/79217056/160912516-041cf80d-bab7-4c0f-9ab8-4b8065295a16.png)




 
