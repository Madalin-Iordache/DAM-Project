package com.feaa.project.main.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="CONTRACT")
public class Contract implements Serializable {

    @Id
    @Column(name = "ID_CONTRACT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;


    @Column(name = "CONTRACT_NAME", nullable = false)
    private String contractName;

    @Column(name="SIGNED_DATE", nullable = false)
    private Date signedDate;

    @Column(name="CONTRACT_VALUE", nullable = false)
    private Integer contractValue;

    @Column(name="CONTRACT_CURRENCY", nullable = false)
    private String contractCurrency;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Licence> licences;

    public Contract() {}

    public Set<Licence> getLicences() {
        return licences;
    }

    public void setLicences(Set<Licence> licences) {
        this.licences = licences;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", client=" + client +
                ", contractName='" + contractName + '\'' +
                ", signedDate=" + signedDate +
                ", contractValue=" + contractValue +
                ", contractCurrency='" + contractCurrency + '\'' +
                '}';
    }
}
