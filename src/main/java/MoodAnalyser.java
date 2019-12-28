import java.util.Objects;

public class MoodAnalyser {
    String message;
    public MoodAnalyser(){

    }
    public MoodAnalyser(String message)
    {
        this.message=message;
    }
    public String anlyse() throws MoodAnalysisException {
        try {
            if(message.length()== 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please Enter Valid Message");

            if(message.contains("sad"))
                return "Sad";
            else
                return "Happy";
            }
        catch(NullPointerException e) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please Enter Valid Message");

        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }
}
