package com.ragtopmedia.school.enums;

public enum RoleEnum {
    STUDENT_ROLE(1, "Student"),
    TEACHER_ROLE(2, "Teacher"),
    GRADUATE_ASSISTANT(3, "Graduate Assistant");

    private int Id;
    private String value;

    RoleEnum(int Id, String value){
        this.Id = Id;
        this.value = value;
    };

    public String getValue(){
        return value;
    }

    public int getId(){
        return Id;
    }

    public static RoleEnum fromId(int Id){
        for(RoleEnum r : RoleEnum.values()){
            if(r.getId() == Id)
                return r;
        }

        throw new IllegalArgumentException("Invalid id: " + Id);
    }

    public RoleEnum fromValue(String value){
        for(RoleEnum r : RoleEnum.values()){
            if(r.getValue().equals(value)){
                return r;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
