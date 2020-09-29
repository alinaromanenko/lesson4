package lesson4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVparser {
    private File file;


    CSVparser(String filename){
        this.file = new File(filename);
    }

    public Map<String, String[]> reader() throws IOException {
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        Map<String, String[]> users = new HashMap<String, String[]>();
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(",");
            users.put(line[0], new String[]{line[1], line[2], line[3]});
        }
        fr.close();
        return users;
    }

    void writer(String email, String password, Person person) throws IOException {
            FileWriter fw = new FileWriter(file);
            fw.write(email+","+password+","+person.getName()+","+person.getBirthday()+"\n");
            System.out.println("Otrabotala");
            fw.close();
        }
}
