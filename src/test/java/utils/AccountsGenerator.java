package utils;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.AccountType;
import models.Account;


public class AccountsGenerator {

    public Account getAccountWithAllData() {
        Faker faker = new Faker();
        Account account = Account.builder()
                .accountName(faker.name().firstName())
                .phone(faker.phoneNumber().phoneNumber())
                .website(faker.internet().domainName())
                .type(AccountType.CUSTOMER)
                .industry(Industry.UTILITIES)
                .employees("885")
                .billingStreet(faker.address().streetAddress())
                .shippingStreet(faker.address().streetName())
                .billingCity(faker.address().cityName())
                .shippingCity(faker.address().cityName())
                .billingStateProvince(faker.address().secondaryAddress())
                .shippingStateProvince(faker.address().secondaryAddress())
                .billingZipPostalCode(faker.address().zipCode())
                .shippingZipPostalCode(faker.address().zipCode())
                .billingCountry(faker.address().country())
                .shippingCountry(faker.address().country())
                .description("1236548")
                .build();
        return account;
    }

    public Account getWithAccountName() {
        Faker faker = new Faker();
        Account account = Account.builder()
                .accountName(faker.name().firstName())
                .build();
        return account;
    }

}
