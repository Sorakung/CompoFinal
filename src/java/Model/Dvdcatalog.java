/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
 * @author black
 */
@Entity
@Table(name = "DVDCATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvdcatalog.findAll", query = "SELECT d FROM Dvdcatalog d"),
    @NamedQuery(name = "Dvdcatalog.findById", query = "SELECT d FROM Dvdcatalog d WHERE d.id = :id"),
    @NamedQuery(name = "Dvdcatalog.findByDvdname", query = "SELECT d FROM Dvdcatalog d WHERE d.dvdname = :dvdname"),
    @NamedQuery(name = "Dvdcatalog.findByRate", query = "SELECT d FROM Dvdcatalog d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvdcatalog.findByYyear", query = "SELECT d FROM Dvdcatalog d WHERE d.yyear = :yyear"),
    @NamedQuery(name = "Dvdcatalog.findByPrice", query = "SELECT d FROM Dvdcatalog d WHERE d.price = :price"),
    @NamedQuery(name = "Dvdcatalog.findByQuantity", query = "SELECT d FROM Dvdcatalog d WHERE d.quantity = :quantity")})
public class Dvdcatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 80)
    @Column(name = "DVDNAME")
    private String dvdname;
    @Size(max = 80)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YYEAR")
    private Integer yyear;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Dvdcatalog() {
    }

    public Dvdcatalog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDvdname() {
        return dvdname;
    }

    public void setDvdname(String dvdname) {
        this.dvdname = dvdname;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getYyear() {
        return yyear;
    }

    public void setYyear(Integer yyear) {
        this.yyear = yyear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof Dvdcatalog)) {
            return false;
        }
        Dvdcatalog other = (Dvdcatalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Dvdcatalog[ id=" + id + " ]";
    }
    
}
