//Trevor Figgins
//1/29/2024
//CS 145
//Pre Lab 3

//Mock up of the LetterInventory Lab

public class LetterInventory{
    private int[] counts;
    private int size;

    // public LetterInventory(String data){
    //     //should have a [a-zA-Z] for acceptable terms to pass through
    //     //probably another nested for loop to just cycle through per character 
    //     for(i){
    //         for(j){
    //             count+;
    //         }
    //     }
    // }

    //should take in size as the limit for a for loop and then maybe an if statement to get a count on 
    //how many of each char their is in the array
    // public int get(char letter){
    //     for(size; i++){
    //         if(contains char){
    //         count ++;
    //         }
    //         exception thrown if out of bounds
    //     }
    // }

    //just setting the count of a letter in the list to the passed int value
    //pretty sure its way more complicated than this
    // public void set(char letter, int value){
    //     int letterCount = letter
    //     letter = int value
    // }

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
    }

    //takes the counts for each letter from two inventory and adds them
    //returns a new inventory count w/o effecting the old lists
    public LetterInventory add(){
        //TODO
        inventory1 + inventory2 = new inventory
        return new inventory
    }

    //takes the counts for each letter from two inventory and subtracts leaving the difference
    //returns a new inventory count w/o effecting the old lists
    public LetterInventory subtract(){
        //TODO
        inventory1 - inventory2 = new inventory
        return new inventory 
    }
}