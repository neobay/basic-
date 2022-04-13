package package_35;

import java.util.ArrayList;
import java.util.Scanner;

public class bai35_2 {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("====================MENU====================");
            System.out.println("1. Them moi mot tai khoan.");
            System.out.println("2. Hien thi thong tin tai khoan.");
            System.out.println("3. Nap tien vao tai khoan.");
            System.out.println("4. Rut tien khoi tai khoan.");
            System.out.println("5. Chuyen tien.");
            System.out.println("6. Tim tai khoan theo ten.");
            System.out.println("7. Tim tai khoan theo ma.");
            System.out.println("8. Tim tai khoan co so du >= x.");
            System.out.println("9. Xoa mot tai khoan theo ma.");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Yeu cau cua ban la: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Xin chao va hen gap lai!");
                    break;
                case 1:
                    BankAccount acc = createNewAcc(input);
                    accounts.add(acc);
                    System.out.println("Them thanh cong!");
                    break;
                case 2:
                    showAccounts(accounts);
                    break;
                case 3:
                    if (accounts.size() > 0){
                        System.out.print("Nhap ma TK can nap: ");
                        var id = input.next();
                        System.out.print("Nhap so tien can nap: ");
                        var amount = input.nextLong();
                        var isSuccess = deposit(accounts, id, amount);
                        if (isSuccess){
                            System.out.println("Nap tien thanh cong!");
                        }else {
                            System.out.println("TK khong hop le hoac so tien khong hop le");
                        }
                    }else {
                        System.out.println("Danh sach tai khoan rong");
                    }
                    break;
                case 4:
                    if (accounts.size() > 0){
                        System.out.print("Nhap so TK can rut: ");
                        var id = input.next();
                        System.out.print("Nhap so tien can rut: ");
                        long amount = input.nextLong();
                        boolean isSucess = withdraw(accounts, amount, id);
                        if (isSucess){
                            System.out.println("Rut tien thanh cong!");
                        }else {
                            System.out.println("Sai ma TK hoac so tien khong hop le");
                        }
                    }else {
                        System.out.println("Danh sach tai khoan rong!");
                    }
                    break;
                case 5:
                    if (accounts.size() > 0){
                        System.out.print("Nhap so TK nguon: ");
                        var srcId = input.next();
                        System.out.print("Nhap so TK dich: ");
                        var desId = input.next();
                        System.out.print("Nhap so tien can chuyen: ");
                        long amount = input.nextLong();
                        var isSuccess = bankTransfer(accounts, srcId, desId, amount);
                        if (isSuccess){
                            System.out.println("Chuyen tien thanh cong!");
                        }else {
                            System.out.println("That bai!" + "Sai TK\nHoac so tien khong hop le");
                        }
                    }else {
                        System.out.println("Danh sach rong!");
                    }
                    break;
                case 6:
                    if (accounts.size() > 0){
                        var name = "";
                        System.out.print("Nhap ten can tim: ");
                        name = input.next();
                        var result = searchAccByName(accounts, name);
                        if (result.size() > 0){
                            System.out.println("Tim thay " + result.size() + " ket qua");
                            showAccounts(result);
                        }else {
                            System.out.println("Khong tim thay ket qua nao ten \""
                            + name + "\"");
                        }
                    }else {
                        System.out.println("Danh sach tai khoan rong!");
                    }
                    break;
                case 7:
                    if (accounts.size() > 0){
                        var id= "";
                        System.out.print("Nhap ma TK can tim: ");
                        id = input.next();
                        var result = searchAccById(accounts, id);
                        if (result != null){
                            System.out.println("==>Tim thay tai khoan ma \""
                            + id + "\"");
                            showAcc(result);
                        }else {
                            System.out.println("Khong tim thay TK");
                        }
                    }else {
                        System.out.println("Danh sach tai khoan rong!");
                    }
                    break;
                case 8:
                    if (accounts.size() > 0){
                        System.out.print("Nhap vao so du: ");
                        long balance = input.nextLong();
                        var result = searchAccByBalance(accounts, balance);
                        if (result != null){
                            System.out.println("Tim thay " + result.size() +
                                    "TK co so du >= " + balance);
                            showAccounts(result);
                        }else {
                            System.out.println("Khong tim thay TK");
                        }
                    }else {
                        System.out.println("Danh sach tai khoan rong!");
                    }
                    break;
                case 9:
                    if (accounts.size() > 0){
                        var id = "";
                        System.out.print("Nhap ma TK can xoa; ");
                        id = input.next();
                        var isDeleted = removeAccbyId(accounts, id);
                        if (isDeleted){
                            System.out.println("Xoa thanh cong!");
                        }else {
                            System.out.println("Ma TK khong hop le");
                        }
                    }else {
                        System.out.println("Danh sach rong!");
                    }
                    break;
            }
        } while (choice != 0);
    }

    private static boolean removeAccbyId(ArrayList<BankAccount> accounts, String id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().compareTo(id) == 0){
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<BankAccount> searchAccByBalance(ArrayList<BankAccount> accounts, long balance) {
        ArrayList<BankAccount> res = new ArrayList<>();
        for (var acc: accounts) {
            if (acc.getBalance() >= balance){
                res.add(acc);
            }
        }
        return res;
    }

    private static ArrayList<BankAccount> searchAccByName(ArrayList<BankAccount> accounts, String name) {
        ArrayList<BankAccount> res = new ArrayList<>();
        for (var acc: accounts) {
            if (acc.getOwner().toLowerCase().matches(".*" + name + ".*")){
                res.add(acc);
            }
        }
        return res;
    }

    private static boolean bankTransfer(ArrayList<BankAccount> accounts, String srcId, String desId, long amount) {
        var srcAcc = searchAccById(accounts, srcId);
        var desAcc = searchAccById(accounts, desId);
        if (srcAcc != null && desAcc != null){
            return srcAcc.bankTransfer(desAcc, amount);
        }
        return false;
    }

    private static boolean withdraw(ArrayList<BankAccount> accounts, long amount, String id) {
        var acc = searchAccById(accounts, id);
        if (acc != null){
            return acc.withdraw(amount);
        }
        return false;
    }

    private static boolean deposit(ArrayList<BankAccount> accounts, String id, long amount) {
        var acc = searchAccById(accounts, id);
        if (acc != null){
            return acc.deposit(amount);
        }
        return false;
    }

    private static BankAccount searchAccById(ArrayList<BankAccount> accounts, String id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().compareToIgnoreCase(id) == 0){
                return accounts.get(i);
            }
        }
        return null;
    }

    private static void showAccounts(ArrayList<BankAccount> accounts) {
        if (accounts.size() > 0){
            System.out.println("===>Danh sach tai khoan");
            System.out.printf("%-12s%-15s%-25s%-15s%-15s%-20s%-15s%-15s\n",
                    "Ma TK", "So TK", "Ten TK", "Loai TK",
                    "So du", "Ngan hang", "Ngay PH", "Ngay KT");
            for (var acc: accounts) {
                showAcc(acc);
            }
        }else {
            System.out.println("Danh sach trong!");
        }
    }

    private static void showAcc(BankAccount acc) {
        System.out.printf("%-12s%-15s%-25s%-15s%-15s%-20s%-15s%-15s\n",
                acc.getId(), acc.getAccNumber(), acc.getOwner(), acc.getType(),
                acc.getBalance(), acc.getBankName(), acc.getStartDay(), acc.getEndDay());
    }

    private static BankAccount createNewAcc(Scanner input) {
        System.out.print("Nhap vao id: ");
        var id = input.nextLine();
        System.out.print("Nhap vao so tai khoan: ");
        var accNumber = input.nextLine();
        System.out.print("Nhap ten chu tai khoan: ");
        var owner = input.nextLine();
        System.out.print("Nhap loai tai khoan: ");
        var type = input.nextLine();
        System.out.print("Nhap so du: ");
        var balance = input.nextLong();
        input.nextLine();
        System.out.print("Nhap ten ngan hang: ");
        var bankName = input.nextLine();
        System.out.print("Ngay mo tai khoan: ");
        var startDay = input.nextLine();
        System.out.print("Ngay het han: ");
        var endDay = input.nextLine();
        return new BankAccount(id, accNumber, owner, type, balance, bankName, startDay, endDay);
    }
}
