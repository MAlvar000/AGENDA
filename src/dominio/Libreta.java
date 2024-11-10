package dominio;

import java.io.*;
import java.util.ArrayList;

public class Libreta {
    private ArrayList<Contacto> contactos;
    private static final String FICHERO_CONTACTOS = "contactos.txt";

    public Libreta() {
        contactos = new ArrayList<>();
        cargarContactos();
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
        guardarContactos();
    }

    public String listarContactos() {
        StringBuilder listado = new StringBuilder();
        for (Contacto c : contactos) {
            listado.append(c.toString()).append("\n");
        }
        return listado.toString();
    }

    private void cargarContactos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHERO_CONTACTOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    Contacto contacto = new Contacto(partes[0], partes[1]);
                    contactos.add(contacto);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de contactos.");
        }
    }

    private void guardarContactos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHERO_CONTACTOS))) {
            for (Contacto c : contactos) {
                writer.write(c.getNombre() + "," + c.getTelefono());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de contactos.");
        }
    }
}

