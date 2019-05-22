package Database;

public class DatabaseException extends Exception{

    private String ErrorMsg;

    DatabaseException(String ErrorMsg){
        this.ErrorMsg = ErrorMsg;
    }

    public String getErrorMsg(){
        return ErrorMsg;
    }
}
