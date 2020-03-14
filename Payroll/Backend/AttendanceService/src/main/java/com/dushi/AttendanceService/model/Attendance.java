package com.dushi.AttendanceService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer empId;
    private Integer year;
    private String month;
    private Integer day;
    private Double workingHours;
    private String isPresent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
   // EmployeeDetails employeeDetails; //getter setter


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

//    public Boolean getPresent() {
//        return present;
//    }
//
//    public void setPresent(Boolean present) {
//        this.present = present;
//    }


    public String getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(String isPresent) {
        this.isPresent = isPresent;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", empId=" + empId +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", day=" + day +
                ", workingHours=" + workingHours +
                ", isPresent='" + isPresent + '\'' +
                '}';
    }
}
