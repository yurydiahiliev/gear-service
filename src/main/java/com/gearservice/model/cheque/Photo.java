package com.gearservice.model.cheque;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.gearservice.config.converter.OffsetDateTimePersistenceConverter;
import com.gearservice.model.authorization.User;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String contentType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @Convert(converter = OffsetDateTimePersistenceConverter.class)
    private OffsetDateTime addedDate;

    @Lob
    private byte[] bytes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cheque", referencedColumnName = "id")
    private Cheque photoOwner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName = "username")
    private User user;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public byte[] getBytes() {return bytes;}
    public void setBytes(byte[] bytes) {this.bytes = bytes;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getContentType() {return contentType;}
    public void setContentType(String contentType) {this.contentType = contentType;}
    public Cheque getPhotoOwner() {return photoOwner;}
    public void setPhotoOwner(Cheque photoOwner) {this.photoOwner = photoOwner;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public OffsetDateTime getAddedDate() {return addedDate;}
    public void setAddedDate(OffsetDateTime addedDate) {this.addedDate = addedDate;}
}
