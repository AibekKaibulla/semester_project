import java.util.Date;
import enums.SEX;

public class OrManager extends Employee {
    public void sync(University university) {
        university.addEmployee(this);
    }

    public OrManager(String ID, String name, String surname, SEX sex, Date birthDate, String phoneNumber, String citizenship, String password, double salary) {
        super(ID, name, surname, sex, birthDate, phoneNumber, citizenship, password, salary);
    }

    public void seeRequests() {
        //
    }

    public void approveRequest(int n) {
        //
    }

    public void rejectRequest(int n) {
        //
    }

    public void addDiscipline(Discipline discipline) {
        //
    }

    public void removeDiscipline(Discipline discipline) {
        //
    }

    public void updateDiscipline(Discipline discipline_to_edit, Discipline new_discipline) {
        //
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
