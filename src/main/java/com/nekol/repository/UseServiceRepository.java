package com.nekol.repository;

import com.nekol.entity.UseService;
import com.nekol.entity.UseServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseServiceRepository extends JpaRepository<UseService, UseServiceId> {
}
