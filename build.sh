!/bin/sh
#compilation dans le dosser build
echo compilation
javac -d ./build src/Main.java src/graph/*.java src/priorityQueue/*.java      
cp -r src/META-INF build/
#création du .jar executable
cd build
echo "création du jar"
jar cvfm Dijnstra.jar META-INF/MANIFEST.MF Main.class graph/* priorityQueue/*
mv Dijnstra.jar ../Dijnstra.jar
