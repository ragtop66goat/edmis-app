package com.ragtopmedia.school.repositories;

import com.ragtopmedia.school.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllBySchoolAccount_Id(Long schoolAccountId);
}
