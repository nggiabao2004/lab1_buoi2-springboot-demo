//lab1_buoi2
package com.gdu_springboot.springboot_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="detail")
    private String detail;

    @Column(name="price")
    private int price;

    public Product() {}

    public Product(String name, String detail, int price) {
        this.name = name;
        this.detail = detail;
        this.price = price;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}
