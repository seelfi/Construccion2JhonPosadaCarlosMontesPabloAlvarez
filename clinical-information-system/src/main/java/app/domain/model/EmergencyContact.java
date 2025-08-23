package app.domain.model;

public class EmergencyContact {
    private String fullName;
    private String relationship;
    private String phone;

    public EmergencyContact(String fullName, String relationship, String phone) {
        this.fullName = fullName;
        this.relationship = relationship;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
