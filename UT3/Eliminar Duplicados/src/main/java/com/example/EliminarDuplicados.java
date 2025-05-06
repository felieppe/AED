package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EliminarDuplicados
{
    public static void main( String[] args )
    {
        EliminarDuplicados app = new EliminarDuplicados();
        List<Integer> myList = app.EliminarDup();
        System.out.println(myList);
    }

    public List<Integer> EliminarDup(){
        List<Integer> myList = Arrays.asList(1, 4, 5, 10, 10, 1, 3);
        List<Integer> myList2 = new ArrayList<Integer>();
        boolean hasDuplicates = false;
        for (Integer num : myList) {
            if (!myList2.contains(num)) {
                myList2.add(num);
            } else {
                hasDuplicates = true;
            }
        }
        if (!hasDuplicates) {
            System.out.println("La lista no contiene elementos duplicados");
        }
        return myList2;
    }
}
