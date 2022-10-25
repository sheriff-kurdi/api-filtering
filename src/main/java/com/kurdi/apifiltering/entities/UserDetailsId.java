package com.kurdi.apifiltering.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn(name = "language_code")
    Language language;
}
