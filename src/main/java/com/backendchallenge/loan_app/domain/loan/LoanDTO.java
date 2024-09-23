package com.backendchallenge.loan_app.domain.loan;

public class LoanDTO {

    private String type;
    private Double interest_rate;

    public LoanDTO(){}

    public LoanDTO(String type, Double interest_rate) {
        this.type = type;
        this.interest_rate = interest_rate;
    }

    public LoanDTO(Loan loan){
        this.type = loan.getType();
        this.interest_rate = loan.getInterest_rate();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
    }
}
