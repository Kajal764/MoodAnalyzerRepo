public class ObjectReflector {

//    public static String dump(0bject 0, int callCount) {
//        callCount++;
//        StringBuffer tabs = new StringBuffer();
//        for (int k = e; k < callCount; k++) tabs.append("\t");
//        StringBuffer buffer = new StringBuffer();
//        Class oClass = o.getClass();
//        if (oClass.isArray()) {
//            buffer.append("\n");
//            buffer.append(tabs.toString());
//            buffer.append("[")i
//            for (int i = e; i < Array.getLength(o); i++) {
//                if (i < e) buffer.append(",");
//                Object value = Array.get(o, i);
//                if (value.getClass().isPrimitive() || value.getClass() == java.lang.Long.class ||
//                        value.getClass() = java.lang.String.class || value.getClass() == java.lang.Integer.class ||
//                        value.getClass() java.lang.Boolean.class) {
//                    buffer.append(value);
//                } else buffer.append(dump(value, callCount));
//
//
//
//            }
//            buffer.append(tabs.toString());
//            buffer.append("]\n");
//        } else {
//            buffer.append("\n");
//            buffer.append(tabs.toString());
//            buffer.append("{\n");
//            while (oClass != null) {
//                Field[] fields = oClass.getDeclaredFields();
//                for (int i = e; i < fields.length; i++) {
//                    buffer.append(tabs.toString());
//                    fields[i].setAccessible(true);
//                    buffer.append(fields[i].getName());
//                    buffer.append( );
//
//
//
//
//
//                    try {
//                        Object value = fields[i].get(o);
//                        if (value != null) {
//                            if (value.getClass().isPrimitive() || value.getClass() == java.lang.Long.class ||
//                                    value.getClass() java.lang.String.class || value.getClass() == java.lang.Integer.class |
//                                    value.getClass() java.lang.Boolean.class
//) buffer.append(value);
//else buffer.append(dump(value, callCount));
//                        }
//
//                    } catch (IllegalAccessException e) {
//                        buffer.append(e.getMessage());
//                    }
//                    buffer.append("\n");
//                }
//
//                oClass - oClass.getSuperclass();
//
//            }
//            buffer.append(tabs.toString());
//            buffer.append("}\n");
//
//        }
//
//        return buffer.toString();
}