package Service;

import Exceptions.InvalidInputException;
import Exceptions.StudentNotFoundException;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ServiceStudent {
    List<Student> students;


    public ServiceStudent() {
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Estudiante agregado correctamente");
    }

    public void ShowAll(){
        for (Student s : students){
            System.out.println(s);
        }
    }

    // Validar nombre
    public void validateName(String name) throws InvalidInputException {
        if (name.isEmpty()){
            throw new InvalidInputException("El nombre no puede estar vacio.");
        }
        if (containsNumbers(name)) {
            throw new InvalidInputException("El nombre no puede contener números o estar vacio.");
        }
    }

    public void removeStudent(String dni) throws StudentNotFoundException {
        Student student = findStudentByDni(dni);
        students.remove(student);  // Elimina al estudiante encontrado
        System.out.println("Estudiante eliminado correctamente: " + student.getName());
    }

    // Método para actualizar estudiante por DNI
    public void updateStudent(String dni, String newName, String newNationality) throws StudentNotFoundException {
        Student student = findStudentByDni(dni);
        student.setName(newName);
        student.setNacionality(newNationality);
        System.out.println("Estudiante actualizado correctamente: " + student.getName());
    }

    public Student findStudentByDni(String dni) throws StudentNotFoundException {
        Student tempStudent = new Student(dni, "", "");  // Crea un estudiante temporal solo con el DNI
        for (Student student : students) {
            if (student.equals(tempStudent)) {  // Compara usando equals del override en clase Student
                return student;  // Retorna el estudiante si lo encuentra
            }
        }
        // Si no se encuentra el estudiante, lanza la excepción
        throw new StudentNotFoundException("Estudiante con DNI " + dni + " no encontrado.");
    }


    // Validar nacionalidad
    public void validateNationality(String nationality) throws InvalidInputException {
        if (nationality.isEmpty()){
            throw new InvalidInputException("La nacionalidad no puede estar vacio.");
        }
        if (containsNumbers(nationality)) {
            throw new InvalidInputException("La nacionalidad no puede contener números.");
        }
    }

    // Método para verificar si una cadena contiene números
    private boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }

}
