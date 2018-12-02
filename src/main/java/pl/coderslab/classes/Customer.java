package pl.coderslab.classes;

import java.sql.Date;

public class Customer {

    private int id = 0;
    private String name;
    private String surname;
    private Date birthDate;
    private String customer_phone;

    public Customer(String name, String surname, Date birthDate, String customer_phone) {

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.customer_phone = customer_phone;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
}
