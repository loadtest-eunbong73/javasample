package hello;

public class ResFormat {

    private final long id;
    private final String content;

    public ResFormat(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
