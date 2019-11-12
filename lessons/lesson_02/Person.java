package lesson_02;

import java.util.Comparator;

public class Person {
    public String name;
    public Integer age;
    public Sex.sex sex;

    public String getName(){return name;}
    public Integer getAge(){return age;}
    public Sex.sex getSex(){return sex;}

    @Override
    public String toString(){
        String result = "";
        result = this.name + " - " + this.age + " - " + this.sex.toString();
        return result;
    }

    @Override
    public boolean equals(Object equalsPerson) {
        boolean result = false;
        if (this.name == ((Person)equalsPerson).name &
                this.age.equals(((Person)equalsPerson).age) &
                this.sex == ((Person)equalsPerson).sex ) {
            result = true;
        }
        return  result;
    }

}


