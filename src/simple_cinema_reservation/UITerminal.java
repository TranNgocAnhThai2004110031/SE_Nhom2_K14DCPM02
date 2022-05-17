package simple_cinema_reservation;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UITerminal {
    private String prompt;
    private String command;

    private Account accObj = new Account();

    public static Scanner sc = new Scanner(System.in);

    public void display_options() {
        accObj.accounts.read();
        accObj.accounts.update();
        int luaChon;
        do {
            System.out.println("\n\t-------------------------------- Menu --------------------------------");
            System.out.println("\t1. Đăng nhập.");
            System.out.println("\t2. Đăng xuất.");
            System.out.println("\t3. Tạo tài khoản.");
            System.out.println("\t4. Xem ds account");
            System.out.println("\t5. Tim kiem mot account");
            System.out.println("\t0. Thoát.");
            System.out.println("\t------------------------------------------------------------------------");
            System.out.print("\n- Vui lòng nhập lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    login_inputs();
                    break;
                case 2:
                    accObj.logout();
                    break;
                case 3:
                    create_account_inputs();
                    break;
                case 4:
                    accObj.accounts.get_all();
                    break;
                case 5:
                    accObj.accounts.search();
                    break;
                default:
                    break;
            }
        } while (luaChon != 0);
        accObj.accounts.write();     
        
    }

    // public void handle_command() {
        
    // }

    // public void handle_inputs() {
        
    // }
    
    // public String getPrompt() {
    //     return prompt;
    // }

    public void login_inputs() {
        System.out.print("User Name: ");
        String un = sc.nextLine();
        System.out.print("Password: "); 
        int ps = 0;
        try {
            ps = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Password chỉ bao gồm chữ!!!!!");
            e.printStackTrace();
        }
        sc.nextLine();
        accObj.login(un, ps);      
    }

    public void create_account_inputs() {
        System.out.print("User Name: ");
        String un = sc.nextLine();
        System.out.print("Password: ");
        int ps = 0;
        try {
            ps = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Password chỉ bao gồm chữ!!!!!");
            e.printStackTrace();
        }
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        accObj.account_valid(un, email);
        accObj.create_account(un, ps, email);         
    }

    /* public void create_bait(){
        Account account = new Account();
        Account account2 = new Account();
        Account account3= new Account();
        Account account4= new Account();
         
        account.create_account("LVTT", 123456, "LVTT@gmail.com");
        account2.create_account("QQQQ", 654321, "QQQQ@gmail.com");
        account3.create_account("RRRR", 135246, "RRRR@gmail.com");
        account4.create_account("OOOO", 135246, "OOOO@gmail.com");
         
       accObj.accounts.list.add(account);
       accObj.accounts.list.add(account2);
       accObj.accounts.list.add(account3);
       accObj.accounts.list.add(account4);
    } */
}
