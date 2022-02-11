package utils;

import com.github.javafaker.Faker;

import enums.*;
import models.Leads;

public class LeadsGenerator {

    public Leads getLeadsWithAllData() {
        Faker faker = new Faker();
        faker.company().name();
        Leads leads = Leads.builder()
                .leadStatus(LeadStatus.NURTURING)
                .salutation(Salutation.MRS)
                .firstName(faker.name().firstName())
                .middleName(faker.name().nameWithMiddle())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .suffix(faker.name().suffix())
                .website("hhh.com")
                .title(faker.name().title())
                .email("ttt@gmail.com")
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
}
