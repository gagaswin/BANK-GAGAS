package com.bank.gagas.services;

import com.bank.gagas.model.dtos.CreateNasabahRequestDto;
import com.bank.gagas.model.dtos.NasabahResponseDto;
import com.bank.gagas.model.dtos.UpdateNasabahRequestDto;
import java.util.List;

public interface NasabahService {
  NasabahResponseDto create(CreateNasabahRequestDto createNasabahRequestDto);

  NasabahResponseDto getByNik(String nik);

  List<NasabahResponseDto> getAll();

  NasabahResponseDto update(String nik, UpdateNasabahRequestDto updateNasabahRequestDto);

  void delete(String nik);
}
