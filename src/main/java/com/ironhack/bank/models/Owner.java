package com.ironhack.bank.models;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Integer Id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "document_no")
    private String documentNo;

    public Owner() {
    }

    public Owner(Integer id, String fullName, String documentNo) {
        this.setId(id);
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }
}