package Model;

import java.util.Objects;

public class Student {
    private String dni ;
    private String name;
    private String nacionality;

    public Student(String dni, String name, String nacionality) {
        this.dni = dni;
        this.name = name;
        this.nacionality = nacionality;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }


    @Override
    public String toString() {
        return "Student{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", nacionality='" + nacionality + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(dni, student.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
