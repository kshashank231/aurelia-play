package models;

import org.bson.types.ObjectId;




public class Employee  {
    private ObjectId _id;
    private String eid;
    private String name;
    private String email;
    private long phone;

    public ObjectId getId() {
        return _id;
    }


    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getEid() {
        return eid;
    }


    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
