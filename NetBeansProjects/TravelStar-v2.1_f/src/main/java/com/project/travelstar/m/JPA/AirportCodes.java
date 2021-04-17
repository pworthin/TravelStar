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
import javax.persistence.Lob;
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
@Table(name = "airport_codes", catalog = "travel_info", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AirportCodes.findAll", query = "SELECT a FROM AirportCodes a"),
   // @NamedQuery(name = "AirportCodes.findByIataCode", query = "SELECT a FROM AirportCodes a WHERE a.iataCode = :iataCode")})
      @NamedQuery(name = "AirportCodes.findByIataCode", query = "SELECT a.iataCode FROM AirportCodes a WHERE a.country = :country AND a.location = :location"),
      @NamedQuery(name = "AirportCodes.duplicateCheck", query = "SELECT COUNT (a.iataCode) FROM AirportCodes a WHERE a.country = :country AND a.location = :location")})
public class AirportCodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "locationName", length = 65535)
    private String locationName;
    @Lob
    @Size(max = 65535)
    @Column(name = "location", length = 65535)
    private String location;
    @Lob
    @Size(max = 65535)
    @Column(name = "country", length = 65535)
    private String country;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "iataCode", nullable = false, length = 15)
    private String iataCode;

    public AirportCodes() {
    }

    public AirportCodes(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iataCode != null ? iataCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AirportCodes)) {
            return false;
        }
        AirportCodes other = (AirportCodes) object;
        if ((this.iataCode == null && other.iataCode != null) || (this.iataCode != null && !this.iataCode.equals(other.iataCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.travelstar.m.JPA.AirportCodes[ iataCode=" + iataCode + " ]";
    }
    
}
