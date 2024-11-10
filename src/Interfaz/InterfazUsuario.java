package Interfaz;

import dominio.Contacto;
import dominio.Libreta;

import java.util.Scanner;

public class InterfazUsuario {
    private Libreta libreta;
    private Scanner scanner;

    public InterfazUsuario() {
        libreta = new Libreta();
        scanner = new Scanner(System.in);
    }

    public void procesarPeticion() {
        System.out.println("Las operaciones posibles son las siguientes:");
        System.out.println("- Añadir contacto: 'add <nombre> <telefono>'");
        System.out.println("- Mostrar contactos: 'list'");
        System.out.println("- Mostrar esta ayuda: 'help'");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("?> ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");
            String comando = partes[0];

            switch (comando) {
                case "add":
                    if (partes.length == 3) {
                        String nombre = partes[1];
                        String telefono = partes[2];
                        libreta.agregarContacto(new Contacto(nombre, telefono));
                    } else {
                        System.out.println("Uso: add <nombre> <telefono>");
                    }
                    break;
                case "list":
                    System.out.println(libreta.listarContactos());
                    break;
                case "help":
                    System.out.println("Las operaciones posibles son las siguientes:");
                    System.out.println("- Añadir contacto: 'add <nombre> <telefono>'");
                    System.out.println("- Mostrar contactos: 'list'");
                    System.out.println("- Mostrar esta ayuda: 'help'");
                    break;
                case "exit":
                    continuar = false;
                    break;
                default:
                    System.out.println("Comando no reconocido. Escriba 'help' para ver las opciones disponibles.");
            }
        }
    }
}

