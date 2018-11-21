package Cookie;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Cookie
 * Administrator
 * 2018/11/19
 * 12:53
 */
public class DB {
    private  static Map<String, Book> map = new LinkedHashMap<>();
    static{
        map.put("1",new Book("1","javaweb开发"));
        map.put("2",new Book("2","Spring开发"));
        map.put("3",new Book("3","hibernate开发"));
        map.put("4",new Book("4","struts开发"));
        map.put("5",new Book("5","ajax开发"));
    }
    public static Map<String,Book> getAll(){
        return map;
    }
}

