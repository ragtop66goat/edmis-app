package com.ragtopmedia.school.repositories;

import com.ragtopmedia.school.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findBySchoolAccount_Id(Long schoolAccountId);
}
