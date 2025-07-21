//package com.demo.db_secure.entities;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity(name = "Auditor")
//@Table(name = "AUDITOR")
//public abstract class Auditor implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    private final LocalDateTime creationDateTime;
//    private final User createdBy;
//
//    private LocalDateTime lastModifiedDateTime;
//    private User lastModifiedBy;
//
//    public Auditor(User createdBy) {
//        this.createdBy = createdBy;
//        this.lastModifiedBy = createdBy;
//        this.creationDateTime = LocalDateTime.now();
//        this.lastModifiedDateTime = this.creationDateTime;
//    }
//
//    public LocalDateTime getLastModifiedDateTime() {
//        return lastModifiedDateTime;
//    }
//
//    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
//        this.lastModifiedDateTime = lastModifiedDateTime;
//    }
//
//    public User getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public void setLastModifiedBy(User lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    public LocalDateTime getCreationDateTime() {
//        return creationDateTime;
//    }
//
//    public User getCreatedBy() {
//        return createdBy;
//    }
//}
