package com.dushi.EmployeeService.model;

import com.dushi.EmployeeService.sharedModel.Attendance;
import com.dushi.EmployeeService.sharedModel.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column
    private Integer empId;
    @NotEmpty
    @Column
    private String firstName;
    @Column
    private String lastName;
    @NotEmpty
    @Column
    private String email;
    @NotBlank
    @Column
    private String password;
    @NotEmpty
    @Column
    private String designation;
    @NotEmpty
    @Column
    private Double hourlypay;
    @NotEmpty
    @Column
    private Integer maximumWorkingHours;
//    private String state;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeDetails",fetch = FetchType.EAGER)
    Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //OneToMany
    @OneToMany(mappedBy = "employeeDetails",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
            List<Telephone> telephone;

    public List<Telephone> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<Telephone> telephone) {
        this.telephone = telephone;
    }

    //payments
    @Transient
    Payment[] payments;

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    //attendance
    @Transient
    Attendance[] attendances;

    public Attendance[] getAttendances() {
        return attendances;
    }

    public void setAttendances(Attendance[] attendances) {
        this.attendances = attendances;
    }


    //    @OneToMany(mappedBy = "employeeDetails",cascade =CascadeType.ALL)
//            List<Attendance> attendances;
//
//    //attendance
//    public List<Attendance> getAttendances() {
//        return attendances;
//    }
//
//    public void setAttendances(List<Attendance> attendances) {
//        this.attendances = attendances;
//    }
//    //payments
//    @OneToMany(mappedBy = "employeeDetails",cascade =CascadeType.ALL)
//    List<Payment> payments;
//
//    public List<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(List<Payment> payments) {
//        this.payments = payments;
//    }

    //employee details
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getHourlypay() {
        return hourlypay;
    }

    public void setHourlypay(Double hourlypay) {
        this.hourlypay = hourlypay;
    }

    public Integer getMaximumWorkingHours() {
        return maximumWorkingHours;
    }

    public void setMaximumWorkingHours(Integer maximumWorkingHours) {
        this.maximumWorkingHours = maximumWorkingHours;
    }


//    public Boolean getState() {
//        return state;
//    }
//
//    public void setState(Boolean state) {
//        this.state = state;
//    }


//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
}
