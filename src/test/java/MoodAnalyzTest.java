import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzTest {

    @Test
    public void whenGivenSad_shouldReturnSad() throws MoodAnalysisException {
        MoodAnalyser analyzer= new MoodAnalyser("I am sad now");
        String message = analyzer.anlyse();
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenHappy_shouldReturnHappy() {
//        String message= null;

        MoodAnalyser moodanalyzer = new MoodAnalyser("I am Happy Now");

        try {
            String message = moodanalyzer.anlyse();
            Assert.assertEquals("Happy",message);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenMeaasageWithAlphabetCapital_ShouldReturnSad() {
        MoodAnalyser analyze = new MoodAnalyser("I am sad now");
        String message= null;
        try {
            message = analyze.anlyse();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenNullValue_ShouldReturnCustomException() {
        String message=null;
        MoodAnalyser analyze = new MoodAnalyser(message);

        try {
            //ExpectedException er=ExpectedException.none();
            //er.expect(MoodAnalysisException.class);
            message=analyze.anlyse();
            Assert.assertEquals("Happy",message);
        }
        catch (MoodAnalysisException e) {
         e.printStackTrace();
        }
    }

    @Test
    public void whenGivenSpaceShouldThrowException() {
        String message="";
        MoodAnalyser analyze = new MoodAnalyser(message);

        try {
            //ExpectedException er=ExpectedException.none();
            //er.expect(MoodAnalysisException.class);
            analyze.anlyse();
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals("Please Enter Valid Message",e.getMessage());
        }
    }



    @Test
    public void whenGivenEmptyShouldThrowException() {
        String message=null;
        MoodAnalyser analyze = new MoodAnalyser(message);

        try {
            analyze.anlyse();
        }
        catch (Exception e) {
            Assert.assertEquals("Please Enter Valid Message",e.getMessage());

        }
    }

    @Test
    public void givenMoodAnalyserClass_whenProper_ShouldReturnObject() {
        MoodAnalyzerFactory.createMoodAnalyzer("I am in Happy Mood");
    }

    @Test
    public void givenMoodAnalyser_whenProper_shouldReturnObject() {
        Constructor<?> constructor= null;
        try {
            constructor = Class.forName("MoodAnalyser").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object myobj=constructor.newInstance("Please Enter Valid Message");
            MoodAnalyser moodAnalyser = (MoodAnalyser) myobj;

            String mood =moodAnalyser.anlyse();
            Assert.assertEquals("Happy",mood);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }


    @Test
    public void whenGivenObjectwithProperMessage_ShouldReturnTrue() {
        MoodAnalyser moodAnalyser1 =new MoodAnalyser("I Am Happy");
        MoodAnalyser moodAnalyser =MoodAnalyzerFactory.createMoodAnalyzer("I Am Happy");
        Assert.assertEquals(true,moodAnalyser1.equals(moodAnalyser));
    }

    @Test
    public void givenClassNameImproper_ShouldThrowException() {
        Constructor<?> constructor= null;
        try {
            constructor = Class.forName("MoodAnalyserr").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please Enter Valid Message");
        } catch (ClassNotFoundException e) {
            try{
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please Enter Valid Message");
             }
            catch (MoodAnalysisException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}