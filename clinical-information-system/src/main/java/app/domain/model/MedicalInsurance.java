package app.domain.model;

import java.time.LocalDate;

public class MedicalInsurance {
    private String companyName;
    private String policyNumber;
    private boolean isActive;
    private LocalDate expirationDate;

    public MedicalInsurance(String companyName, String policyNumber, boolean isActive, LocalDate expirationDate) {
        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.isActive = isActive;
        this.expirationDate = expirationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
