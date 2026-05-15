package com.example.brothers.Repository;

import com.example.brothers.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

    Address findByUserIdAndIsDefaultTrue(Long userId);
}