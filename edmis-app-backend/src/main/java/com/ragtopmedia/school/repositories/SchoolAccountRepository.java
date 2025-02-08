package com.ragtopmedia.school.repositories;

import com.ragtopmedia.school.entities.SchoolAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolAccountRepository extends JpaRepository<SchoolAccount, Long> {
}
