package simple_cinema_reservation;
public class Account {
    private String username;
    private int password;
    private String email;
    private boolean loggedin;

    public static StoredFiles accounts = new StoredFiles("data.json");

    public Account() {
    }

    public Account(String username, int password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(String username, int password, String email, boolean loggedin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedin = loggedin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void set_account(String un, int ps) {
        this.username = un;
        this.password = ps;
    }

    public void login(String un, int ps) {
        check_loggedin(un, ps);
        if (this.loggedin == true) {
            System.out.println("Đăng nhập thành công.");
            this.loggedin = false;
        } else {
            System.out.println("Đăng nhập thất bại!!!!!");
            System.out.println("Bạn đã nhập sai username hoặc password.");
        }
    }

    public void logout() {
        this.username = null;
        this.password = 0;
        this.loggedin = false;
        System.out.println("Đăng xuất thành công.");
    }

    public void create_account(String un, int ps, String email) {
        this.username = un;
        this.password = ps;
        this.email = email; 

        Account account = new Account(un, ps, email);
        accounts.list.add(account);
        
    }

    public void account_valid(String un, String email) { // xác minh tài khoản trước khi tạo
        for (Account account : accounts.list) {
            if (un.equals(account.getUsername())) {
                System.out.println("Username đã được sử dụng.");
                System.out.println("Tạo tài khoản thất bại!!!.");
                return;
            } else if (email.equals(account.getEmail())) {
                System.out.println("Email đã được sử dụng.");
                System.out.println("Tạo tài khoản thất bại!!!.");
                return;
            } 
            // else if (account.loggedin == true) {
            //     System.out.println("Bạn phải đăng xuất trước khi tạo tài khoản mới!!!.");
            //     return;
            // } 
        }
    }

    public boolean check_loggedin(String un, int ps) {
        for (Account account : accounts.list) {
            if (account.getUsername().equals(un) && account.getPassword() == ps) {
                loggedin = true;
            } 
        }
        
        return loggedin;
    }

    @Override
    public String toString() {
        return "Account [email=" + email + ", loggedin=" + loggedin + ", password=" + password + ", username="
                + username + "]";
    }

    
}
