package solution;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {

    /**
     * Method for reading words from words.txt file
     *
     * @return Dictionary word list
     */
    public static List<String> readDictionary() throws IOException {
        List<String> wordDictionary = null;

        List<String> list = Files.readAllLines(new File("src/main/resources/words.txt").toPath(), Charset.defaultCharset());
        wordDictionary = list.stream().map(String::toLowerCase).filter(s -> s.chars().allMatch(Character::isLetter)).collect(Collectors.toList());

        return wordDictionary;
    }

    /**
     * Searches for words related to the letters of a given word.
     *
     * @param wordToProcess Word given
     * @param wordDictionary List of words
     * @return List of words found
     */
    public static List<String> findOptions(String wordToProcess, List<String> wordDictionary) {
        List<String> words = new ArrayList<>();
        int[] freq = toFreq(wordToProcess);
        for (String wd : wordDictionary) {
            int[] freqIn = toFreq(wd);
            if (matches(freq, freqIn)) {
                words.add(wd);
            }
        }
        return words;
    }

    /**
     * Encode a word in to a freqceny array. int[0] = #a's, int[1] = #b's etc.
     *
     * @param word location and word count
     * @return letter array
     */
    private static int[] toFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            if ((c - 'a') >= 0 && (c - 'a') < 26) {
                freq[c - 'a']++;
            }
        }
        return freq;
    }

    /**
     * Returns true if all the frequencies of the letters match.
     *
     * @param freq array 1
     * @param freqIn array 2
     * @return true or false if matched
     */
    private static boolean matches(int[] freq, int[] freqIn) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0 && freqIn[i] > 0) {
                return false;
            } else if (freq[i] < freqIn[i]) {
                return false;
            }
        }
        return true;
    }

}
