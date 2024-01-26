package com.prog2.main.Process;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 * This class is used to create a person object implements IdString
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public abstract class Person implements IdString, Serializable {

    public Person(String name, String phone, String email, char gender) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Person name(String name) {
        setName(name);
        return this;
    }

    public Person phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Person email(String email) {
        setEmail(email);
        return this;
    }

    public Person gender(char gender) {
        setGender(gender);
        return this;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phone, person.phone)
                && Objects.equals(email, person.email) && gender == person.gender;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + prngId() + "'" +
                " name='" + getName() + "'" +
                ", phone='" + getPhone() + "'" +
                ", email='" + getEmail() + "'" +
                ", gender='" + getGender() + "'" +
                "}";
    }

    protected String name;
    transient static protected int n = 0;
    protected int id = n++;
    protected String phone;
    protected String email;
    protected char gender;
    protected Random random = new Random();

}
