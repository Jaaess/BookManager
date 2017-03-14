# BookManager
Bücherverwaltung

### Documentation:

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



