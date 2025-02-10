package com.bank.gagas.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NasabahResponseDto {
  private String id;
  private String nik;
  private String fullName;
  private String address;
  private String placeBirth;
  private LocalDate dateOfBirth;
  private String phone;
}
