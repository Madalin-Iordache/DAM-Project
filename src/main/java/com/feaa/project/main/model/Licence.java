package com.feaa.project.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="LICENCE")
public class Licence implements Serializable {

    @Id
    @Column(name = "ID_LICENCE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLicence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CONTRACT", nullable = false)
    private Contract contract;

    @Column(name="SERIAL", nullable = false)
    private String serialNumber;

    @Column(name="START_DATE", nullable = false)
    private Date startDate;

    @Column(name="END_DATE", nullable = false)
    private Date endDate;

    @Column(name="STATUS", nullable = false)
    private String status;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Licence() {}

    public Licence(Integer idLicence, Contract contract, String serialNumber, Date startDate, Date endDate, String status) {
        this.idLicence = idLicence;
        this.contract = contract;
        this.serialNumber = serialNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Integer getIdLicence() {
        return idLicence;
    }

    public void setIdLicence(Integer idLicence) {
        this.idLicence = idLicence;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Licence{" +
                "idLicence=" + idLicence +
                ", contract=" + contract +
                ", serialNumber='" + serialNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}
