package com.ragtopmedia.school.repositories;

import com.ragtopmedia.school.entities.SchoolAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface SchoolAccountRepository extends JpaRepository<SchoolAccount, Long> {

    List<SchoolAccount> findAllByRoleId(int roleId);
}
