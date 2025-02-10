package com.bank.gagas.repository;

import com.bank.gagas.model.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, String> {
  Optional<Nasabah> findByNik(String nik);

  void deleteByNik(String nik);
}
