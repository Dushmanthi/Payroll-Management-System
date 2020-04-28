package com.dushi.PaymentService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   // @NotNull(message = "empId can not be missing or empty")
    private Integer empId;

    @NotNull(message = "year can not be missing or empty")
    @Digits(integer=4, fraction=0)
    private Integer year;

    @NotBlank(message = "month can not be missing or empty")
    private String month;

    @NotNull(message = "day can not be missing or empty")
    @Digits(integer=2, fraction=0,message = "day can have digits only")
    private Integer day;

    @NotNull(message = "workingHours can not be missing or empty")
    @Digits(integer=2, fraction=2,message = "workingHours can have digits and fraction numbers")
    private Double workingHours;

    @NotNull(message = "hourlypay can not be missing or empty")
    @Digits(integer=5, fraction=2,message = "hourlypay can have digits and fraction numbers")
    private Double hourlypay;

    private Double daySalary;
    private Double monthlySalary;

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
