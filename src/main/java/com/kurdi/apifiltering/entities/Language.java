package com.kurdi.apifiltering.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Language {
    @Id
    @Column(name = "language_code")
    String languageCode;
    @Column(name = "language_name")
    String languageName;
}
