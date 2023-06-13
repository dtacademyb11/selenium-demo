package june10;

import com.github.javafaker.Faker;

public class FakerDemo {


    public static void main(String[] args) {


        Faker faker =  new Faker();

        String firstName = faker.name().firstName();


        System.out.println(firstName);

        System.out.println(faker.name().username());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.business().creditCardNumber().replace("-", ""));
        System.out.println(faker.chuckNorris().fact());

    }
}
