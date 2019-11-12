package lesson_05;

import lesson_02.Person;

import java.util.*;

/**
 * @author Sharmin Aleksei
 * Класс: Животное
 * Поля: UID - идентификатор животного; name - кличка животного; weight - вес животного; owner - хозяин животного
 */

public class Animal {

    //public UUID id;
    public String name;
    public double weight;
    public Person owner;

    //UUID getUUID(){return id;}
    String getName(){return name;}
    double getWeight(){return weight;}
    Person getOwner(){return owner;}
    String getOwnerName() {return  this.owner.name;}

    @Override
    public String toString(){
        String result = "";
        result = /*this.id + " - " +*/ this.name + " - " + this.weight + " - " + this.owner.toString();
        return result;
    }

    @Override
    public boolean equals(Object equalsAnimal) {
        boolean result = false;
        if (//this.id == ((Animal)equalsAnimal).id &
                this.name == ((Animal)equalsAnimal).name &
                this.weight == ((Animal)equalsAnimal).weight &
                this.owner.equals(((Animal)equalsAnimal).owner)) {
            result = true;
        }
        return  result;
    }

}
