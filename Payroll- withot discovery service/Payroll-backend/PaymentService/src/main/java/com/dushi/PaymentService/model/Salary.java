package com.dushi.PaymentService.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer empId;
    private Integer year;
    private String month;
    private Double monthlySalary;
    private String isPaid;

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

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
}
