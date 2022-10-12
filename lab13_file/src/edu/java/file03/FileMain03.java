package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {

    public static void main(String[] args) {
        
        // data/ratings.dat 파일을 읽고 ratings_copy.dat 파일에 복사
        // read(), write(int b)를 사용했을때
        // read(byte[] b), write(byte[] b, int off, int len)를 사용했을 때
        // 복사 시간의 차이를 비교.
        
        FileInputStream in = null;
        FileOutputStream out = null;
        
       
            try {
                in = new FileInputStream("data/ratings.dat");
                out = new FileOutputStream("data/ratings_copy.dat");
                
                long startTime = System.currentTimeMillis(); // 복사 시작 시간.
                
                while(true) {
                    
                    byte[] buffer = new byte[100]; // 20바이트를 저장할 수 있는 배열
                    int result = in.read(buffer); // 실제로 파일에서 읽은 데이터 개수(바이트 수)를 리턴.
                    if (result == -1) { // 파일 끝(EOF)에 도달하면
                        break; // while 종료
                    }
                    out.write(buffer, 0, result);
                    
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("파일 복사 종료 - " + elapsedTime + "ms");
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("1번째 파일 복사 완료");
            
            try {
                in = new FileInputStream("data/ratings.dat");
                out = new FileOutputStream("data/ratings_copy2"
                        + ".dat");
                
                long startTime = System.currentTimeMillis();
                
                while(true) {
                    int read = in.read(); // 읽기 - 파일에서 1바이트씩 읽음.
                  //  System.out.println(read + ":"+(char)read);
                    // read() 메서드는 파일 끝(EOF:end of file)에 도달했을 때 -1을 리턴.
                    if(read == -1) {
                        break; // 무한 루프 종료
                    }
                    
                    out.write(read); // 쓰기 - 파일에 1바이트씩 쓰기(write).  
                }
                
                // 파일 복사 종료 시간 측정
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime; // 복사하는 데 걸린 시간.
                
                System.out.println("파일 복사 성공 - " + elapsedTime + "ms");
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 예외가 발생하지 않아도 (try 블록이 정상적으로 끝났을 때),
                // 예외가 발생하더라도 (catch 블록이 실행됐을 때)
                // 열려져 있는 FIS, FOS 객체는 닫아야 함!!
                try {
                    in.close(); // FileInputStream 객체 close
                    out.close(); // FileOutputStream 객체 close
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
     
        
    }

}
