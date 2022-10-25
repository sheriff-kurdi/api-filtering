package com.kurdi.apifiltering.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetails implements Serializable {
    @EmbeddedId
    UserDetailsId UserDetailsId;
    String name;


}
