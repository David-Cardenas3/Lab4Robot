/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TimerTask;

/**
 *
 * @author david
 */
public class DatosRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here       
        Scanner entrada = new Scanner(System.in);
        String tarea = "";
        double tiempo = 0;
        String file = "..\\Laboratorio-4\\src\\laboratorio\\TareasRobot.csv";
        File f = new File(file);
        Tarea leerDatos = new Tarea();
        Stack pilatiempo = new Stack();
        Stack pilatarea = new Stack();

        try {
            List<Tarea> TareasRobot = leerDatos.LeerListadoDeDatos(f);

            for (int i = 0; i < TareasRobot.size(); i++) {

                double time = 0;

                tarea = TareasRobot.get(i).Tareas;
                time = Double.parseDouble(TareasRobot.get(i).Tiempo);

                pilatarea.push(tarea);
                pilatiempo.push(time);
            }

            System.out.print("Cuantas tareas deseas agregar a la pila?: ");
            Scanner sc = new Scanner(System.in);
            int cantTareas = sc.nextInt();
            System.out.println("");

            for (int i = 0; i < cantTareas; i++) {
                System.out.print("Digite el nombre de la tarea (ts-tc) " + (i + 1) + ": ");
                tarea = sc.next();
                System.out.println("");
                pilatarea.push(tarea);
            }
            while (!pilatarea.isEmpty()) {               
                for (int i = 1; i < pilatarea.size(); i++) {
                    System.out.println("");                  
                    if (pilatarea.peek().equals("ts")) {
                        System.out.println("Se esta imprimiendo la tarea " + pilatarea.pop());
                        Thread.sleep(500);
                    } else {
                        if (pilatarea.peek().equals("tc")) {
                            System.out.println("Se esta imprimiendo la tarea " + pilatarea.pop());
                            Thread.sleep(800);
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger("El dato no fue procesado").log(Level.SEVERE, null, ex);
        }
    }

}
