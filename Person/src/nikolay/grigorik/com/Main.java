package nikolay.grigorik.com;

public class Main {
    public static void main(String[] args) {
        Person dima = new Person("Dima", 28, Sex.MAN);
        Person sveta = new Person("Sveta", 40, Sex.WOMAN);
        Person katya = new Person("Katya", 33, Sex.WOMAN);

        System.out.println("Spouse check");
        System.out.println(dima.marry(sveta));
        System.out.println(dima.getSpouse().getName());
        System.out.println(sveta.getSpouse().getName());
        System.out.println("");

        System.out.println("Divorce check before marriage");
        System.out.println(dima.marry(katya));
        System.out.println(dima.getSpouse().getName());
        System.out.println(sveta.getSpouse());
        System.out.println(katya.getSpouse().getName());
        System.out.println("");

        System.out.println("Divorce check");
        Person spouse = dima.getSpouse();
        spouse.divorce();
        System.out.println(dima.getSpouse());
        System.out.println(katya.getSpouse());
        System.out.println("");

        System.out.println("Marry-check");
        Person nikita = new Person("Nikita", 22, Sex.MAN);
        Person boris = new Person("Boris", 16, Sex.MAN);
        nikita.marry(boris);
        nikita.marry(nikita);
        System.out.println("");

        System.out.println("Illigal marriage check");
        boris.marry(sveta);
        System.out.println("");
    }
}