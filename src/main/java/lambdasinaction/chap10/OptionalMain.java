package lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
    }

//    public Set<String> getCarInsuranceNames(List<Person> persons) {
//        return persons.stream().map(Person::getCar).map(optCar -> optCar.flatMap(Car::getInsurance))
//                        .map(optInsurance -> optInsurance.map(Insurance::getName)).flatMap(Optional::stream).collect(toSet());
//    }

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        insurance.setName("Pingan");

        Car civic = new Car();
        civic.setInsurance(Optional.ofNullable(insurance));

        Person me = new Person();
        me.setCar(Optional.ofNullable(civic));

        System.out.println(getCarInsuranceName(Optional.empty()));
        System.out.println(getCarInsuranceName(Optional.ofNullable(me)));
    }
}
