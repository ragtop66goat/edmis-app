package com.ragtopmedia.school.services;

import com.ragtopmedia.school.entities.Contact;
import java.util.List;

public interface TeacherService {

    public List<Contact> getTeachers();
    public Contact createTeacher(Contact teacher);
    public Contact assignSubjectToTeacher(Long teacherId, Long subjectId);
}
