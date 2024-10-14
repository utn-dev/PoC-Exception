import Exceptions.InvalidInputException;
import Exceptions.StudentNotFoundException;
import Model.Student;
import Service.ServiceStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ServiceStudent serviceStudent = new ServiceStudent();
        Student S1 = null;
        boolean next = true;
        while (next) {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Mostrar todos los estudiantes");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción: ");
            int option = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer
            switch (option) {
                case 1:
                    String dni;
                    String name = "";
                    String nationality = "";

                    System.out.println("Ingrese DNI: ");
                    dni = teclado.nextLine();

                    // Bucle para pedir el nombre hasta que sea válido
                    boolean validName = false;
                    while (!validName) {
                        try {
                            System.out.println("Ingrese nombre: ");
                            name = teclado.nextLine();
                            serviceStudent.validateName(name);  // Valida el nombre en el servicio
                            validName = true;  // Si no hay excepción, es válido
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage());  // Mensaje de error
                        }
                    }

                    // Bucle para pedir la nacionalidad hasta que sea válida
                    boolean validNationality = false;
                    while (!validNationality) {
                        try {
                            System.out.println("Ingrese nacionalidad: ");
                            nationality = teclado.nextLine();
                            serviceStudent.validateNationality(nationality);  // Valida la nacionalidad en el servicio
                            validNationality = true;  // Si no hay excepción, es válida
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage());  // Mensaje de error
                        }
                    }

                    // Agregar estudiante después de obtener valores válidos
                    S1 = new Student(dni, name, nationality);
                    serviceStudent.addStudent(S1);
                    break;
                case 2:
                    try {
                        System.out.println("Ingrese el DNI del estudiante a eliminar: ");
                        String dniToRemove = teclado.nextLine();
                        serviceStudent.removeStudent(dniToRemove);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Ingrese el DNI del estudiante a actualizar: ");
                        String dniToUpdate = teclado.nextLine();
                        System.out.println("Ingrese el nuevo nombre: ");
                        String newName = teclado.nextLine();
                        System.out.println("Ingrese la nueva nacionalidad: ");
                        String newNationality = teclado.nextLine();
                        serviceStudent.updateStudent(dniToUpdate, newName, newNationality);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Listado de estudiantes : ");
                    serviceStudent.ShowAll();
                    break;
                case 5:
                    next = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

}
