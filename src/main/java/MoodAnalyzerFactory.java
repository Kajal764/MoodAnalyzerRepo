import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyser createMoodAnalyzer(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            try {
                Object moodobj = moodConstructor.newInstance(message);
                return (MoodAnalyser)moodobj;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (NoSuchMethodException e) {
            e.printStackTrace();
            }
        return null;
    }
    }