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
import java.util.TimerTask;

/**
 *
 * @author david
 */
public class DatosImpresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here       
        Scanner entrada = new Scanner(System.in);
        String nombre = "";
        int paginas = 0;       
        String file = "..\\Laboratorio-4\\src\\laboratorio\\CaracteristicasDocumentos.csv";
        File f = new File(file);
        Impresora leerDatos = new Impresora();
        Queue<Integer> colanumpag = new LinkedList<Integer>();
        Queue<String> colanombre = new LinkedList<String>();

        try {
            List<Impresora> CaracteristicasDocumentos = leerDatos.LeerListadoDeDatos(f);

            for (int i = 0; i < CaracteristicasDocumentos.size(); i++) {

                int numpag = 0;
                

                nombre = CaracteristicasDocumentos.get(i).Nombre;
                numpag = Integer.parseInt(CaracteristicasDocumentos.get(i).Paginas);

                colanumpag.offer(numpag);
                colanombre.offer(nombre);
            }

            System.out.print("Cuantas impresiones deseas agregar a la cola?: ");
            Scanner sc = new Scanner(System.in);
            int cantImpresiones = sc.nextInt();
            System.out.println("");

            for (int i = 0; i < cantImpresiones; i++) {
                System.out.print("Digite el nombre del documento " + (i + 1) + ": ");
                nombre = sc.next();
                System.out.println("");
                System.out.print("Digite la cantidad de paginas: ");
                paginas = sc.nextInt();
                System.out.println("");
                colanumpag.offer(paginas);
                colanombre.offer(nombre);
            }

            while (!colanombre.isEmpty()) {
                for (int i = 0; i < colanombre.size(); i++) {
                    System.out.println("");
                    System.out.println("Impresion del documento " + colanombre.poll());
                    System.out.println("");

                    int t = colanumpag.element();

                    for (int x = 1; x <= t; x++) {
                        System.out.println("Se esta imprimiendo la pagina " + x + " de " + colanumpag.peek());
                        Thread.sleep(1000);
                        
                    }
                    System.out.println("");
                    System.out.println("Finalización de impresión de " + colanumpag.poll() + " páginas");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger("El dato no fue procesado").log(Level.SEVERE, null, ex);
        }
    }

}
