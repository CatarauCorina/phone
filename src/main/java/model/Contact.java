package model;

import org.json.JSONObject;

/**
 * Created by cataraucorina on 23/08/2017.
 */
public class Contact {
    private String name;
    private String phone;
    private String address;

    public Contact(JSONObject contact) {
        this.name = contact.getString("name");
        this.phone = contact.getString("phone_number");
        this.address = contact.getString("address");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

