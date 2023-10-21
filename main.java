import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
      FileInputStream fin = null;
      FileOutputStream fileoutput = null;

      //standart
      try{
        
        fin = new FileInputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\input.txt");    
        int i=0;
        while((i=fin.read())!=-1){
        System.out.print((char)i);
        }
        fin.close();
      }catch(Exception e){System.out.println(e);}



        try{
        //buka file
        fin = new FileInputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\input2.txt");    
        fileoutput = new FileOutputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\output.txt");
        
        //baca file
        int buffer = fin.read();
        //fileoutput.write(buffered) = nulis file
        while(buffer!=-1){
          fileoutput.write(buffer);
          buffer = fin.read();
        }

      } finally{
          if(fin != null){
            fin.close();
          }
          if(fileoutput != null){
            fileoutput.close();
          }
        }


        //try with resource
        try(FileInputStream file = new FileInputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\input3.txt");
        FileOutputStream out = new FileOutputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\output.txt")){
          int data = file.read();
          while(data!=-1){
          System.out.println((char)data);
          out.write(data);
          data = file.read();
        }
        }
    
        //charstream (untuk penulisan selain latin)
        try{
        FileReader file = new FileReader("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\input4.txt");   
        FileWriter CHARFILE = new FileWriter("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\output2.txt");
        int j=file.read();
        while(j!=-1){
        System.out.print((char)j);
        CHARFILE.write(j);
        j = file.read();
        }
        file.close();
        CHARFILE.close();
      }catch(Exception e){
        System.out.println(e);
      }
      
      //buffered bytestream(lebih efisien dr bytestream biasa)
      try{
        
        fin = new FileInputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\ipbuff.txt");    
        int i=0;
        //ngitung berapa banyak karakter: System.out.println(fin.available());
        //ngitung waktu baca:
        //long waktu_start = System.nanoTime();
        //System.out.println(fin.readAllBytes());
        //long waktu_finish = System.nanoTime();
        //System.out.println(waktu_finish - waktu_start);

        //memasukan file input ke buffered :
        BufferedInputStream a = new BufferedInputStream(fin);
        a.mark(1000);
        System.out.println(a.readAllBytes());

        //baca ulang
        a.reset();
        byte[] data = a.readAllBytes();
        String datas= new String(data);
        System.out.println(datas);

        //menulis dengan buffered output
        FileOutputStream files = new FileOutputStream("C:\\Users\\user\\OneDrive\\Documents\\proyek DH\\java\\proyek_java_dh\\src\\opbuffered.txt");
        BufferedOutputStream buff = new BufferedOutputStream(files);

        //write data berupa byte
        buff.write(data,0,data.length);
        buff.flush();

        a.close();
        buff.close();
        fin.close();
        files.close();
      }catch(Exception e){System.out.println(e);}

      
      
    }  }
