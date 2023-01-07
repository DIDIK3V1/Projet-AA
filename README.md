# Projet-AA

#### Compiler le programme :
  Sous Linux : ouvrir un terminal et executer la commande ```./build.sh``` le fichier jar se trouve a la racine.  
  Sous Windows : ouvrir un terminal et executer :
   ```
   javac -d .\build src\Main.java src\graph\*.java src\priorityQueue\*.java      

  xcopy src\META-INF build\
  cd build
  jar cvfm Dijnstra.jar META-INF\MANIFEST.MF Main.class graph\* priorityQueue\*
  # le fichier se trouve dans le dossier build
  ```
   ### Executer le programme : 
   Sous windows comme sous linux le programme peut s'executer de 4 manières différentes :  
   - sans arguments : ``` java -jar Dijinstra.jar```
   - avec 1 arguments : ```java -jar Dijinstra.jar <chemin-De-Fichier-De-Graphe>```  
   - avec 2 arguments : ```java -jar Dijinstra.jar <chemin-De-Fichier-De-Graphe> <Nom-De-Sommet>```  
   - avec 3 arguments : ```java -jar Dijinstra.jar <chemin-De-Fichier-De-Graphe> <Nom-De-Sommet> <chemin-De-Fichier-de-Retour>```  
