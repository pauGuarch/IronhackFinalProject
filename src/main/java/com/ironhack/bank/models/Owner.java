package com.ironhack.bank.models;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @Column(name = "owner_id")
    private Integer ownerId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "document_no")
    private String documentNo;

    public Owner() {
    }

    public Owner(Integer id, String fullName, String documentNo) {
        this.setOwnerId(id);
        this.setFullName(fullName);
        this.setDocumentNo(documentNo);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}