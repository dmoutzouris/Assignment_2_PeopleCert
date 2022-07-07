/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dimitrios
 */
@Entity
@Table(name = "trainers")
@NamedQueries({
    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t"),
    @NamedQuery(name = "Trainers.findById", query = "SELECT t FROM Trainers t WHERE t.id = :id"),
    @NamedQuery(name = "Trainers.findByFirstname", query = "SELECT t FROM Trainers t WHERE t.firstname = :firstname"),
    @NamedQuery(name = "Trainers.findByLastname", query = "SELECT t FROM Trainers t WHERE t.lastname = :lastname"),
    @NamedQuery(name = "Trainers.findByEmail", query = "SELECT t FROM Trainers t WHERE t.email = :email")})
public class Trainers implements Serializable {

    @Lob
    @Column(name = "insurancefile")
    private byte[] insurancefile;
    
    @Column(name = "insurancefilename")
    private String insurancefilename;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;

    public Trainers() {
    }

    public Trainers(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Trainers(byte[] insurancefile, String insurancefilename, String firstname, String lastname, String email) {
        this.insurancefile = insurancefile;
        this.insurancefilename = insurancefilename;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    

    public Trainers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainers)) {
            return false;
        }
        Trainers other = (Trainers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trainers{");
        sb.append("id=").append(id);
        sb.append(", firstname=").append(firstname);
        sb.append(", lastname=").append(lastname);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    public byte[] getInsurancefile() {
        return insurancefile;
    }

    public void setInsurancefile(byte[] insurancefile) {
        this.insurancefile = insurancefile;
    }

    public String getInsurancefilename() {
        return insurancefilename;
    }

    public void setInsurancefilename(String insurancefilename) {
        this.insurancefilename = insurancefilename;
    }

    
}
