import graph.Graph;
import graph.ParentCost;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;



public class Main {
    public static Graph loadGraph(String arg) {
        File file = new File(arg);
        Scanner scan;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }
        Graph g = new Graph(scan);
        scan.close();
        return g;
    }
    public static void writeFile(String values, String filepath){
        Path fileName = Path.of(filepath);
        try {
            Files.writeString(fileName, values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int askForVertex(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Numéro de Sommet : ");
        return sc.nextInt();
    }

    public static Graph askForGraph(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le graphe :");
        return new Graph(scan);
    }

    public static void main(String[] args) {
        if (args.length==0){//lire entrée standard graphe et sommet et ecrire entrée standard
            Graph g = askForGraph();
            int vertex = askForVertex();
            String s = ParentCost.parentCostTabToString(g.Dijkstra(vertex));
            System.out.println(s);
        }
        if (args.length==1){//demander sommet
            Graph g = loadGraph(args[0]);
            int vertex = askForVertex();
            String s = ParentCost.parentCostTabToString(g.Dijkstra(vertex));
            System.out.println(s);
        }
        if (args.length==2){//ecrire sortie standard
            Graph g = loadGraph(args[0]);
            String s = ParentCost.parentCostTabToString(g.Dijkstra(Integer.parseInt(args[1])));
            System.out.println(s);
        }
        if (args.length==3) {
            Graph g = loadGraph(args[0]);
            String s = ParentCost.parentCostTabToString(g.Dijkstra(Integer.parseInt(args[1])));
            writeFile(s,args[2]);
        }
        System.out.println("Hello world!");
    }

}