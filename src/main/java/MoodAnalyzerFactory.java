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

    public static Constructor getConstructor(Class<?>... parameter) {
        Class<?> moodAnalyserClass = null;
        try {
            moodAnalyserClass = Class.forName("MoodAnalyser");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(parameter);
            return moodConstructor;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Object getObject(Constructor constructor,String... parameter) {


        Object moodobj = null;
        try {
            moodobj = constructor.newInstance(parameter);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (MoodAnalyser)moodobj;

    }

    public static Object getObjectWithNoParameter(Constructor constructor) {
        Object moodobj = null;
        try {
            moodobj = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (MoodAnalyser)moodobj;

    }

}