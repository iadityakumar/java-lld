package org.aditya.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class User {

    private String username;

//    https://stackoverflow.com/a/69885641
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    https://stackoverflow.com/a/49111290
    private static AtomicInteger automicIntegerId = new AtomicInteger(0);
    private String email;
    private String phone;

    public User(String username, String email, String phone) {
        this.username = username;
        this.id = automicIntegerId.incrementAndGet();
        this.email = email;
        this.phone = phone;
    }

}
