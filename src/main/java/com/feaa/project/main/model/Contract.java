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

    @Column(name="CONTRACT_CURRENCY", nullable = false)
    private String contractCurrency;

    public Contract() {}

    public Contract(Date signedDate, Integer contractValue, String contractCurrency) {
        this.signedDate = signedDate;
        this.contractValue = contractValue;
        this.contractCurrency = contractCurrency;
    }

    public String getContractCurrency() {
        return contractCurrency;
    }

    public void setContractCurrency(String contractCurrency) {
        this.contractCurrency = contractCurrency;
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
