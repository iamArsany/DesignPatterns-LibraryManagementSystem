package com.library.approval;

public class Director extends BaseApprover {
    @Override
    public void approve(int days) {
        if (days > 14) {
            System.out.println("Director: Approved borrowing for " + days + " days.");
        } else {
            System.out.println("No authority to approve this request.");
        }
    }
}
