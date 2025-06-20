package com.ragtopmedia.school.services;

import com.ragtopmedia.school.dtos.SchoolAccountDTO;
import com.ragtopmedia.school.entities.Contact;
import com.ragtopmedia.school.entities.SchoolAccount;

import java.util.List;

public interface TeacherService {

    public List<Contact> getTeachers();
    public SchoolAccountDTO createTeacher(SchoolAccountDTO schoolAccount);
    public SchoolAccount assignSubjectToTeacher(Long teacherId, Long subjectId);
}
