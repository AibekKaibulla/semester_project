package model.people;

import enums.SEX;
import enums.TEACHERDEGREE;
import model.misc.School;
import model.misc.University;
import model.academic.Discipline;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public class Teacher extends Employee implements Comparable<Person> {
    private School school;

    private Vector<Discipline> disciplines;
    private TEACHERDEGREE degree;

    public void sync(University university) {
        university.addEmployee(this);
    }

    public Teacher(String ID, String name, String surname, SEX sex, Date birthDate, String phoneNumber, String citizenship, String password, double salary, School school, TEACHERDEGREE degree) {
        super(ID, name, surname, sex, birthDate, phoneNumber, citizenship, password, salary);
        this.school = school; school.addEmployee(this); // school.getUniversity().addEmployee(this);
        this.disciplines = new Vector<Discipline>();
        this.degree = degree;
    }


    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public void sendComplaint(Dean dean, Vector<Student> students, String complaint, String urgencyLevel) {
        dean.receiveComplaint(this, complaint, urgencyLevel);
    }

    public void viewDisciplines() {
        for (Discipline discipline : disciplines) {
            System.out.println(discipline);
        }
    }

    public void updateDiscipline(Discipline discipline_to_edit, Discipline new_discipline) {
        // Teacher can't update discipline by itself, instead should be sent message for manager to update
        // the course accordingly
        for (Discipline d : disciplines) {
            if (d.equals(discipline_to_edit)) {
                d = new_discipline;
            }
        }
    }

    public void updateMark(Student student, Discipline discipline, double mark, int i) {
        student.getCourses().lastElement().updateDisciplineMark(discipline, mark, i);
    }

    @Override
    public int compareTo(@NotNull Person o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Teacher teacher)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(school, teacher.school) && Objects.equals(disciplines, teacher.disciplines) && degree == teacher.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), school, disciplines, degree);
    }

    @Override
    public String toString() {
        return "Teacher[[" + super.toString() +
                "], school=" + school +
                ", disciplines=" + disciplines +
                ", degree=" + degree +
                ']';
    }
}
