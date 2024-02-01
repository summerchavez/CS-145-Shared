//Trevor Figgins, Brendan Leonard, Summer Chavez
//1/29/2024
//CS 145
//Lab 3 - Letter Inventory

package CS_145_Shared.lab_3_letter_inventory;

public class LetterInventory{
    private int[] counts;
    private int size;

    //This method will keep track of the alphabetic letters in a string
    public LetterInventory(String data){
        counts = new int[26];
        for(int i = 0; i < data.length(); i++){
            char ch = data.charAt(i);
            if(Character.isLetter(ch)){
                int index = Character.toLowerCase(ch) - 'a';
                counts[index]++;
                size++;
            }
        }
    }

    public LetterInventory(int[] data){
        if(data.length!=26){
            throw new IllegalArgumentException("Data must have size 26");
        }
        this.counts = data.clone();
        this.size = 0;
        for(int count : data){
            size+=count;
        }
    }

    //This method will get the count of how many letters are in the inventory
    public int get(char letter){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("Not a valid input");
        }
        int index = Character.toLowerCase(letter)- 'a';
        return counts[index];
    }

    //This method will grab the array from letterinventory to get a count on the amount of letters
    public void set(char letter, int value){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("Not a valid input");        
        }
        if(value < 0){
            throw new IllegalArgumentException("The value cant be negative");        
        }
        int index = Character.toLowerCase(letter) - 'a';
        size -= counts[index] - value; //updating the size 
        counts[index] = value;
    }

    //counts the size of the inventory/keeps track
    public int size(){
    //since it's specified that this shouldn't calculate it everytime, should just be a return value
        return size;
    }


    //if size is 0, return true, otherwise return false
    public boolean isEmpty(){
        return(size==0);
    }

    public String toString(){
        String c = "";
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < this.counts[i]; j++){
                c += (char)('a'+ i);
            }
        }
        return(c);
    }

    //takes the counts for each letter from two inventory and adds them
    //returns a new inventory count w/o effecting the old lists
    public LetterInventory add(LetterInventory other){
        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            result[i] = this.counts[i]+other.counts[i];
        }
        return(new LetterInventory(result));
    }

    //takes the counts for each letter from two inventory and subtracts leaving the difference
    //returns a new inventory count w/o effecting the old lists
    //If any of the counts would be negative, returns null instead.
    public LetterInventory subtract(LetterInventory other){
        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            if(this.counts[i]<other.counts[i]){
                return(null);
            } else {
                result[i] = this.counts[i] - other.counts[i];
            }
        }
        return(new LetterInventory(result));
    }
}