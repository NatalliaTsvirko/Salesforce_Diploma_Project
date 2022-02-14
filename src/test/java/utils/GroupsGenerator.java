package utils;

import com.github.javafaker.Faker;
import enums.AccessType;
import models.Groups;

public class GroupsGenerator {

    public Groups getGroupsData() {
        Faker faker = new Faker();
        Groups groups = Groups.builder()
                .name(faker.name().firstName())
                .description("Groups")
                .information("information")
                .accessType(AccessType.PUBLIC)
                .build();
        return groups;
    }
}
