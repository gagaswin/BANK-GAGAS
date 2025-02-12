package com.bank.gagas.services;

import com.bank.gagas.model.dtos.CreateNasabahRequestDto;
import com.bank.gagas.model.dtos.NasabahResponseDto;
import com.bank.gagas.model.dtos.UpdateNasabahRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NasabahService {
  NasabahResponseDto create(CreateNasabahRequestDto createNasabahRequestDto);

  NasabahResponseDto getByNik(String nik);

  Page<NasabahResponseDto> getAll(Pageable pageable);

  NasabahResponseDto update(String nik, UpdateNasabahRequestDto updateNasabahRequestDto);

  void delete(String nik);
}
