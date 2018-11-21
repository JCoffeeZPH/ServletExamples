package Cookie;

/**
 * Cookie
 * Administrator
 * 2018/11/19
 * 12:55
 */
public class Book {
    private String name;
    private String id;
    public Book(String id,String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
