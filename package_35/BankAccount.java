package package_35;

public class BankAccount {
    private String id;
    private String accNumber;
    private String owner;
    private String type;
    private long balance;
    private String bankName;
    private String startDay;
    private String endDay;


    public BankAccount() {
        id = "";
        accNumber = "";
        owner = "";
        type = "";
        balance = 0;
        bankName = "";
        startDay = "";
        endDay = "";
    }

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(String id, String accNumber) {
        this(id);
        this.accNumber = accNumber;
    }

    public BankAccount(String id, String accNumber, String owner) {
        this(id, accNumber);
        this.owner = owner;
    }

    public BankAccount(String id, String accNumber, String owner, String type) {
        this(id, accNumber, owner);
        this.type = type;
    }

    public BankAccount(String id, String accNumber, String owner, String type, long balance) {
        this(id, accNumber, owner, type);
        this.balance = balance;
    }

    public BankAccount(String id, String accNumber, String owner, String type, long balance, String bankName) {
        this(id, accNumber, owner, type, balance);
        this.bankName = bankName;
    }

    public BankAccount(String id, String accNumber, String owner, String type, long balance, String bankName, String startDay) {
        this(id, accNumber, owner, type, balance, bankName);
        this.startDay = startDay;
    }

    public BankAccount(String id, String accNumber, String owner, String type, long balance, String bankName, String startDay, String endDay) {
        this(id, accNumber, owner, type, balance, bankName, startDay);
        this.endDay = endDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public boolean deposit(long amount){
        if (amount > 0){
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(long amount){
        if (amount < balance && amount > 0){
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean bankTransfer(BankAccount other, long amount){
        if (amount < balance && amount > 0){
            balance -= amount;
            other.balance += amount;
            return true;
        }
        return false;
    }

    public void checkBalance(){
        System.out.println("Balance: " + balance);
    }

    public boolean pay(String service, long amount){
        if (!service.isEmpty() && amount < balance && amount > 0){
            balance -= amount;
            return true;
        }
        return false;
    }
}
