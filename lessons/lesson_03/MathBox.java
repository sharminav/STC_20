package lesson_03;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Класс MathBox
 * Изменение для GitHub
 */

public class MathBox extends ObjectBox{

    //Collection coll; - определяется в классе ObjectBox
    // методы toString, hashCode, equals определены в классе ObjectBox

    public MathBox(Number[] arr) {
        coll = new ArrayList();
        for (var i = 0; i < arr.length; i++) {
            coll.add(arr[i].floatValue());
        }
    }

    public float summator () {
        float result = 0;
        for (Object dbl: coll) {
            result = result + (float)dbl;
        }
        return  result;
    }

    public void splitter (float div) {
        Collection collNew = new ArrayList();
        for (Object dbl: coll) {
            collNew.add((float) dbl / div);
        }
        coll = collNew;
    }

    public void deleteObject(int delObj) {
        for (Object obj: coll) {
            float d= (float) obj;
            int i = (int) d;
            float d2 = d- i; // дробная часть
            if (Math.round((float)obj) == delObj && d2 == 0) {
                coll.remove(obj);
                break;
            }
        }
    }



}
