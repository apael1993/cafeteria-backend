package com.soso.model;

/**
 * Created by Anushavan on 3/18/17.
 */
public class OrderDetail {

    private Integer count;
    private Dish dish;

    public OrderDetail() { }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

}
