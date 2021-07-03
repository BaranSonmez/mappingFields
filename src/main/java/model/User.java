package model;

import enums.AccountType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    public Address billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "DELIVERY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "DELIVERY_ZIPCODE")),
            @AttributeOverride(name = "city", column = @Column(name = "DELIVERY_CITY"))
    })
    public Address deliveryAddress;

    @UpdateTimestamp
    protected Date lastModified;

    @CreationTimestamp
    protected Date creationDate;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Address getBillingAdress() {
        return billingAddress;
    }

    public void setBillingAdress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
