package com.example.view.checkDelete;

/**
 * Created by 20160903 on 2016/12/13.
 */

public class Checkes {
    private String name;
    private boolean isCheck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public Checkes(String name, boolean isCheck) {
        this.name = name;
        this.isCheck = isCheck;
    }
}
