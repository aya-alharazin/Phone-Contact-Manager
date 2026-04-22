/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author aya
 */
public class Contact {
    private int id;
    private String name;
    private String phone;
    private String relationship;
    private String email;
    private boolean favorite;

    public Contact(int id, String name, String phone, String relationship, String email, boolean favorite) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.relationship = relationship;
        this.email = email;
        this.favorite = favorite;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.name+" - "+this.phone+" - "+this.relationship+"\n";
    }
            


    


    }
