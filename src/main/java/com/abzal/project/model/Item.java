package com.abzal.project.model;

import javax.persistence.*;

@Entity
@Table(name = "final_items", schema = "public", catalog = "postgres")
public class Item {
    private int id;
    private String name;
    private String description;
    private int universalProductCode;
    private int price;
    private Integer amount;

    private String imageUrl;

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
    @Column(name = "name", nullable = false, length = 512)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "universal_product_code", nullable = false)
    public int getUniversalProductCode() {
        return universalProductCode;
    }

    public void setUniversalProductCode(int universalProductCode) {
        this.universalProductCode = universalProductCode;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amounts) {
        this.amount = amounts;
    }




    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String umageURL) {
        this.imageUrl = umageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (universalProductCode != item.universalProductCode) return false;
        if (price != item.price) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (amount != null ? !amount.equals(item.amount) : item.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + universalProductCode;
        result = 31 * result + price;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
