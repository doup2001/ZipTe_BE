package com.eedo.ZipTe.domain.repository;

import com.eedo.ZipTe.domain.entity.Apt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AptRepository extends JpaRepository<Apt, Long> {

}
