package app.domain.model;

import java.time.LocalDate;

public class MedicalInsurance {
    private final String companyName;
    private final String policyNumber;
    private final boolean isActive;
    private final LocalDate expirationDate;

    public MedicalInsurance(String companyName, String policyNumber, boolean isActive, LocalDate expirationDate) {
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("El nombre de la compañía de seguros no puede estar vacío.");
        }
        if (policyNumber == null || policyNumber.isBlank()) {
            throw new IllegalArgumentException("El número de póliza no puede estar vacío.");
        }
        if (expirationDate == null) {
            throw new IllegalArgumentException("La fecha de expiración no puede ser nula.");
        }
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de expiración no puede estar en el pasado.");
        }

        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.isActive = isActive;
        this.expirationDate = expirationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isValid() {
        return isActive && !isExpired();
    }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}


