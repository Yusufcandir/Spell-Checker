import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SpellChecker {

    private LinearProbingHashMap<String> dictionary;

    public SpellChecker() {
        dictionary = new LinearProbingHashMap<>();
    }

    public void loadDictionary(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String word : words) {
                    dictionary.insert(word);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Dictionary file not found or cannot be read.");
            System.exit(1);
        }
    }

    public void spellCheck(String textFileName) {
        System.out.println("Spelling errors in the file:");

        try (BufferedReader reader = new BufferedReader(new FileReader(textFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!dictionary.search(word)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the text file.");
        }
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();

        Scanner scanner = new Scanner(System.in);

        int option;


        System.out.println("Select an option from 1 to 5:");
        System.out.println("1. Load a dictionary from a given text file.\n" +
                "2. Search for an entry in this dictionary in constant time.\n" +
                "3. Insert a word to the dictionary in constant time.\n" +
                "4. Delete a word from the dictionary in constant time.\n" +
                "5. Given a random text file, do a spell check in linear time.\n " +
                "  Press 0 to exit.");
        option = scanner.nextInt();
        String fileName = "";
        while (option != 0) {
            if (option == 1) {
                System.out.print("Enter the name of the text file: ");
                fileName = scanner.next();
                spellChecker.loadDictionary(fileName);
            } else if (option == 2) {
                if (fileName.equals("")) {
                    System.out.println("Please load the dictionary first!");
                }else{
                System.out.print("Enter the word you want to search: ");
                String word = scanner.next();
                System.out.println(spellChecker.dictionary.search(word));}
            } else if (option == 3) {
                if (fileName.equals("")) {
                    System.out.println("Please load the dictionary first!");

                }else{
                System.out.print("Enter the word you want to insert: ");
                String insertWord = scanner.next();
                spellChecker.dictionary.insert(insertWord);}
            } else if (option == 4) {
                if (fileName.equals("")) {
                    System.out.println("Please load the dictionary first!");

                }else{
                System.out.print("Enter the word you want to delete: ");
                String deleteWord = scanner.next();
                spellChecker.dictionary.delete(deleteWord);}
            } else if (option == 5) {
                if (fileName.equals("")) {
                    System.out.println("Please load the dictionary first!");

                }else{
                System.out.print("Enter the name of the text file: ");
                String textFileName = scanner.next();
                spellChecker.spellCheck(textFileName);}
            } else {
                System.out.println("Invalid option!");
            }
            System.out.println("Select an option from 1 to 5:");
            System.out.println("1. Load a dictionary from a given text file.\n" +
                    "2. Search for an entry in this dictionary in constant time.\n" +
                    "3. Insert a word to the dictionary in constant time.\n" +
                    "4. Delete a word from the dictionary in constant time.\n" +
                    "5. Given a random text file, do a spell check in linear time.\n " +
                    "  Press 0 to exit.");
            option = scanner.nextInt();
        }

        scanner.close();
    }
}