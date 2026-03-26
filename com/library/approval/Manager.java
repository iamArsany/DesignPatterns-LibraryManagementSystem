package com.library.approval;

public class Manager extends BaseApprover {
    @Override
    public void approve(int days) {
        if (days <= 14) {
            System.out.println("Manager: Approved borrowing for " + days + " days.");
        } else if (nextApprover != null) {
            nextApprover.approve(days);
        }
    }
}
