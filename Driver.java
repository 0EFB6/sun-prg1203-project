public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        PokeBall pb1 = new PokeBall("Wilson");
        System.out.println(pb1);

        Catch c1 = new Catch(pb1, true, 10.1);
        System.out.println(c1);

        printStartMenu();
    }

    public static void printStartMenu() {
        System.out.println("Welcome to Pokemon Ga-Ole!");
    }
}
