package com.vti.entity;

public class Employee extends User {
    private int projectId;
    private String proSkill;

    public Employee() {
        super();
    }

    public Employee(int id, String fullName, String email, String password, Role role) {
        super(id, fullName, email, password, role);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}