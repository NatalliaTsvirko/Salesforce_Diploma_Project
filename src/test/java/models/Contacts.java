package models;

import enums.Salutation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contacts {
    private String phone;
    private String mobile;
    private String middleName;
    private Salutation salutation;
    private String suffix;
    private String searchAddress;
    private String firstName;
    private String lastName;
    private String accountName;
    private String email;
    private String title;
    private String reportsTo;
    private String mailingStreet;
    private String mailingCity;
    private String mailingStateProvince;
    private String mailingZipPostalCode;
    private String mailingCountry;
    private String fax;
    private String department;
    private String description;

}