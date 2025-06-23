package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.SchoolAccount;

import java.util.List;

public interface TeacherService {

    public List<SchoolAccountDTO> getTeachers();
    public SchoolAccountDTO createTeacher(SchoolAccount schoolAccount);
    public SchoolAccountDTO assignSubjectToTeacher(Long teacherId, Long subjectId);
}
