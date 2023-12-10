package com.mb.homekit.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempDataRepository extends JpaRepository<TempData, Long> {
}