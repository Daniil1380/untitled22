import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Car first = new Car("Volvo", 120_000, 2000);
        Car second = new Car("BMW", 600_000, 1998);

        List<Car> list = new ArrayList<>();
        list.add(first);
        list.add(second);

        Integer result = list.stream()
                .filter(car -> car.getYearOfManufacture() > 1999)
                .map(Car::getMileage)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println(result);

        Car resultCar = list.stream()
                .filter(car -> car.getMileage() > 500_000)
                //.min(Comparator.comparing(car -> car.getYearOfManufacture()))
                .min((x, y) -> x.getYearOfManufacture() - y.getYearOfManufacture())
                .orElse(null);

        System.out.println(resultCar);

        resultCar = list.stream()
                .filter(car -> car.getMileage() < 200_000)
                .filter(car -> car.getName().startsWith("V") || car.getName().startsWith("W"))
                .max(Comparator.comparing(car -> car.getMileage()))
                .orElse(null);

        System.out.println(resultCar);



        Person dadFirst = new Person("Андрей", null, null);
        Person momFirst = new Person("Александра", null, null);
        Person firstPerson = new Person("Иван", momFirst, dadFirst);

        Person dadSecond = new Person("Иван", null, null);
        Person momSecond = new Person("Ольга", null, null);
        Person secondPerson = new Person("Павел", momSecond, dadSecond);

        List<Person> people = new ArrayList<>();
        people.add(firstPerson);
        people.add(secondPerson);

        List<Person> dads = people.stream()
                .map(person -> person.getDad())
                .filter(dad -> dad.getName().length() <= 6)
                .toList();

        List<Person> moms = people.stream()
                .map(person -> person.getMom())
                .filter(mom -> mom.getName().length() <= 6)
                .toList();

        List<Person> parents = new ArrayList<>();
        parents.addAll(moms);
        parents.addAll(dads);

        System.out.println(parents);

        parents = people.stream()
                .flatMap(person -> Stream.of(person.getDad(), person.getMom()))
                .filter(parent -> parent.getName().length() > 6)
                .toList();

        System.out.println(parents);









    }

    //Домашнее задание:
    //
    //1.1 Создайте класс "Машина"
    //1.2 Добавьте в этот класс 3 поля: наименование марки, год выпуска и пробег
    //
    //2.1. Среди машин, которые имеют год выпуска новее, чем 1999, необходимо подсчитать общий пробег
    //2.2. Среди машин, у которых пробег более 500 000, найти самую старую машину
    //2.3. Среди машин, у которых марка начинается на "V" или "W", найти с самым большим пробегом, но не более 200 000 тысяч
    //Copy
    //Более сложное задание
    //
    //1. Создайте класс Person
    //1.2 Добавьте в этот класс 3 поля: имя, папа и мама. Папа и мама - тоже поля класса Person
    //2.1. У вас есть список из людей, найдите среди них всех их мам и пап, у которых имя длиннее 6 букв
    //
    //Подскажка: Делайте либо через Stream.of(), либо делаем по отдельности (способ Владимира)
    //
    //Дополнение: важно поработать со стримами, но разрешается где-то какое-то действие выполнить без них
}
