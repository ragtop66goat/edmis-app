package com.ragtopmedia.school.enums;

public enum Role {
    STUDENT_ROLE(1, "Student"),
    TEACHER_ROLE(2, "Teacher"),
    GRADUATE_ASSISTANT(3, "Graduate Assistant");

    private int Id;
    private String value;

    Role(int Id, String value){
        this.Id = Id;
        this.value = value;
    };

    public String getValue(){
        return value;
    }

    public int getId(){
        return Id;
    }

    public static Role fromId(int Id){
        for(Role r : Role.values()){
            if(r.getId() == Id)
                return r;
        }

        throw new IllegalArgumentException("Invalid id: " + Id);
    }

    public Role fromValue(String value){
        for(Role r : Role.values()){
            if(r.getValue().equals(value)){
                return r;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
