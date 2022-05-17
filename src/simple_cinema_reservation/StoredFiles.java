package simple_cinema_reservation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StoredFiles {
    private String stored_file;

    private List<Account> memory = new ArrayList<>();
    List<Account> list = new ArrayList<>(memory);

    public StoredFiles() {
    }

    public StoredFiles(String stored_file) {
        this.stored_file = stored_file;
    }

    public void read(){
        try {
            Gson gson = new Gson();
            
            Reader reader = Files.newBufferedReader(Paths.get("data.json"));
            
            memory = Arrays.asList(gson.fromJson(reader, Account[].class));
        
            for (Account account : memory) {
                System.out.println(account);
            }
        
            reader.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // read file cách 2
        // File file = new File("data.json");
        
        // try {
        //     InputStream inputStream = new FileInputStream(file);
        //     InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //     BufferedReader reader = new BufferedReader(inputStreamReader);
    
        //     String line = "";

        //     while((line = reader.readLine()) != null){
        //         System.out.println(line);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }    

    public void write() {
        //dạng file json in ra đẹp hơn
        GsonBuilder gsonBuilder = new GsonBuilder(); 
        Gson gson = gsonBuilder.create();
        
        try(Writer writer = Files.newBufferedWriter(Paths.get("data.json"))){
            gsonBuilder.setPrettyPrinting().create().toJson(list, writer);
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        //  ghi file của thầy
        // Gson gson = new Gson();
        // try(FileWriter fileWriter = new FileWriter("data.json")) {
        //     gson.toJson(list, fileWriter);
        //     fileWriter.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    public void update() {
        for(Account a : memory){
            list.add(a);
        }
    }

    public void get_all() {
        System.out.println(list);
    }    
     
    public void search() {
        Account account1 = null;
        System.out.print("Nhập username hoặc email account bạn cần tìm: ");
        String searched = UITerminal.sc.nextLine();
        System.out.println("Account tìm được: ");
        for(Account account:list){
            if(account.getUsername().equalsIgnoreCase(searched) || account.getEmail().equals(searched)){
                account1 = account;
                System.out.println(account1);
            }
        }
        if (account1 == null) {
            System.out.println("Không có username hoặc email account bạn cần tìm!!!");
        } 
    }
}
