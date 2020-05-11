package assignment6master.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "accountHolder", catalog = "merit111")
public class AccountHolder implements Comparable<AccountHolder> {
	// Variables of Class
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "holder_id")
    private long id;
	
	@NotBlank(message = "First name required")
    private String firstName;
	
    private String middleName;
    
    @NotBlank(message = "Last name required")
    private String lastName;
    
    @NotBlank(message = "Social required")
    private String ssn;
    
    //private CheckingAccount checking[] = new CheckingAccount[1];
    //private SavingsAccount savings[] = new SavingsAccount[1];
    //private CDAccount cdAccount[] = new CDAccount[1];
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "holder_id", referencedColumnName = "holder_id")
    private List<CheckingAccount> checkingAccountsList;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "holder_id", referencedColumnName = "holder_id")
    private List<SavingsAccount> savingsAccountsList;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "holder_id", referencedColumnName = "holder_id")
    private List<CDAccount> cdAccountsList;

	// Constructors
    public AccountHolder() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.ssn = "";
        this.savingsAccountsList = new ArrayList<>();
        this.checkingAccountsList = new ArrayList<>();
        this.cdAccountsList = new ArrayList<>();
    }

    public AccountHolder(String fn, String mn, String ln, String sn){
        this.firstName = fn;
        this.middleName = mn;
        this.lastName = ln;
        this.ssn = sn;
    }

    // Setters and Getters
    public void setFirstName(String fn){
        this.firstName = fn;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setMiddleName(String mn){
        this.middleName = mn;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public void setLastName(String ln){
        this.lastName = ln;
    }

    public String getLastName(){
        return this.lastName;
    }
    
    public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<CheckingAccount> getCheckingAccountsList() {
		return checkingAccountsList;
	}

	public void setCheckingAccountsList(List<CheckingAccount> checkingAccountsList) {
		this.checkingAccountsList = checkingAccountsList;
	}
	
	public List<SavingsAccount> getSavingsAccountsList() {
		return savingsAccountsList;
	}

	public void setSavingsAccountsList(List<SavingsAccount> savingsAccountsList) {
		this.savingsAccountsList = savingsAccountsList;
	}
	
	public List<CDAccount> getCdAccountsList() {
		return cdAccountsList;
	}

	public void setCdAccountsList(List<CDAccount> cdAccountsList) {
		this.cdAccountsList = cdAccountsList;
	}
	

    // Methods

    /* ******************************************
     *********************************************
     * Code from Assignment 2
     *********************************************
     *********************************************
     */


	/*public CheckingAccount[] getChecking() {
		return checking;
	}

	public void setChecking(CheckingAccount[] checking) {
		this.checking = checking;
	}

	public SavingsAccount[] getSavings() {
		return savings;
	}

	public void setSavings(SavingsAccount[] savings) {
		this.savings = savings;
	}

	public CDAccount[] getCdAccount() {
		return cdAccount;
	}

	public void setCdAccount(CDAccount[] cdAccount) {
		this.cdAccount = cdAccount;
	}
	*/
	
	public void addCheckingToList(CheckingAccount checking) {
		this.checkingAccountsList.add(checking);
	}
	
	public void addSavingsToList(SavingsAccount savings) {
		this.savingsAccountsList.add(savings);
	}
	
	public void addCDAccountToList(CDAccount cdaccount) {
		this.cdAccountsList.add(cdaccount);
	}

	/*public CheckingAccount addCheckingAccount(double checkingB) {
    	try {
    		if (checkingB < 0) {
            	throw new NegativeAmountException("Please provide a positive amount.");
            }
    	} catch (NegativeAmountException e) {
    		System.out.println(e);
    		return null;
    	}
    	
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = checkingB;
        tBalance = tChecking + tSaving + testAdd;
        
        try {
        	if (tBalance > 250000){
                throw new ExceedsCombinedBalanceLimitException("Fund limit reached. Try again later.");
            } else {
                checking[checking.length - 1] = new CheckingAccount(checkingB);
                CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
                for(int x = 0; x < checking.length; x++) {
                	arrayTemp[x] = checking[x];
                }
                checking = arrayTemp;
                    
                if (checkingB > 1000) {
                	java.util.Date fDate = new java.util.Date();
            		DepositTransaction newTrans = new DepositTransaction(-1, checking[checking.length - 2].getAccountNumber(), checkingB, fDate);
            		FraudQueue.addTransaction(newTrans);
            		throw new ExceedsFraudSuspicionLimitException("Transaction requires review, thanks for your patience.");
                }
                
                return checking[checking.length - 2];
            }
        } catch(ExceedsCombinedBalanceLimitException e) {
        	System.out.println(e);
        	return null;
        } catch(ExceedsFraudSuspicionLimitException e) {
        	System.out.println(e);
        	return checking[checking.length - 2];
        }
    }
    */

    /*public CheckingAccount addCheckingAccount(CheckingAccount checkingAccountX) {
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = checkingAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        try {
        	if (tBalance > 250000){
                throw new ExceedsCombinedBalanceLimitException("Fund limit reached. Try again later.");
        } else {
            checking[checking.length - 1] = checkingAccountX;
            CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
            for(int x = 0; x < checking.length; x++) {
            	arrayTemp[x] = checking[x];
            }
            checking = arrayTemp;
            return checking[checking.length - 2];
        }
        } catch(ExceedsCombinedBalanceLimitException e) {
        	return checking[checking.length - 2];
        }
               
    }
    */

	/*
    public CheckingAccount[] getCheckingAccounts(){
        return this.checking;
    }
    
    */

    public int getNumberOfCheckingAccounts(){
        return this.checkingAccountsList.size();
    }

	/*
    public double getCheckingBalance(){
        double tBalance = 0;
        for(int x = 0; x < checking.length - 1; x++){
            tBalance += checking[x].getBalance();
        }
        return tBalance;
    }
    */
    
    public double getCheckingBalanceFromList() {
    	double tBalance = 0;
    	for(int x = 0; x < checkingAccountsList.size(); x++) {
    		tBalance += checkingAccountsList.get(x).getBalance();
    	}
    	return tBalance;
    }

    /*
    public SavingsAccount addSavingsAccount(double openingBalance) {
    	try {
    		if (openingBalance < 0) {
            	throw new NegativeAmountException("Please provide a positive amount.");
            }
    	} catch (NegativeAmountException e) {
    		System.out.println(e);
    	}
    	
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = openingBalance;
        tBalance = tChecking + tSaving + testAdd;
        try {
        	if (tBalance > 250000){
                throw new ExceedsCombinedBalanceLimitException("Too much Funds In Account. Reached Limit.");
            } else {
            	savings[savings.length - 1] = new SavingsAccount(openingBalance);
                SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
                for(int x = 0; x < savings.length; x++) {
                	arrayTemp[x] = savings[x];
                }
                savings = arrayTemp;
                    
                if (openingBalance > 1000) {
                	java.util.Date fDate = new java.util.Date();
    		        DepositTransaction newTrans = new DepositTransaction(-1, savings[savings.length - 2].getAccountNumber(), openingBalance, fDate);
    		        FraudQueue.addTransaction(newTrans);
                    throw new ExceedsFraudSuspicionLimitException("Transaction requires review, thanks for your patience.");
                }
                return savings[savings.length - 2];
            }
        } catch (ExceedsCombinedBalanceLimitException e) {
        	System.out.println(e);
        	return null;
        } catch (ExceedsFraudSuspicionLimitException e) {
        	System.out.println(e);
        	return savings[savings.length - 2];
        }
        
    }
    
    */
    
    /*

    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccountX) {
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = savingsAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        try {
        	if (tBalance > 250000){
            	throw new ExceedsCombinedBalanceLimitException("Too much Funds In Account. Reached Limit.");
            } else {
            	savings[savings.length - 1] = savingsAccountX;
                SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
                for(int x = 0; x < savings.length; x++) {
                	arrayTemp[x] = savings[x];
                }
                savings = arrayTemp;
                return savings[savings.length - 2];
            }
        } catch(ExceedsCombinedBalanceLimitException e) {
        	System.out.println(e);
        }
        return null;
    }
    
    */
    
    /*

    public SavingsAccount[] getSavingsAccounts(){
        return this.savings;
    }
    
    */

    public int getNumberOfSavingsAccounts(){
        return this.savingsAccountsList.size();
    }

    /*
    public double getSavingsBalance(){
        double tBalance = 0;
        for(int x = 0; x < savings.length - 1; x++){
            tBalance += savings[x].getBalance();
        }
        return tBalance;
    }
    */
    
    public double getSavingsBalanceFromList() {
    	double tBalance = 0;
    	for(int x = 0; x < savingsAccountsList.size(); x++) {
    		tBalance += savingsAccountsList.get(x).getBalance();
    	}
    	return tBalance;
    }
    
    /*

    public CDAccount addCDAccount(CDOffering offering, double openingBalance) throws ExceedsFraudSuspicionLimitException, NegativeAmountException {
    	
    	if (openingBalance < 0) {
        	throw new NegativeAmountException("Please provide a positive amount.");
        }
    	 
        cdAccount[cdAccount.length - 1] = new CDAccount(offering, openingBalance);
        CDAccount arrayTemp[] = new CDAccount[cdAccount.length + 1];
        for(int x = 0; x < cdAccount.length; x++) {
        	arrayTemp[x] = cdAccount[x];
        }
        cdAccount = arrayTemp;
        
        
    	if (openingBalance > 1000) {
    		java.util.Date fDate = new java.util.Date();
	        DepositTransaction newTrans = new DepositTransaction(-1, cdAccount[cdAccount.length - 2].getAccountNumber(), openingBalance, fDate);
	        FraudQueue.addTransaction(newTrans);
        	throw new ExceedsFraudSuspicionLimitException("Transaction requires review, thanks for your patience.");
    	}
    	 
        return cdAccount[cdAccount.length - 2];
    	
    }
    
    */
    
    /*

    public CDAccount addCDAccount(CDAccount cdAccountX) {
        if(cdAccount.equals(null)){
            System.out.println("Unable to Complete Action, Null CD Offer.");
            return null;
        }
        cdAccount[cdAccount.length - 1] = cdAccountX;
        CDAccount arrayTemp[] = new CDAccount[cdAccount.length + 1];
        for(int x = 0; x < cdAccount.length; x++) {
        	arrayTemp[x] = cdAccount[x];
        }
        cdAccount = arrayTemp;
        return this.cdAccount[cdAccount.length - 2];
    }
    */
    
    /*

    public CDAccount[] getCDAccounts(){
        return this.cdAccount;
    }
    
    */

    public int getNumberOfCDAccounts(){
        return this.cdAccountsList.size();
    }

    public double getCDAccountsBalanceFromList() {
    	double tBalance = 0;
    	for(int x = 0; x < cdAccountsList.size(); x++) {
    		tBalance += cdAccountsList.get(x).getBalance();
    	}
    	return tBalance;
    }

    public double getCombinedBalance(){
        double tBalance;
        tBalance = this.getCheckingBalanceFromList();
        tBalance += this.getSavingsBalanceFromList();
        tBalance += this.getCDAccountsBalanceFromList();
        return tBalance;
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("##.00");
        return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n"
                + "SSN: " + this.ssn + "\n";
    }
    
    @Override
    public int compareTo(AccountHolder otherAccount) {
    	if(this.getCombinedBalance() > otherAccount.getCombinedBalance()) {
    		return 1;
    	} else
    		return -1;
    }
}
