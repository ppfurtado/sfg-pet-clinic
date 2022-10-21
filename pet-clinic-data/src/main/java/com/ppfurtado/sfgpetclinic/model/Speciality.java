package com.ppfurtado.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity {

    private String description;

}
