package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {
    
    public static void main (String[] args) {
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", "CSS", 
                "JavaScript", "Servlet", "JSP", "Spring", "Python");
                
      
        // 리스트 languages에서 5글자 이상임 문자열만 저장하는 리스트를 만들고 출력.
        List<String> longWords = new ArrayList<>(); // 다형성, 즉 ArrayList는 List다!
        
        for (String s : languages) {
            if (s.length() >= 5) {
                longWords.add(s);
            }
        }

        System.out.println(longWords);
        
        // Iterator<E> 사용:
        List<String> longWords2 = new ArrayList<>();
        Iterator<String> itr = languages.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            if (s.length() >= 5) {
                longWords2.add(s);
            }
        }
  
        
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력
        List<Integer> wordLengths = new ArrayList<>();
        
        for (String s : languages) {
            wordLengths.add(s.length());
        }
        
        System.out.println(wordLengths);
        
        // 정수(1, 2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);
        System.out.println(genderCodes);
        
        //리스트 genderCodes의 원소가 1이면 "Male", 2이면 "Female"을 저장하는 리스트를 만들고 출력을 하시오
        List<String> genders = new ArrayList<>();
        
        
        for (Integer code : genderCodes) {
 //           String gender = "";
 //           if (code == 1) {
 //               gender = "Male";
 //           } else {
 //               gender = "Female";
 //           }
 //           genders.add(gender);
            genders.add((code == 1) ? "Male" : "Female");
        }
        
        System.out.println(genders);
        
    }

}
