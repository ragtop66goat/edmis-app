package com.ragtopmedia.school.services;

import java.util.Set;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.dtos.SubjectDTO;

public interface SubjectService {

    public SubjectDTO enrollStudent(Long subjectId, Long studentId);
    public Set<SchoolAccountDTO> getTeacherForSubject(Long subjectId);
}
