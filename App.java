import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException{
        FileReader fin = null;
        FileWriter fileoutput = null;
        //standart
        try{
    
        fin = new FileReader("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\input.txt");    
        BufferedReader a = new BufferedReader(fin);
        a.mark(500);

        String data = a.readLine();
        System.out.println(data);
        
        //baca dalem char
        a.reset();
        char[] datachar = new char[100];
        a.read(datachar,0,100);
        System.out.println(Arrays.toString(datachar));

        //baca perbaris
        a.reset();
        System.out.println(a.readLine());
        System.out.println(a.readLine());

        fileoutput = new FileWriter("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\output.txt");
        BufferedWriter buff = new BufferedWriter(fileoutput);

        a.reset();
        String baris1 = a.readLine();
        buff.write(baris1,0,baris1.length());
        buff.flush();

        //enter
        buff.newLine();

        String baris2 = a.readLine();
        buff.write(baris2, 0, baris2.length());
        buff.flush();

        fin.close();
        fileoutput.close();
        a.close();
        buff.close();
        }catch(Exception e){System.out.println(e);}
  
    
    }  }

