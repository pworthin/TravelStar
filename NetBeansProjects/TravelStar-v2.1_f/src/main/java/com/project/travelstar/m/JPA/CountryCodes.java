/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m.JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rex Worthington
 */
@Entity
@Table(name = "country_codes", catalog = "travel_info", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryCodes.findAll", query = "SELECT c FROM CountryCodes c"),
    @NamedQuery(name = "CountryCodes.findByCountriesCode", query = "SELECT c FROM CountryCodes c WHERE c.countriesCode = :countriesCode"),
    @NamedQuery(name = "CountryCodes.findByCountriesName", query = "SELECT c FROM CountryCodes c WHERE c.countriesName = :countriesName")})
public class CountryCodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Countries_Code", nullable = false, length = 2)
    private String countriesCode;
    @Size(max = 38)
    @Column(name = "Countries_Name", length = 38)
    private String countriesName;

    public CountryCodes() {
    }

    public CountryCodes(String countriesCode) {
        this.countriesCode = countriesCode;
    }

    public String getCountriesCode() {
        return countriesCode;
    }

    public void setCountriesCode(String countriesCode) {
        this.countriesCode = countriesCode;
    }

    public String getCountriesName() {
        return countriesName;
    }

    public void setCountriesName(String countriesName) {
        this.countriesName = countriesName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countriesCode != null ? countriesCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryCodes)) {
            return false;
        }
        CountryCodes other = (CountryCodes) object;
        if ((this.countriesCode == null && other.countriesCode != null) || (this.countriesCode != null && !this.countriesCode.equals(other.countriesCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.travelstar.m.JPA.CountryCodes[ countriesCode=" + countriesCode + " ]";
    }
    
}
