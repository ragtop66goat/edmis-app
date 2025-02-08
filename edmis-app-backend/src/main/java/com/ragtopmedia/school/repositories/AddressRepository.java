package com.ragtopmedia.school.repositories;

import com.ragtopmedia.school.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
