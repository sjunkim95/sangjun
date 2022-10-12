package edu.java.contact.ver06;

import edu.java.contact.ver06.Contact;
import static edu.java.contact.ver06.Contact.Entity.*;

public interface ContactSql {
//  String TBL_CONTACTS = "CONTACTS";
//  String COL_CID = "CID";
//  String COL_NAME = "NAME";
//  String COL_PHONE = "PHONE";
//  String COL_EMAIL = "EMAIL";

    // TODO: ContactDao.read() 메서드에서 사용할 SQL
    // select * from CONTACTS order by NAME
    String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc", 
            TBL_CONTACTS, COL_NAME);
    
    // TODO: ContactDao.read(Integer cid) 메서드에서 사용할 SQL
    // select * from CONTACTS where CID = ?
    String SQL_SELECT_BY_CID = String.format(
            "select * from %s where %s = ?", 
            TBL_CONTACTS, COL_CID);
    
    // TODO: ContactDao.create(Contact contact) 메서드에서 사용할 SQL
    String SQL_CREATE = String.format(
            "insert into %s (%s, %s, %s) values (?, ?, ?)", 
            TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL);
    
    // TODO: ContactDao.update(Contact contact) 메서드에서 사용할 SQL
    String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ?",
            TBL_CONTACTS, COL_NAME, COL_PHONE, COL_EMAIL);
    
    // TODO: ContactDao.delete(Integer cid) 메서드에서 사용할 SQL
    // delete from CONTACTS where CID = ?
    String SQL_DELETE = String.format(
            "delete from %s where %s = ?",
            TBL_CONTACTS, COL_CID);

}