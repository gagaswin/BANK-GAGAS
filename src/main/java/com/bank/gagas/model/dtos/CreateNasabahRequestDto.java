package com.bank.gagas.model.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNasabahRequestDto {
  @NotNull(message = "nik tidak boleh null")
  @NotEmpty(message = "nik tidak boleh kosong")
  @NotBlank(message = "nik tidak boleh blank")
  @Size(min = 16, max = 16, message = "nik tidak valid")
  private String nik;

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
