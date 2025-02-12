package com.bank.gagas.services.impl;

import com.bank.gagas.model.dtos.CreateNasabahRequestDto;
import com.bank.gagas.model.dtos.NasabahResponseDto;
import com.bank.gagas.model.dtos.UpdateNasabahRequestDto;
import com.bank.gagas.model.entity.Nasabah;
import com.bank.gagas.repository.NasabahRepository;
import com.bank.gagas.services.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NasabahServiceImpl implements NasabahService {
  private final NasabahRepository nasabahRepository;

  private Nasabah findByNikOrThrow(String nik) {
    return nasabahRepository.findByNik(nik)
        .orElseThrow(() -> new IllegalArgumentException("Nasabah not found by nik: " + nik));
  }

  @Override
  public NasabahResponseDto create(CreateNasabahRequestDto createNasabahRequestDto) {
    if (nasabahRepository.findByNik(createNasabahRequestDto.getNik()).isPresent()) {
      throw new IllegalArgumentException("NIK exist");
    }

    Nasabah createNasabah = Nasabah.builder()
        .nik(createNasabahRequestDto.getNik())
        .fullName(createNasabahRequestDto.getFullName())
        .address(createNasabahRequestDto.getAddress())
        .placeBirth(createNasabahRequestDto.getPlaceBirth())
        .dateOfBirth(createNasabahRequestDto.getDateOfBirth())
        .phone(createNasabahRequestDto.getPhone())
        .build();
    Nasabah saveNasabah = this.nasabahRepository.save(createNasabah);

    return NasabahResponseDto.builder()
        .id(saveNasabah.getId())
        .nik(saveNasabah.getNik())
        .fullName(saveNasabah.getFullName())
        .address(saveNasabah.getAddress())
        .placeBirth(saveNasabah.getPlaceBirth())
        .dateOfBirth(saveNasabah.getDateOfBirth())
        .phone(saveNasabah.getPhone())
        .build();
  }

  @Override
  public NasabahResponseDto getByNik(String nik) {
    Nasabah currentNasabah = this.findByNikOrThrow(nik);

    return NasabahResponseDto.builder()
        .id(currentNasabah.getId())
        .nik(currentNasabah.getNik())
        .fullName(currentNasabah.getFullName())
        .address(currentNasabah.getAddress())
        .placeBirth(currentNasabah.getPlaceBirth())
        .dateOfBirth(currentNasabah.getDateOfBirth())
        .phone(currentNasabah.getPhone())
        .build();
  }

  @Override
  public Page<NasabahResponseDto> getAll(Pageable pageable) {
    Page<Nasabah> allNasabah = this.nasabahRepository.findAll(pageable);

    return allNasabah.map(nasabah -> NasabahResponseDto.builder()
            .id(nasabah.getId())
            .nik(nasabah.getNik())
            .fullName(nasabah.getFullName())
            .address(nasabah.getAddress())
            .placeBirth(nasabah.getPlaceBirth())
            .dateOfBirth(nasabah.getDateOfBirth())
            .phone(nasabah.getPhone())
            .build());
  }

  @Override
  public NasabahResponseDto update(String nik, UpdateNasabahRequestDto updateNasabahRequestDto) {
    Nasabah currentNasabah = this.findByNikOrThrow(nik);

    Nasabah updatedNasabah = currentNasabah.toBuilder()
        .fullName(updateNasabahRequestDto.getFullName() != null ? updateNasabahRequestDto.getFullName() : currentNasabah.getFullName())
        .address(updateNasabahRequestDto.getAddress() != null ? updateNasabahRequestDto.getAddress() : currentNasabah.getAddress())
        .placeBirth(updateNasabahRequestDto.getPlaceBirth() != null ? updateNasabahRequestDto.getPlaceBirth() : currentNasabah.getPlaceBirth())
        .dateOfBirth(updateNasabahRequestDto.getDateOfBirth() != null ? updateNasabahRequestDto.getDateOfBirth() : currentNasabah.getDateOfBirth())
        .phone(updateNasabahRequestDto.getPhone() != null ? updateNasabahRequestDto.getPhone() : currentNasabah.getPhone())
        .build();

    Nasabah saveUpdated = this.nasabahRepository.save(updatedNasabah);

    return NasabahResponseDto.builder()
        .id(saveUpdated.getId())
        .nik(saveUpdated.getNik())
        .fullName(saveUpdated.getFullName())
        .address(saveUpdated.getAddress())
        .placeBirth(saveUpdated.getPlaceBirth())
        .dateOfBirth(saveUpdated.getDateOfBirth())
        .phone(saveUpdated.getPhone())
        .build();
  }

  @Override
  public void delete(String nik) {
    Nasabah currentNasabah = this.findByNikOrThrow(nik);
    this.nasabahRepository.delete(currentNasabah);
  }
}
