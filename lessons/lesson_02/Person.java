package lesson_02;

import java.util.Comparator;

public class Person {
    String name;
    Integer age;
    Sex.sex sex;

    String getName(){return name;}
    Integer getAge(){return age;}
    Sex.sex getSex(){return sex;}
}


class PersonNameComparator implements Comparator<Person>{
    public int compare(Person a, Person b){
        return a.getName().compareTo(b.getName());
    }
}


class PersonAgeComparator implements Comparator<Person>{
    public int compare(Person a, Person b){
        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
