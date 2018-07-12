package com.abzal.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "final_cashiers", schema = "public", catalog = "postgres")
public class Cashier {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private Date birthDate;
    private String phone;
    private String email;
    private String imageUrl;
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 256)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 256)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 256)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "image_url", nullable = true, length = 2048)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cashier)) return false;

        Cashier cashier = (Cashier) o;

        if (id != cashier.id) return false;
        if (name != null ? !name.equals(cashier.name) : cashier.name != null) return false;
        if (surname != null ? !surname.equals(cashier.surname) : cashier.surname != null) return false;
        if (gender != null ? !gender.equals(cashier.gender) : cashier.gender != null) return false;
        if (birthDate != null ? !birthDate.equals(cashier.birthDate) : cashier.birthDate != null) return false;
        if (phone != null ? !phone.equals(cashier.phone) : cashier.phone != null) return false;
        if (email != null ? !email.equals(cashier.email) : cashier.email != null) return false;
        if (imageUrl != null ? !imageUrl.equals(cashier.imageUrl) : cashier.imageUrl != null) return false;
        return user != null ? user.equals(cashier.user) : cashier.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
