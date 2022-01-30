package utils;

import com.github.javafaker.Faker;
import enums.Salutation;
import models.Contacts;

public class ContactsGenerator {

    public Contacts getContactsWithAllData() {
        Faker faker = new Faker();
        faker.company().name();
        Contacts contacts = Contacts.builder()
                .salutation(Salutation.MR)
                .firstName(faker.name().firstName())
                .middleName(faker.name().username())
                .lastName(faker.name().lastName())
                .suffix(faker.name().suffix())
                .reportsTo("")
                .title(faker.name().title())
                .department(faker.name().bloodGroup())
                .fax("663")
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().cellPhone())
                .mobile(faker.phoneNumber().cellPhone())
                .mailingStreet(faker.address().streetAddress())
                .mailingCity(faker.address().city())
                .mailingStateProvince(faker.address().secondaryAddress())
                .mailingZipPostalCode(faker.address().zipCode())
                .mailingCountry(faker.address().country())
                .build();
        return contacts;
    }
}
