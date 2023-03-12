package cl.eduardo.productsservice.exception;

public class ErrorsResponse {

    private int status;
    private String title;

    public ErrorsResponse(int status, String title) {
        this.status = status;
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
