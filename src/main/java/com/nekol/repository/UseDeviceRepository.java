package com.nekol.repository;

import com.nekol.entity.UseDevice;
import com.nekol.entity.UseDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseDeviceRepository extends JpaRepository<UseDevice, UseDeviceId> {
}
