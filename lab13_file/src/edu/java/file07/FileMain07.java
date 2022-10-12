package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        
        ArrayList<Product> productList = new ArrayList<>(); //Product를 저장하는 ArrayList
        
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성하고 ArrayList에 저장.
        for (int i = 0; i < 1_000_000; i ++) {
            Product p = new Product(i, "Name_"+ i, i);
            productList.add(p);
            // 위에 두 줄 대신에
            // productList.add(new Product(i, "Name_"+i, i)) -> 이런식으로도 가능하다.
        }
        
        System.out.println(productList.size());
        System.out.println(productList.get(999_999));
        
        String fileName = "data/product_list.dat";
        
        // ArrayList의 내용을 product_list.dat 파일에 write - 시간 측정.
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        ObjectOutputStream oout = null;
        
        try {
            out = new FileOutputStream(fileName);
            bout = new BufferedOutputStream(out);
            oout = new ObjectOutputStream(bout);
            
            long start = System.currentTimeMillis(); // write 시작 시간
            
            oout.writeObject(productList); // 100만 개 원소를 갖는 리스트를 파일에 write
            
            long end = System.currentTimeMillis(); // write 끝나는 시간
            long elapsed = end - start;
            
            System.out.println("파일 작성 성공: " +elapsed+ "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.
        try (
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
                ){
            long start = System.currentTimeMillis(); // 읽기 시작 시간
            
            ArrayList<Product> list = (ArrayList<Product>)oin.readObject(); //(ArrayList<Product>) 붙인 이유는 type 변환을 위해서
            
            long end = System.currentTimeMillis(); // 읽기 종료 시간
            
            long elapsed = end - start; //경과 시간
            
            System.out.println("파일 읽기 성공: " +elapsed + "ms");
            
            // 잘 읽었나 확인해 볼려면
            System.out.println(list.size());
            System.out.println(list.get(999)); // 다 확인은 못하지만 하나 정도는 확인해보자.
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } // finally 가 필요가 없어, 자동으로 파일이 close 되는것이 보장되니까, try(안에서). 다 가능한 것은 아니고 closeable 메서드이어야.
        
    }

}
