package activities;

public class CustomException extends Exception {
    private String msg;

    public CustomException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }


}
