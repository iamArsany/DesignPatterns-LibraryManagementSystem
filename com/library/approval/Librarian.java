package com.library.approval;

public class Librarian extends BaseApprover {
    @Override
    public void approve(int days) {
        if (days <= 7) {
            System.out.println("Librarian: Approved borrowing for " + days + " days.");
        } else if (nextApprover != null) {
            nextApprover.approve(days);
        }
    }
}
