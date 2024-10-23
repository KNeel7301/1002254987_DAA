public class Main {
    public static void main(String[] args) {
      
        CustomHashTable hashTable = new CustomHashTable(new CustomHashTable.ModulusHashFunction());

        System.out.println("Inserting values:");

        hashTable.add(1, 10);
        hashTable.add(2, 20);
        hashTable.add(1, 15);  // Multiple values for the same key
        hashTable.add(2, 25);  // Multiple values for the same key
        hashTable.add(3, 40);
        hashTable.add(4, 50);
    }
}
