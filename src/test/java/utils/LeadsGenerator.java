package utils;

import com.github.javafaker.Faker;

import enums.*;
import models.Lead;

public class LeadsGenerator {

    public Lead getLeadWithAllData() {
        Faker faker = new Faker();
        Lead leads = Lead.builder()
                .leadStatus(LeadStatus.NURTURING)
                .salutation(Salutation.MRS)
                .firstName(faker.name().firstName())
                .middleName(faker.name().nameWithMiddle())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .suffix(faker.name().suffix())
                .website(faker.internet().url())
                .title(faker.name().title())
                .email(faker.internet().emailAddress())
                .industry(Industry.UTILITIES)
                .phone(faker.phoneNumber().cellPhone())
                .numberOfEmployee("333")
                .mobile(faker.phoneNumber().cellPhone())
                .leadSource(LeadSource.PARTNER)
                .rating(Rating.WARM)
                .city(faker.address().city())
                .build();

        return leads;
    }

    public Lead getLeadWithName() {
        Faker faker = new Faker();
        Lead lead = Lead.builder()
                .leadStatus(LeadStatus.NURTURING)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .build();
        return lead;
    }
}