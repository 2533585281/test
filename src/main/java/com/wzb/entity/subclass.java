package com.wzb.entity;

/**
 * @Author Administrator
 * @Date 2021/10/28 0028
 */
public class subclass extends parent {
    private String address;
    private String phone;

    public subclass() {
    }

    public subclass(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public subclass(String name, String age, String address, String phone) {
        super(name, age);
        this.address = address;
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "subclass{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
