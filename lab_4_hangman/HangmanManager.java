//Names: Summer Chavez, Trevor Figgins, Brendan Leonard
//2/14/2024
//CS 145
//Lab 4 
//
//Playing a game of hangman with the computer 

import java.util.*;

public class HangmanManager{
    private Set<String> words;
    private SortedSet<Character> guessedLetters;
    private int maxGuesses;
    private int numGuesses;
    private String pattern;

    //The constructor for the HangmanManager
    HangmanManager(List<String> dictionary, int length, int max){
        if(length < 1 || max < 0 ){
            throw new IllegalArgumentException("Length needs to be less than one or max less than 0  ");
        }

        //initializes the pattern based on the word length
        pattern="-";
        for (int i=1; i<length; i++){
            pattern = pattern+'-';
        }

        //initializes the words using a treeset
        this.words = new TreeSet<>();
        for(String word : dictionary){
            if(word.length() == length){
                this.words.add(word.toLowerCase());
            }
        }

        //initializes the different ints
        this.guessedLetters = new TreeSet<>();
        this.maxGuesses = max;
        this.numGuesses = 0;
    }
    //A method that will return the set of words from the user
    public Set<String> words(){
        return this.words;
    }

    //A method that returns the number of guesses the user has left
    public int guessesLeft(){
        return this.maxGuesses - this.numGuesses;
    }

    //A method that returns the set of the guessed letters
    SortedSet<Character> guesses(){
        return this.guessedLetters;
    }

    //returns the pattern for the current word
    public String pattern(){
        if(words.isEmpty()){
            throw new IllegalStateException();
        }
        String formattedPattern = ""+pattern.charAt(0);
        for(int i = 1; i < pattern.length(); i++) {
            formattedPattern += " " + pattern.charAt(i);
        }
        return formattedPattern;
    }

    // Does most of the work of recording and processing a guess by the user
    int record(char guess){
        if(maxGuesses - numGuesses<1 || words.isEmpty()){
            throw new IllegalStateException();
        }
        if(!words.isEmpty() && guessedLetters.contains(guess)){
            throw new IllegalArgumentException();
        }

        Map<String, Set<String>> patterns = new TreeMap<String, Set<String>>();
        for(String word : words) {
            String testPattern = getPattern(guess, pattern, word);
            if(!patterns.keySet().contains(testPattern)) {
                patterns.put(testPattern, new TreeSet<String>());
            }
            patterns.get(testPattern).add(word);
        }
        
        String selectedPattern = ""; //Placeholder so the compiler doesn't yell at me
        int numWords = -1;
        for(String testPattern : patterns.keySet()) {
            if(patterns.get(testPattern).size()>numWords) {
                selectedPattern = testPattern;
                numWords = patterns.get(testPattern).size();
            }
        }

        int letterCount = 0;
        for(int i = 0; i < selectedPattern.length(); i++) {
            if(selectedPattern.charAt(i) == guess) {
                letterCount++;
            }
        }

        if(letterCount == 0) {
            numGuesses++;
        }
        pattern = selectedPattern;
        words = patterns.get(pattern);
        guessedLetters.add(guess);
        return(letterCount);
    }

    // Creates the new pattern if the given word was chosen
    private String getPattern(char guess, String initialPattern, String word) {
        if(initialPattern.length() != word.length()) {
            throw new IllegalArgumentException("pattern and word must be the same length");
        }
        String newPattern = "";
        for(int i = 0; i < initialPattern.length(); i++) {
            if(word.charAt(i) == guess) {
                newPattern += guess;
            } else {
                newPattern += initialPattern.charAt(i);
            }
        }
        return(newPattern);
    }
}


