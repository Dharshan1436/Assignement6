package assignment6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program12 {
    public static void main(String[] args) {
        String text = "Java is fun and Java is powerful. Streams in Java make it even more powerful and fun.";

        
        List<String> words = Arrays.stream(text.split("\\W+"))
                                   .map(String::toLowerCase)
                                   .collect(Collectors.toList());

        Map<String, Long> wordCountMap = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        
        List<Map.Entry<String, Long>> sortedWordCount = wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

        
        int topN = 3;
        System.out.println("Top " + topN + " most frequent words:");
        sortedWordCount.stream().limit(topN)
                .forEach(entry -> System.out.println("Word: " + entry.getKey() + ", Frequency: " + entry.getValue()));


        if (sortedWordCount.size() > 1) {
            Map.Entry<String, Long> secondMostFrequent = sortedWordCount.get(1);
            System.out.println("Second most frequent word: " + secondMostFrequent.getKey());
            System.out.println("Frequency: " + secondMostFrequent.getValue());
        } else {
            System.out.println("No second most frequent word found.");
        }
    }
}
