package org.src.practices.maps;

import org.src.dto.Employee;
import org.src.dto.FullCollisionEmployee;
import org.src.dto.HashCollisionEmployee;

import java.util.HashMap;
import java.util.Map;

/**
 * A Maps practice ground.
 */
public class Maps101 {

    static void mapsBasics() {
        System.out.println("Maps Basics...");

        // initializing a blank map and adding elements explicitly
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 234);
        map1.put(2, 443);
        map1.put(3, 34523);
        System.out.println("\nMap Contents - map1: " + map1);

        // pre-initializing a map
        Map<Integer, String> map2 = new HashMap<>() {
            {
                put(3, "Hello");
                put(4, "World");
                put(5, "Quickly");
                put(6, "during");
                put(7, "initialization");
            }
        };
        System.out.println("\nMap Contents - map2: " + map2);

        // check for a key in a map - if exists, returns 'true'. else, returns 'false'
        System.out.println("\nDoes map1 contain 2?: " + map1.containsKey(2));
        System.out.println("Does map1 contain 59?: " + map1.containsKey(59));

        // iterating over contents of a map.

        // Approach 1
        System.out.println("\nIterating over map2 with Entry sets:");
        for (Map.Entry<Integer, String> mEntry : map2.entrySet()) {
            System.out.println("Key: " + mEntry.getKey() + " Value: " + mEntry.getValue());
        }

        // Approach 2
        System.out.println("\nIterating over map2 with streams + (Consumer - forEach):");
        map2.entrySet().stream().forEach((mEntry) -> {
            System.out.println("Key: " + mEntry.getKey() + " Value: " + mEntry.getValue());
        });

        // Approach 3 - using the BiConsumer provided by maps
        System.out.println("\nIterating over map2 with BiConsumers - forEach:");
        map2.forEach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });

        // updating maps
        System.out.println("\nUpdate the value for \"5\" key in map2.");
        System.out.println("Previous map2 contents: " + map2);
        map2.put(5, "New World");
        System.out.println("Updated map2 contents: " + map2);

        // updating contents of a map partially
        System.out.println("\nAppend a \"!\" to the end of value of \"5\" key in map2.");
        System.out.println("Previous map2 contents: " + map2);
        map2.compute(5, (k, v) -> v + "!");
        System.out.println("Updated map2 contents: " + map2);

        // updating value of a key which does not exist - could potentially lead to exception if null value is not handled
        try {
            System.out.println("\nIncrement the value by 10 of \"54\" key in map1 with compute");
            // @note v is null as no key with 54 exists (key is also null).
            System.out.println("Previous map1 contents: " + map1);
            map1.compute(54, (key, value) -> value + 10);
            System.out.println("Updated map1 contents: " + map1);
        } catch (Exception e) {
            System.out.println("Exception due to missing key: " + e);
        }
        // better approach - use computeIfPresent - if key does not exist -> doesn't update the map
        System.out.println("\nIncrement the value by 10 of \"54\" key in map1 with computeIfPresent");
        // @note v is null as no key with 54 exists (key is also null).
        System.out.println("Previous map1 contents: " + map1);
        map1.computeIfPresent(54, (key, value) -> value + 10);
        System.out.println("Updated map1 contents: " + map1);

        System.out.println("\nIncrement the value by 111 of \"3\" key in map1 with computeIfPresent (works the same with compute)");
        System.out.println("Previous map1 contents: " + map1);
        map1.compute(3, (key, value) -> value + 111);
        System.out.println("Updated map1 contents: " + map1);

        // inserting a key-value pair without overriding existing one - putIfAbsent
        System.out.println("\nThis will override an existing key \"3\"'s value");
        System.out.println("Previous map1 contents: " + map1);
        map1.put(3, 999999);
        System.out.println("Updated map1 contents: " + map1);

        System.out.println("\nThis will not override an existing key \"3\"'s value");
        System.out.println("Previous map1 contents: " + map1);
        map1.putIfAbsent(3, 827473);
        map1.putIfAbsent(34, 893754);
        System.out.println("Updated map1 contents: " + map1);

    }

    static void mapHashCollision() {
        // key collision while inserting String keys with same hashCode, results in the checking of equals() criteria
        // e.g.
        Map<String, Integer> collisionProneMap = new HashMap<>();
        System.out.println("\"FB\" and \"Ea\" have the same hash codes (2236): " + "FB".hashCode() + " " + "Ea".hashCode());
        collisionProneMap.put("FB", 4);
        collisionProneMap.put("Ea", 19);
        System.out.println("Hash codes collide, but the values are separate (FB != Ea). Hence, both values are separate: " + collisionProneMap);

        // key collision while inserting object type keys
        // e.g.
        HashCollisionEmployee emp1 = new HashCollisionEmployee(1, "John", "IT", 785135);
        HashCollisionEmployee emp2 = new HashCollisionEmployee(2, "Doe", "DEVOPS", 34635235);
        Map<HashCollisionEmployee, Integer> collMap1 = new HashMap<>() {{
            put(emp1, 123);
            put(emp2, 44);
        }};
        System.out.println("\ncollMap1 contents: " + collMap1);

        // here, femp1 is inserted first. but when femp2 is added, the key is considered the same as that of femp1
        // because hashCode() -> 0 always & femp1.equals(femp2) -> true always.
        // the value now becomes 44
        FullCollisionEmployee femp1 = new FullCollisionEmployee(1, "John", "IT", 785135);
        FullCollisionEmployee femp2 = new FullCollisionEmployee(2, "Doe", "DEVOPS", 34635235);
        Map<FullCollisionEmployee, Integer> collMap2 = new HashMap<>() {{
            put(femp1, 123);
            put(femp2, 44);
        }};
        System.out.println("\ncollMap2 contents: " + collMap2);

        // Keys must be immutable always!
        // What if an object was inserted into the map, and later its values were changed?
        // Map will internally fail to perform a lookup
        Employee e2 = new Employee(1, "John", "IT", 785135);
        Map<Employee, String> m1 = new HashMap<>() {{
            put(e2, "Hello World");
        }};
        System.out.println("\nm1 contents: " + m1);
        // this must not be allowed!
        e2.setDepartment("Services");
        System.out.println(m1.get(e2));
        System.out.println("m1 contents after employee mod: " + m1);
        // if this updated object is inserted into the map
        m1.put(e2, "To a new world!");
        System.out.println("m1 contents after re-insertion: " + m1);
    }

    public static void main(String[] args) {
        mapsBasics();
        mapHashCollision();
    }
}
