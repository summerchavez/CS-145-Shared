//Summer Chavez, Brendan Leonard, Trevor Figgins
// 1/29/2024
//CS 145
//lab 3
//Tests the LetterInventory class
package CS_145_Shared.lab_3_letter_inventory;

public class LetterInventoryMain {
    public static void main(String[] args) {
        LetterInventory myInventory = new LetterInventory("Hello World1234");
        System.out.println(myInventory);//dehllloorw
        System.out.println("Size: "+myInventory.size());//Size: 10

        System.out.println(myInventory.get('L'));//3
        System.out.println(myInventory.get('j'));//0
        // System.out.println(myInventory.get(','));//Error
        myInventory.set('l', 5);
        System.out.println("Size: "+myInventory.size());//Size: 12
        System.out.println(myInventory.get('L'));//5
        // myInventory.set(',', 2);//Error
        // myInventory.set('s', -1);//Error
        System.out.println(myInventory);//dehllllloorw

        LetterInventory emptyInventory = new LetterInventory("");
        System.out.println("Contents of empty inventory: "+emptyInventory);
        System.out.println("Original inventory is empty: "+myInventory.isEmpty());
        System.out.println("Empty inventory evaluates as empty: "+emptyInventory.isEmpty());

        LetterInventory myInventory2 = new LetterInventory("aaabb");
        LetterInventory sum = myInventory.add(myInventory2);
        System.out.println(myInventory + " + " + myInventory2 + " = " + sum + ", which has length " + sum.size());
        LetterInventory subtractor = new LetterInventory("hlll");
        LetterInventory diff1 = myInventory.subtract(subtractor);
        System.out.println(myInventory + " - " + subtractor + " = " + diff1 + ", which has length " + diff1.size());
        LetterInventory diff2 = myInventory.subtract(myInventory2);
        System.out.println(myInventory + " - " + myInventory2 + " = " + diff2);
    }
}
