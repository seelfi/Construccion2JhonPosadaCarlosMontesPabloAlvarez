package app.domain.model;

import java.time.LocalDate;

public class Invoice {
    private final Long invoiceId;
    private final ClinicalOrder order;
    private final LocalDate date;
    private  double totalPatient;
    private  double totalInsurance;
    private  double copayment;

    public Invoice(Long invoiceId, ClinicalOrder order, LocalDate date,double totalPatient, double totalInsurance, double copayment) {

        if (invoiceId == null) {
            throw new IllegalArgumentException("El ID de la factura no puede ser nulo.");
        }
        if (order == null) {
            throw new IllegalArgumentException("La orden clínica asociada no puede ser nula.");
        }
        if (date == null) {
            throw new IllegalArgumentException("La fecha de facturación no puede ser nula.");
        }
        if (totalPatient < 0 || totalInsurance < 0 || copayment < 0) {
            throw new IllegalArgumentException("Los montos no pueden ser negativos.");
        }

        this.invoiceId = invoiceId;
        this.order = order;
        this.date = date;
        this.totalPatient = totalPatient;
        this.totalInsurance = totalInsurance;
        this.copayment = copayment;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public ClinicalOrder getOrder() {
        return order;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalPatient() {
        return totalPatient;
    }

    public void setTotalPatient(double totalPatient) {
        this.totalPatient = totalPatient;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public void setTotalInsurance(double totalInsurance) {
        this.totalInsurance = totalInsurance;
    }

    public double getCopayment() {
        return copayment;
    }

    public void setCopayment(double copayment) {
        this.copayment = copayment;
    }
    public String getPatientName() {
        return order.getPatient().getFullName();
    }

    public String getPatientDocumentId() {
        return order.getPatient().getDocumentId();
    }

    public int getPatientAge() {
        return java.time.Period.between(order.getPatient().getBirthDate(), LocalDate.now()).getYears();
    }

    public String getDoctorName() {
        return order.getEmployee().getFullName();
    }

    public String getInsuranceCompanyName() {
        MedicalInsurance insurance = order.getPatient().getInsurance();
        return (insurance != null) ? insurance.getCompanyName() : "Sin seguro";
    }

    public String getInsurancePolicyNumber() {
        MedicalInsurance insurance = order.getPatient().getInsurance();
        return (insurance != null) ? insurance.getPolicyNumber() : "N/A";
    }

    public long getInsuranceRemainingDays() {
        MedicalInsurance insurance = order.getPatient().getInsurance();
        if (insurance == null) return 0;

        return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), insurance.getExpirationDate());
    }

    public LocalDate getInsuranceExpirationDate() {
        MedicalInsurance insurance = order.getPatient().getInsurance();
        return (insurance != null) ? insurance.getExpirationDate() : null;
    }

}


