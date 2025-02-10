package com.bank.gagas.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNasabahRequestDto {
  private String nik;
  private String fullName;
  private String address;
  private String placeBirth;
  private LocalDate dateOfBirth;
  private String phone;
}
