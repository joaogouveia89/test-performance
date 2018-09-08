package joaogouveia89.github.io.testedeperformance.api.responses;

public class ResultResponse {

    private int code;
    private String message;

    public ResultResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
