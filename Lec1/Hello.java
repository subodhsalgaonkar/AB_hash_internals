// Just experimenting with hashCode function:

// Learnt:

// If you do not override the hashCode() method in your custom class, it inherits the default implementation from the java.lang.Object class.

// The JVM generates an integer typically derived from the object's internal memory address.

// The Problem: Two separate instances of your class with the exact same data fields will generate completely different hash codes. This means if you use one instance to put a value into the map, you will not be able to retrieve it using a separate instance with identical data.

package Lec1;

import java.util.HashMap;

public class Hello {
    public static void main(String[] args) {
        HashMap<Random, Integer> hs = new HashMap<>();
        Random r = new Random("Kimmichi", 45);

        hs.put(r, 238);

        System.out.println(hs.containsKey(r));
        System.out.println(hs.get(r));
        System.out.println(r.hashCode());

    }
}

class Random{
    private String key;
    private int numKey;

    public Random(String key, int numKey){
        this.key = key;
        this.numKey = numKey;
    }

    public int hashCode1(){
        int hc = key.length();
        if(hc != 0){
            for(int i = 0; i < key.length() / 2; i++){
                if(i % 2 == 0)hc += key.charAt(i);
            }
        }

        hc += numKey;

        if(numKey < 100)hc += (numKey * 133);;
        
        return hc;
    }
}