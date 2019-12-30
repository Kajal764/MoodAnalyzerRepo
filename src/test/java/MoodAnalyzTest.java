import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    public void whenGivenConstuctorImproper_ShouldThrowException() {
        Constructor<?> constructor= null;
        try {
            constructor = Class.forName("MoodAnalyser").getConstructor();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            try{
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Please Enter Valid Constuctor");
            }
            catch (MoodAnalysisException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void whenGivenConstructorWithParameter_ShouldReturnObject() {
        Constructor constructor=MoodAnalyzerFactory.getConstructor(String.class);
        Object object=MoodAnalyzerFactory.getObject(constructor,"I AM HAPPY");
       // Object oo=MoodAnalyzerFactory.getObjectDefaultConstructor(constructor);

        MoodAnalyser moodAnalyser=(MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser("I AM HAPPY")));
    }

    @Test
    public void whenGivenConstructorWithNoParameter_ShouldReturnObject() {
        Constructor constructor=MoodAnalyzerFactory.getConstructor();
        Object object=MoodAnalyzerFactory.getObject(constructor);
        MoodAnalyser moodAnalyser=(MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser()));
    }

    @Test
    public void whenMethodInvoke_ShouldReturnCorrect () throws ClassNotFoundException {
        //Constructor constructor=MoodAnalyzerFactory.getConstructor(String.class);

        Method method=new MoodAnalyzerFactory().getMethod("analyseMood");
        try {
            String mood=(String)method.invoke(new MoodAnalyser(),"I Am Happy");
            Assert.assertEquals("Happy",mood);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*try {
            Constructor constructor=MoodAnalyzerFactory.getConstructor(String.class);
            Object obj=MoodAnalyzerFactory.getObject(constructor,"I Am Happy");
            Method method=MoodAnalyser.class.getDeclaredMethod("analyseMood");
            Object object=method.invoke(obj);
            Assert.assertEquals("Happy",object.toString());
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }*/

    }

    @Test
    public void givenClassNameImproper_ShouldThrowException() {
        Constructor<?> constructor= null;
        try {
            constructor = Class.forName("MoodAnalyserr").getConstructor(String.class);
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please Enter Valid ClassName");
        } catch (ClassNotFoundException e) {
            try{
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please Enter Valid ClassName");
             }
            catch (MoodAnalysisException ex)
            {
                ex.printStackTrace();
            }
        }
        

        



    }

}