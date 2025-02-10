package com.bank.gagas.controllers;

import com.bank.gagas.model.dtos.CreateNasabahRequestDto;
import com.bank.gagas.model.dtos.NasabahResponseDto;
import com.bank.gagas.model.dtos.UpdateNasabahRequestDto;
import com.bank.gagas.services.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nasabah")
@RequiredArgsConstructor
public class NasabahController {
  private final NasabahService nasabahService;

  @PostMapping
  public ResponseEntity<NasabahResponseDto> createNasabah(@RequestBody CreateNasabahRequestDto createNasabahRequestDto) {
    try {
      NasabahResponseDto createNasabahRequest = this.nasabahService.create(createNasabahRequestDto);
      return ResponseEntity.status(HttpStatus.OK).body(createNasabahRequest);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
  }

  @GetMapping("/{nik}")
  public ResponseEntity<NasabahResponseDto> getNasabahByNik(@PathVariable("nik") String nik) {
    try {
      NasabahResponseDto nasabahServiceByNik = this.nasabahService.getByNik(nik);
      return ResponseEntity.status(HttpStatus.OK).body(nasabahServiceByNik);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  @GetMapping
  public ResponseEntity<List<NasabahResponseDto>> getAllNasabah() {
    List<NasabahResponseDto> allNasabah = this.nasabahService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allNasabah);
  }

  @PutMapping("/{nik}")
  public ResponseEntity<NasabahResponseDto> updateNasabah(@PathVariable("nik") String nik,
                                                          @RequestBody UpdateNasabahRequestDto updateNasabahRequestDto) {
    try {
      NasabahResponseDto updateNasabah = this.nasabahService.update(nik, updateNasabahRequestDto);
      return ResponseEntity.status(HttpStatus.OK).body(updateNasabah);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  @DeleteMapping("/{nik}")
  public ResponseEntity<Void> deleteNasabahByNik(@PathVariable("nik") String nik) {
    try {
      this.nasabahService.delete(nik);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
