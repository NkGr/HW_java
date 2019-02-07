package nikolay.grigorik.com;

public class Person {

    private final String name;
    private final int age;
    private final Sex sex;
    private Person spouse;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public boolean marry(Person person) {

        if (this.sex != person.getSex() && this.age >= 18 && person.getAge() >= 18) {
            if (this.spouse != null) {
                this.divorce();
            }

            this.spouse = person;

            if (person.getSpouse() == null) {
                person.marry(this);
            }

            System.out.println("*** " + this.name + " was married on " + person.getName() + " ***");
            return true;

        } else {
            System.out.println("*** You can't marry them ***");
            return false;
        }

    }

    public void divorce() {
        Person swap = this.spouse;
        this.spouse = null;

        if (swap != null) {
            System.out.println("*** " + this.name + " was devorced! ***");
            swap.divorce();
        }
    }

    public Person getSpouse() {
        return spouse;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }


    public String getName() {
        return this.name;
    }
}

enum Sex {
    MAN,WOMAN
}