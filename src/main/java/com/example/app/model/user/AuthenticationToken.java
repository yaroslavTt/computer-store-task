package com.example.app.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="tokens")
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne()
    @JoinColumn(nullable = false, name="user_id", referencedColumnName = "id")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }
}
