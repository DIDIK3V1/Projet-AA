!/bin/sh
#suppression du dossier build s'il existe
#rm -r build/
#compilation dans le dosser build
echo compilation
javac -d ./build src/Main.java src/graph/*.java src/priorityQueue/*.java      
cp -r src/META-INF build/
#création du .jar executable

echo "création du jar"
jar cvfm Dijnstra.jar build/META-INF/MANIFEST.MF build/Main.class build/graph/* build/priorityQueue/*

