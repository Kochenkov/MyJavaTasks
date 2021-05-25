package patterns.builder;

public class Main {

    public static void main(String[] args) {

        Human human = Human.builder()
                           .setAge(12)
                           .setSurname("trst")
                           .setFather(null)
                           .build();

        System.out.println(human.age);
    }
}
