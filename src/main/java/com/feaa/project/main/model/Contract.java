package com.feaa.project.main.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CONTRACT")
public class Contract implements Serializable {

    @Id
    @Column(name = "ID_CONTRACT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENT", insertable = false, updatable = false, nullable = false)
    private Client client;

    @Column(name="SIGNED_DATE", nullable = false)
    private Date signedDate;

    @Column(name="CONTRACT_VALUE", nullable = false)
    private Integer contractValue;

    public Contract() {}

    public Contract(Date signedDate, Integer contractValue) {
        this.signedDate = signedDate;
        this.contractValue = contractValue;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public Integer getContractValue() {
        return contractValue;
    }

    public void setContractValue(Integer contractValue) {
        this.contractValue = contractValue;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + idContract +
                ", client=" + client +
                ", signedDate=" + signedDate +
                ", contractValue=" + contractValue +
                '}';
    }
}
