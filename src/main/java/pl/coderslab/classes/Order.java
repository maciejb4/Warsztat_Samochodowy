package pl.coderslab.classes;


import java.sql.Date;
import java.sql.Time;

public class Order {

    private int id = 0;
    private Date date_in;
    private Date date_out;
    private Date started_date;
    private int employee_id;
    private String issue_note;
    private String repair_note;
    private int status_id = 1;
    private int vehicle_id;
    private int repair_cost;
    private int parts_cost;
    private int man_hours;

    public Order(Date date_in, Date date_out, Date started_date, int employee_id, String issue_note, String repair_note, int status_id, int vehicle_id, int repair_cost, int parts_cost, int man_hours) {
        this.date_in = date_in;
        this.date_out = date_out;
        this.started_date = started_date;
        this.employee_id = employee_id;
        this.issue_note = issue_note;
        this.repair_note = repair_note;
        this.status_id = status_id;
        this.vehicle_id = vehicle_id;
        this.repair_cost = repair_cost;
        this.parts_cost = parts_cost;
        this.man_hours = man_hours;
    }

    public Order() {
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public Date getStarted_date() {
        return started_date;
    }

    public void setStarted_date(Date started_date) {
        this.started_date = started_date;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getIssue_note() {
        return issue_note;
    }

    public void setIssue_note(String issue_note) {
        this.issue_note = issue_note;
    }

    public String getRepair_note() {
        return repair_note;
    }

    public void setRepair_note(String repair_note) {
        this.repair_note = repair_note;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(int repair_cost) {
        this.repair_cost = repair_cost;
    }

    public int getParts_cost() {
        return parts_cost;
    }

    public void setParts_cost(int parts_cost) {
        this.parts_cost = parts_cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMan_hours() {
        return man_hours;
    }

    public void setMan_hours(int man_hours) {
        this.man_hours = man_hours;
    }
}
