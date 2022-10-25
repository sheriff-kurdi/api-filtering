package com.kurdi.apifiltering.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int age;

    @OneToMany(mappedBy = "user")
    List<UserDetails> userDetails = new ArrayList<>();
}
