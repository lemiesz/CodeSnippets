public class Main {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<String, String>();
        hashTable.insert("Hello", "World");
        System.out.println(hashTable.find("Hello"));
        hashTable.insert("Hello", "No World");
        System.out.println(hashTable.find("Hello"));
        hashTable.insert("Hello2", "No Wow");
        System.out.println(hashTable.find("Hello2"));
        hashTable.delete("Hello2");
        System.out.println(hashTable.find("Hello2"));
    }
}