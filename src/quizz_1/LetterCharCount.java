package quizz_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LetterCharCount {
    // Attribute
    private String content;

    // Construtor
    public LetterCharCount() {
    }
    // Getter and Setter
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // Method
    private Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreElements()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    private Map<Character, Integer> countLetters() {
        Map<Character, Integer> letterCount = new LinkedHashMap<>();
        for (char ch : content.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
            }
        }
        return letterCount;
    }

    // Run Function
    public void run(Scanner scanner) {
        // Enter content
        System.out.print("Enter your content: ");
        content = scanner.nextLine();
        // Output
        System.out.println(countWords());
        System.out.println(countLetters());
    }
}
