package utils;

import com.github.javafaker.Faker;
import enums.AccessType;
import models.Group;

public class GroupsGenerator {

    public Group getGroupsData() {
        Faker faker = new Faker();
        Group groups = Group.builder()
                .name(faker.name().firstName())
                .description("Groups")
                .information("information")
                .accessType(AccessType.PUBLIC)
                .build();
        return groups;
    }
}
