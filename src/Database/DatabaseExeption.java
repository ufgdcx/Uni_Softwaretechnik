package Database;

public class DatabaseExeption extends Exception{

    private String ErrorMsg;

    DatabaseExeption(String ErrorMsg){
        this.ErrorMsg = ErrorMsg;
    }

    public String getErrorMsg(){
        return ErrorMsg;
    }
}
