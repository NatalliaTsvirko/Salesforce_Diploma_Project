package models;

import enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Leads {

    private LeadStatus leadStatus;
    private Salutation salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String website;
    private String title;
    private String email;
    private String company;
    private Industry industry;
    private String phone;
    private String numberOfEmployee;
    private String mobile;
    private LeadSource leadSource;
    private Rating rating;
    private String searchAddress;
    private String street;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;

}
