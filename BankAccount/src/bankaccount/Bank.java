/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

public class Bank {
    public void NewAccount(Account account_) {
        account = account_;
    }
    public Account getAccount() {
        return account;
    }

    private Account account; 
}
