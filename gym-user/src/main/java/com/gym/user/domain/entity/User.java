package com.gym.user.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User", schema="gymdb")
public class User extends Base  {
    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private int age;

    private Boolean disabled;

    private Boolean activated;


    @PrePersist
    @Override
    public void prePersist() {
        this.creationDate = new Date();
        this.activated = false;
    }

    public String getPassword() {
        return password;
    }

    public void encodePassword(String password){
        this.password = this.passwordEncoder.encode(password);
    }
}
