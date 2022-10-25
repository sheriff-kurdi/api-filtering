package com.kurdi.apifiltering.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UserDetailsId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn(name = "language_code")
    Language language;
}
