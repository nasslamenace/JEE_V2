/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sasha
 */
@Entity
@Table(name = "tab_evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabEvaluation.findAll", query = "SELECT t FROM TabEvaluation t"),
    @NamedQuery(name = "TabEvaluation.findById", query = "SELECT t FROM TabEvaluation t WHERE t.id = :id"),
    @NamedQuery(name = "TabEvaluation.findByVisiteShit", query = "SELECT t FROM TabEvaluation t WHERE t.visiteShit = :visiteShit"),
    @NamedQuery(name = "TabEvaluation.findByEvalshitCompany", query = "SELECT t FROM TabEvaluation t WHERE t.evalshitCompany = :evalshitCompany"),
    @NamedQuery(name = "TabEvaluation.findByWebSondage", query = "SELECT t FROM TabEvaluation t WHERE t.webSondage = :webSondage"),
    @NamedQuery(name = "TabEvaluation.findByRapportSend", query = "SELECT t FROM TabEvaluation t WHERE t.rapportSend = :rapportSend"),
    @NamedQuery(name = "TabEvaluation.findByOralDone", query = "SELECT t FROM TabEvaluation t WHERE t.oralDone = :oralDone"),
    @NamedQuery(name = "TabEvaluation.findByVisitecheck", query = "SELECT t FROM TabEvaluation t WHERE t.visitecheck = :visitecheck"),
    @NamedQuery(name = "TabEvaluation.findByTechnicalGrade", query = "SELECT t FROM TabEvaluation t WHERE t.technicalGrade = :technicalGrade"),
    @NamedQuery(name = "TabEvaluation.findByCommGrade", query = "SELECT t FROM TabEvaluation t WHERE t.commGrade = :commGrade")})
public class TabEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Visite_Shit")
    private String visiteShit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Eval_shit_Company")
    private String evalshitCompany;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Web_Sondage")
    private String webSondage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Rapport_Send")
    private String rapportSend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Oral_Done")
    private String oralDone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Visite_check")
    private String visitecheck;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Technical_Grade")
    private int technicalGrade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Comm_Grade")
    private int commGrade;

    public TabEvaluation() {
    }

    public TabEvaluation(Integer id) {
        this.id = id;
    }

    public TabEvaluation(Integer id, String visiteShit, String evalshitCompany, String webSondage, String rapportSend, String oralDone, String visitecheck, int technicalGrade, int commGrade) {
        this.id = id;
        this.visiteShit = visiteShit;
        this.evalshitCompany = evalshitCompany;
        this.webSondage = webSondage;
        this.rapportSend = rapportSend;
        this.oralDone = oralDone;
        this.visitecheck = visitecheck;
        this.technicalGrade = technicalGrade;
        this.commGrade = commGrade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisiteShit() {
        return visiteShit;
    }

    public void setVisiteShit(String visiteShit) {
        this.visiteShit = visiteShit;
    }

    public String getEvalshitCompany() {
        return evalshitCompany;
    }

    public void setEvalshitCompany(String evalshitCompany) {
        this.evalshitCompany = evalshitCompany;
    }

    public String getWebSondage() {
        return webSondage;
    }

    public void setWebSondage(String webSondage) {
        this.webSondage = webSondage;
    }

    public String getRapportSend() {
        return rapportSend;
    }

    public void setRapportSend(String rapportSend) {
        this.rapportSend = rapportSend;
    }

    public String getOralDone() {
        return oralDone;
    }

    public void setOralDone(String oralDone) {
        this.oralDone = oralDone;
    }

    public String getVisitecheck() {
        return visitecheck;
    }

    public void setVisitecheck(String visitecheck) {
        this.visitecheck = visitecheck;
    }

    public int getTechnicalGrade() {
        return technicalGrade;
    }

    public void setTechnicalGrade(int technicalGrade) {
        this.technicalGrade = technicalGrade;
    }

    public int getCommGrade() {
        return commGrade;
    }

    public void setCommGrade(int commGrade) {
        this.commGrade = commGrade;
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
        if (!(object instanceof TabEvaluation)) {
            return false;
        }
        TabEvaluation other = (TabEvaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pj.TabEvaluation[ id=" + id + " ]";
    }
    
}
