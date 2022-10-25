package com.kurdi.apifiltering.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn(name = "language_code")
    Language language;
}
