package com.dushi.EmployeeService.model;

import com.dushi.EmployeeService.sharedModel.Attendance;
import com.dushi.EmployeeService.sharedModel.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "empId can not be missing or empty")
    private Integer empId;

    @NotBlank(message = "firstName can not be missing or empty")
    private String firstName;

    @NotBlank(message = "lastName can not be missing or empty")
    private String lastName;
    @Email
    private String email;

 //   private String password;
    @NotBlank(message = "designation can not be missing or empty")
    private String designation;

    private String number;

    private String street;

    private String city;

    private String phoneNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
//    Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    //OneToMany
//    @OneToMany(mappedBy = "employee",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
//            List<Telephone> telephone;
//
//    public List<Telephone> getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(List<Telephone> telephone) {
//        this.telephone = telephone;
//    }

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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
