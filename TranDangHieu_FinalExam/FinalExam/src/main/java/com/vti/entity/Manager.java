package com.vti.entity;

public class Manager extends User {
    private int expInYear;

    public Manager(int id, String fullName, String email, String password, Role role, int expInYear) {
        super(id, fullName, email, password, role);
        this.expInYear = expInYear;
    }

    public Manager() {
        super();
    }

    @Override
    public String toString() {
        String format = "%-10s %-20s %-30s %-20s %-20s";
        String manager= String.format(format,this.getId(),this.getFullName(),this.getEmail(),this.getPassword(),this.getExpInYear());
        return manager;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
}
