package edu.java.file12;

import java.io.File;

public class FileMain12 {

    public static void main(String[] args) {
        
        // data 폴더의 내용(하위 폴더, 파일들)을 출력
        File dataDir = new File("data"); // 상대 경로
        File[] files = dataDir.listFiles();
        System.out.println(files);
        
        for (File f : files) {
            String fileName = f.getName();
            String info = null;
            if (f.isFile()) { // 파일인 경우
                info = fileName + "\t" + f.length() + "bytes";
                
            } else { // 파일이 아닌 경우 (폴더인 경우)
                info = fileName + "\t" + "<DIR>";
            }
            System.out.println(info);
            
            
        } 
        
        // 폴더(디렉토리) 생성
        File newFolder = new File("data", "Temp"); // 상위 폴더, 하위 폴더(파일)
        if (newFolder.exists()) {
            System.out.println("폴더가 이미 존재...");
        } else {
            newFolder.mkdir(); // make directory
            System.out.println("새 폴더 생성");
        }
        
        // 폴더 삭제
        if(newFolder.exists()) {
            newFolder.delete();
            System.out.println("폴더 삭제 성공...");
        } else {
            System.out.println("삭제할 폴더가 없음...");
        }
        
    }

}
