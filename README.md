# BookManager
Bücherverwaltung

### Documentation:
> Project structure:
```
BookManager/
├── data/
│   ├── autoren.csv        # autoren csv data
│   ├── buecher.csv        # buecher csv data
│   └── zeitschriften.csv  # zeitschriften csv data
└── src/
    ├── main/
    |    └── java/
    |          ├── controller/ 
    |          |        └── Runner     # Class to run the project, where the main method is declared.
    |          ├── dao/
    |          |    ├── AuthorDao      # This interface defines the operations to be performed for the Author model.
    |          |    ├── BookDao        # This interface defines the operations to be performed for the Book model.
    |          |    ├── MagazineDao    # This interface defines the operations to be performed for the Magazine model.
    |          |    └── impl
    |          |          ├── AuthorDaoImpl  # This class implements RoomDao interface. This class is responsible of implementing the methods and manipulate the data.
    |          |          ├── BookDaoImpl       # This class implements BookDao interface.
    |          |          └── MagazineDaoImpl   # This class implements MagazineDao interface.                   
    |          ├── db/
    |          |    └── CSVReader   # This class is responsible of reading the CSV files, and delivering a List of objects (Author, Book, magazine). Three static methods are declared inside, each method reads a csv-file. 
    |          └── model
    |               ├── Author      # Author model
    |               ├── Book        # Book model
    |               └── Magazine    # Magazine model
    └── test/
         └── java/ 
               └── TestRunner       # Class to run the 10 unit tests. Each test checks if a required functionality is working correctly.

```

> CMD command lines to run the project:

- go to the project
```
cd BookManager
```
- print all books:  
```
...\BookManager> mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="PrintAllBooks"
```
- print all magazines:  
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="PrintAllMagazines"
```
- print a book which is identified by its ISBN number: 
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="PrintBookByISBN 5554-5545-4518"
```
- print a magazine which is identified by its ISBN number: 
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="PrintMagazineByISBN 2365-5632-7854"
```
- print all the magazines & books for an Author who is indetified by its email: 
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="PrintByAuthor pr-lieblich@optivo.de"
```
- sort all books by title: 
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="SortBooksByTitle"
```
- sort all magazines by title:
```
mvn exec:java -Dexec.mainClass=controller.Runner -Dexec.args="SortMagazinesByTitle"
```

> CMD command line to run the unit tests:

```
...\BookManager> mvn test
```



