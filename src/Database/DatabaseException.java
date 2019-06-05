package Database;

/**
 * Verwaltet Datenbank-Exceptions.
 * @author Christoph
 * @author Sven
 */

public class DatabaseException extends Exception{

    private String ErrorMsg;

    DatabaseException(String ErrorMsg){
        this.ErrorMsg = ErrorMsg;
    }

    public String getErrorMsg(){
        return ErrorMsg;
    }
}
