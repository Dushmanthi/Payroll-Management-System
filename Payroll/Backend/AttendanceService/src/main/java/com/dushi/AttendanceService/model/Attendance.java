package com.dushi.AttendanceService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "empId can not be missing or empty")
    private Integer empId;

    @NotNull(message = "year can not be missing or empty")
    @Digits(integer=4, fraction=0,message = "year can have digits")
    private Integer year;

    @NotBlank(message = "month can not be missing or empty")
    private String month;

    @NotNull(message = "day can not be missing or empty")
    @Digits(integer=2, fraction=0,message = "year can have digits")
    private Integer day;

    @NotNull(message = "workingHours can not be missing or empty")
    @Digits(integer=2, fraction=2,message = "year can have combination of digits and fractions")
    private Double workingHours;

    @NotNull(message = "isPresent can not be missing or empty")
    private String isPresent;

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

    public String getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(String isPresent) {
        this.isPresent = isPresent;
    }

}
