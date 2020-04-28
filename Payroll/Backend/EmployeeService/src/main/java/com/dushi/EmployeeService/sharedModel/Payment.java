package com.dushi.EmployeeService.sharedModel;

public class Payment {

    private Integer id;
    private Integer empId;
    private Integer year;
    private String month;
    private Integer day;
    private Double workingHours;
    private Double hourlypay;
    private Double daySalary;
    private Double monthlySalary;
    //private boolean paid;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        this.workingHours = workingHours;
    }

    public Double getHourlypay() {
        return hourlypay;
    }

    public void setHourlypay(Double hourlypay) {
        this.hourlypay = hourlypay;
    }

    public Double getDaySalary() {
        daySalary =(workingHours*hourlypay);

        return daySalary;
    }

    public void setDaySalary(Double daySalary) {
        this.daySalary = daySalary;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
