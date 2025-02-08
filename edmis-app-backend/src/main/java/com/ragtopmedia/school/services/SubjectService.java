package com.ragtopmedia.school.services;

import com.ragtopmedia.school.entities.SchoolAccount;
import com.ragtopmedia.school.entities.Subject;

public interface SubjectService {

    public Subject enrollStudent(Long subjectId, Long studentId);
    public SchoolAccount getTeacherForSubject(Long subjectId);
}
