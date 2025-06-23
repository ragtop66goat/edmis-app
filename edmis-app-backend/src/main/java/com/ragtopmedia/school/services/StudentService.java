package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;

public interface StudentService {

    public SchoolAccountDTO createStudent(SchoolAccount schoolAccount);

}
