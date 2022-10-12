//package edu.java.contact.ver03;
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;
//
//import edu.java.contact.ver02.Contact;
//
//public class ContactDaoImpl implements ContactDao {
//
//    // 연락처 정보를 저장할 List
//    private List<Contact> contacts = new ArrayList<>();
//     
//    // singleton
//    private static ContactDaoImpl instance = null;
//    
//    private ContactDaoImpl() {}
//    
//    public static ContactDaoImpl getInstance() {
//        if (instance == null) {
//            instance = new ContactDaoImpl();
//        }
//        return instance;
//    }
//     
//    @Override
//    public List<Contact> read() {
//        return contacts;
//    }
//     
//    @Override
//    public Contact read(int index) {
//        if(!isValidIndex(index)) {
//            return null;
//        }
//        return contacts.remove(index);
//    }
//
//    public boolean isValidIndex(int index) {
//        return(index >= 0) && (index < contacts.size());
//    }
//    
//    @Override
//    public int create(Contact contact) {  
//        contacts.add(contact);
//        return 1;
//    }
//     
//    @Override
//    public int update(int index, Contact contact) {
//        if(!isValidIndex(index)) {
//            // valid index: index >= 0 && index < size
//            // not valid: index M 0 || index >= size 
//            return 0;
//        }
//
//        
//        contacts.set(index,  contact);
//        // 밑에 한 줄로 끝내는거 가능.
////        Contact before = contacts.get(index);
////        before.setName(contacts.getName());
////        before.setPhone(contacts.getPhone());
////        before.setEmail(contacts.getEmail());
//        
//        return 1; // 성공했으면 true, 1.
//        
//    }
//    
//     public boolean isValidIndex(int index) {
//         return (index >= 0) && (index < count);
//     }
//    
//     public boolean isMemoryAvailable() {
//         return count < MAX_LENGTH;
//     }
//
//
//
//    @Override
//    public int delete(int index) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//    
//}