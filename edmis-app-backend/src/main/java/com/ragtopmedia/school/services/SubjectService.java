package com.ragtopmedia.school.services;

import java.util.Set;

import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;

public interface SubjectService {

    public Subject enrollStudent(Long subjectId, Long studentId);
    public Set<SchoolAccount> getTeacherForSubject(Long subjectId);
}
