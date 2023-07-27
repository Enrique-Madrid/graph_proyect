package Main;

import java.util.Scanner;
import Misc.SaveCMD;

import Graph.Graph;

public class main {
    public static void main(String[] args) {

        Graph<String, String> graph = new Graph<>();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            input = scanner.nextLine();

            String[] inputArray = input.split(" ");


            // * ADD VERTEX
            if (inputArray[0].equals("add") && inputArray[1].equals("vertex") && inputArray.length == 3) {
                SaveCMD.save(input);
                graph.addVertex(inputArray[2]);
                continue;
            }

            // * ADD EDGE
            if (inputArray[0].equals("add") && inputArray[1].equals("edge") && inputArray.length == 4) {
                SaveCMD.save(input);
                graph.addEdge(inputArray[2], inputArray[3]);
                continue;
            }

            // * LIST VERTEX
            if (inputArray[0].equals("list") && inputArray[1].equals("vertex") && inputArray.length == 2) {
                SaveCMD.save(input);
                graph.listVertex();
                continue;
            }

            // * LIST EDGE
            if (inputArray[0].equals("list") && inputArray[1].equals("edge") && inputArray.length == 3) {
                SaveCMD.save(input);
                graph.listEdge(inputArray[2]);
                continue;
            }

            // * PATH
            if (inputArray[0].equals("path") && inputArray.length == 3) {
                SaveCMD.save(input);
                graph.path(inputArray[1], inputArray[2]);
                continue;
            }

            // * HELP
            if (inputArray[0].equals("help")) {
                SaveCMD.save(input);
                System.out.println("\u001B[32m" + "-----------------------------------\nWelcome\n-----------------------------------" + "\u001B[0m");
                System.out.println("\u001B[32m" + "add vertex <vertex>" + "\u001B[0m");
                System.out.println("\u001B[32m" + "add edge <vertex> <vertex>" + "\u001B[0m");
                System.out.println("\u001B[32m" + "list vertex" + "\u001B[0m");
                System.out.println("\u001B[32m" + "list edge <vertex>" + "\u001B[0m");
                System.out.println("\u001B[32m" + "path <vertex> <vertex>" + "\u001B[0m");
                System.out.println("\u001B[32m" + "help" + "\u001B[0m");
                System.out.println("\u001B[32m" + "exit" + "\u001B[0m");
                continue;
            }

            // * EXIT
            if (inputArray[0].equals("exit")) {
                SaveCMD.save(input);
                System.exit(0);
            }
        }
    }
}
