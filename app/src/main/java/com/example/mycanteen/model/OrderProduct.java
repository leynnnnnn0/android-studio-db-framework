package com.example.mycanteen.model;

import android.content.Context;

import com.example.mycanteen.database.DBHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OrderProduct extends DBHelper<OrderProduct> {
    public int id;
    public int order_id;
    public int product_id;
    public int quantity;
    public float price;
    public Order order;
    public Product product;
    public OrderProduct(Context context) {
        super(context, "order_products");
    }

    @Override
    public String[] fillable() {
        return new String[]{
                "id",
                "order_id",
                "product_id",
                "quantity",
                "price"
        };
    }

    public static LinkedHashMap<String, String> schema() {
        LinkedHashMap<String, String> columns = new LinkedHashMap<>();
        columns.put("id", "INTEGER PRIMARY KEY AUTOINCREMENT");
        columns.put("order_id", "INTEGER");
        columns.put("product_id", "INTEGER");
        columns.put("quantity", "INTEGER");
        columns.put("price", "FLOAT");
        columns.put("FOREIGN_KEYS", "FOREIGN KEY(order_id) REFERENCES orders(id), FOREIGN KEY(product_id) REFERENCES products(id)");
        return columns;
    }

    @Override
    public LinkedHashMap<String, String> columns() {
        return schema();
    }

    @Override
    public HashMap<String, Class<? extends DBHelper<?>>> relations() {
        HashMap<String, Class<? extends DBHelper<?>>> map = new HashMap<>();
        map.put("product", Product.class);
        map.put("order", Order.class);
        return map;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
