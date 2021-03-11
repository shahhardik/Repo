package in.shahhardik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseCache {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LRUCache<Integer> cache = new LRUCache<>(3);

        int choice = 1;
        while(choice != 0) {

            System.out.println("1. PUT\n2. GET\n3. DELETE\n0. Exit");
            choice = Integer.parseInt(br.readLine());
            String key;
            int value;

            switch (choice) {

                case 1:
                    System.out.println("Enter Key");
                    key = br.readLine();
                    System.out.println("Enter Value");
                    value = Integer.parseInt(br.readLine());
                    cache.put(key,value);
                    System.out.println("Inserted\n");
                    cache.display();
                    break;

                case 2:
                    System.out.println("Enter key");
                    key = br.readLine();
                    System.out.println(" Value is : " + cache.get(key)+ "\n");
                    cache.display();
                    break;

                case 3:
                    System.out.println("Enter key");
                    key = br.readLine();
                    System.out.println(" Deleted ");
                    cache.delete(key);
                    cache.display();
                    break;

                default:
                    System.out.println("1. PUT\n2. GET\n0. Exit");

            }



        }
    }
}
