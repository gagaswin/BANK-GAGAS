package com.bank.gagas.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nasabah")
public class Nasabah {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "nik", unique = true, updatable = false, nullable = false, length = 16)
  private String nik;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "address")
  private String address;

  @Column(name = "place_birth")
  private String placeBirth;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "phone")
  private String phone;
}
