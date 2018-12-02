package pl.coderslab.classes;

public class Employee {
    private int id;
    private String name;
    private String lastname;
    private String adress;
    private String employee_phone;
    private String note;
    private int hourly;

    public Employee() {

    }

    public Employee(String name, String lastname, String adress, String employee_phone, String note, int hourly) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.employee_phone = employee_phone;
        this.note = note;
        this.hourly = hourly;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getHourly() {
        return hourly;
    }

    public void setHourly(int hourly) {
        this.hourly = hourly;
    }
}
