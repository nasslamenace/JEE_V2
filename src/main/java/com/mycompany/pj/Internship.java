/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pj;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sasha
 */
@Entity
@Table(name = "internship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Internship.findAll", query = "SELECT i FROM Internship i"),
    @NamedQuery(name = "Internship.findById", query = "SELECT i FROM Internship i WHERE i.id = :id"),
    @NamedQuery(name = "Internship.findByDateBegin", query = "SELECT i FROM Internship i WHERE i.dateBegin = :dateBegin"),
    @NamedQuery(name = "Internship.findByDateEnd", query = "SELECT i FROM Internship i WHERE i.dateEnd = :dateEnd"),
    @NamedQuery(name = "Internship.findByMissionDescription", query = "SELECT i FROM Internship i WHERE i.missionDescription = :missionDescription"),
    @NamedQuery(name = "Internship.findByCommentary", query = "SELECT i FROM Internship i WHERE i.commentary = :commentary"),
    @NamedQuery(name = "Internship.findByIDSupervisor", query = "SELECT i FROM Internship i WHERE i.iDSupervisor = :iDSupervisor"),
    @NamedQuery(name = "Internship.findByIDCompany", query = "SELECT i FROM Internship i WHERE i.iDCompany = :iDCompany"),
    @NamedQuery(name = "Internship.findByIDStudent", query = "SELECT i FROM Internship i WHERE i.iDStudent = :iDStudent"),
    @NamedQuery(name = "Internship.findByIDTabEvaluation", query = "SELECT i FROM Internship i WHERE i.iDTabEvaluation = :iDTabEvaluation")})
public class Internship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Begin")
    @Temporal(TemporalType.DATE)
    private Date dateBegin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_End")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Mission_Description")
    private String missionDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Commentary")
    private String commentary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Supervisor")
    private int iDSupervisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Company")
    private int iDCompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Student")
    private int iDStudent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Tab_Evaluation")
    private int iDTabEvaluation;

    public Internship() {
    }

    public Internship(Integer id) {
        this.id = id;
    }

    public Internship(Integer id, Date dateBegin, Date dateEnd, String missionDescription, String commentary, int iDSupervisor, int iDCompany, int iDStudent, int iDTabEvaluation) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.missionDescription = missionDescription;
        this.commentary = commentary;
        this.iDSupervisor = iDSupervisor;
        this.iDCompany = iDCompany;
        this.iDStudent = iDStudent;
        this.iDTabEvaluation = iDTabEvaluation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public int getIDSupervisor() {
        return iDSupervisor;
    }

    public void setIDSupervisor(int iDSupervisor) {
        this.iDSupervisor = iDSupervisor;
    }

    public int getIDCompany() {
        return iDCompany;
    }

    public void setIDCompany(int iDCompany) {
        this.iDCompany = iDCompany;
    }

    public int getIDStudent() {
        return iDStudent;
    }

    public void setIDStudent(int iDStudent) {
        this.iDStudent = iDStudent;
    }

    public int getIDTabEvaluation() {
        return iDTabEvaluation;
    }

    public void setIDTabEvaluation(int iDTabEvaluation) {
        this.iDTabEvaluation = iDTabEvaluation;
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
        if (!(object instanceof Internship)) {
            return false;
        }
        Internship other = (Internship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pj.Internship[ id=" + id + " ]";
    }
    
}
