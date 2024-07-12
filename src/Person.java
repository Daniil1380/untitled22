import java.util.Objects;

public class Person {

    private String name;

    private Person mom;

    private Person dad;

    public Person(String name, Person mom, Person dad) {
        this.name = name;
        this.mom = mom;
        this.dad = dad;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mom=" + mom +
                ", dad=" + dad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(mom, person.mom) && Objects.equals(dad, person.dad);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(mom);
        result = 31 * result + Objects.hashCode(dad);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getMom() {
        return mom;
    }

    public void setMom(Person mom) {
        this.mom = mom;
    }

    public Person getDad() {
        return dad;
    }

    public void setDad(Person dad) {
        this.dad = dad;
    }
}
