package pl.coderslab.classes;

import java.sql.Date;

public class Vehicle {

    private int id = 0;
    private String brand;
    private String model;
    private int production_year;
    private String plate_number;
    private Date next_service_date;
    private int customer_id;

    public Vehicle(String brand, String model, int production_year, String plate_number, Date next_service_date, int customer_id) {
        this.brand = brand;
        this.model = model;
        this.production_year = production_year;
        this.plate_number = plate_number;
        this.next_service_date = next_service_date;
        this.customer_id = customer_id;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public Date getNext_service_date() {
        return next_service_date;
    }

    public void setNext_service_date(Date next_service_date) {
        this.next_service_date = next_service_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
