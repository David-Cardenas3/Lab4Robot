/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Tarea {

    public String Tareas;
    public String Tiempo;

    public Tarea(String tareas, String tiempo) {
        Tareas = tareas;
        Tiempo = tiempo;
    }

    public Tarea() {
    }

    public List<Tarea> LeerListadoDeDatos(File f) throws FileNotFoundException {
        List<Tarea> leerDatos = new ArrayList<>();
        try (Scanner scanner = new Scanner(f);) {
            while (scanner.hasNextLine()) {
                String[] hoja = getRecordFromLine(scanner.nextLine());

                leerDatos.add(new Tarea(hoja[0], hoja[1]));
            }
        }
        return leerDatos;
    }

    public static String[] getRecordFromLine(String line) {
        String[] values = line.split(";");
        return values;
    }
}
