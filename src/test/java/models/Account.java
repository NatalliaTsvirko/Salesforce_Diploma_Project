package models;

import enums.Industry;
import enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String accountName;
    private String phone;
    private String parentAccount;
    private String fax;
    private String website;
    private AccountType type;
    private Industry industry;
    private String employees;
    private String annualRevenue;
    private String billingStreet;
    private String shippingStreet;
    private String billingCity;
    private String shippingCity;
    private String billingStateProvince;
    private String shippingStateProvince;
    private String billingZipPostalCode;
    private String shippingZipPostalCode;
    private String billingCountry;
    private String shippingCountry;
    private String description;
    private String shippingAddress;
    private String billingAddress;
}






