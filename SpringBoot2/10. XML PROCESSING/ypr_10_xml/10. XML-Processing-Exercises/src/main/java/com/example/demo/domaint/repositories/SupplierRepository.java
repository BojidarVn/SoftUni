package com.example.demo.domaint.repositories;

import com.example.demo.domaint.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Set<Supplier> getAllByImporterFalse();
}
