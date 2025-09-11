package com.ragtopmedia.school.services;

import java.util.List;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;

public interface StudentService {

    public SchoolAccountDTO createStudent(SchoolAccount schoolAccount);
    public List<SchoolAccountDTO> getStudents();

}
