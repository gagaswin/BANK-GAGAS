package com.bank.gagas.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNasabahRequestDto {
  @NotBlank
  @Size(min = 3, max = 100)
  private String fullName;

  @Size(max = 150)
  private String address;

  @Size(min = 3)
  private String placeBirth;

  private LocalDate dateOfBirth;

  @Size(min = 10, max = 13)
  private String phone;
}
