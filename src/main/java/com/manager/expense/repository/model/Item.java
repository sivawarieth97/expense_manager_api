package com.manager.expense.repository.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "item_id")
    private UUID itemId;
    @Column(name = "item_name")
    String itemName;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "price")
    float price;
    @Column(name = "expense_id")
    UUID expenseID;

    public UUID getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(UUID expenseID) {
        this.expenseID = expenseID;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }



}
