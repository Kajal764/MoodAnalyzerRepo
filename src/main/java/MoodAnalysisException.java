
public class MoodAnalysisException extends RuntimeException{
    enum ExceptionType{
    ENTERED_NULL,ENTERED_EMPTY;
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type,String message){
        super(message);
        this.type=type;
 }

}
