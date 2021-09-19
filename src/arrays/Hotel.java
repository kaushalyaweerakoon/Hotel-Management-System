package arrays; //importing to package


import java.util.Scanner; //import for create object and take input
import java.io.FileWriter; //write a txt file
import java.io.IOException;
import java.io.PrintWriter; //import to the read txt file
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Hotel {
    public static String roomName;  //make variable using public static for use it in any method without adding this variables again
    public static int roomNum;
    public static Room[] hotel = new Room[8]; //make array using public static for use it in any method without adding this variables again
    public static Person[] person = new Person[8];
    public static String customerFirstName;
    public static String customerSurName;
    public static int noOfGuests;
    public static int creditCardNum;


    public static Scanner input = new Scanner(System.in);
    public static Person room;


    public static void main(String[] args) {
        hotel[0] = new Room();
        hotel[1] = new Room();
        hotel[2] = new Room();
        hotel[3] = new Room();
        hotel[4] = new Room();
        hotel[5] = new Room();
        hotel[6] = new Room();
        hotel[7] = new Room();

        person[0] = new Person();
        person[1] = new Person();
        person[2] = new Person();
        person[3] = new Person();
        person[4] = new Person();
        person[5] = new Person();
        person[6] = new Person();
        person[7] = new Person();


        initialise();  //run initialise first for make array empty. make sure array empty
        menu(); //then run menu function

    }


    public static void menu() {


        char quit = 'n';
        String input;
//loop menu until user type y for exit
        while (quit != 'y') {
            System.out.println("*******************************************************************************");
            System.out.println("_____________________Welcome to the Hotel Programme____________________________");
            System.out.println("*******************************************************************************");
            System.out.println("Enter one of the following character:");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("A: to add a customer to a room");
            System.out.println("V: to view all rooms");
            System.out.println("E: Display Empty rooms");
            System.out.println("D: Delete customer from room");
            System.out.println("F: Find room from customer name");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: View guests Ordered alphabetically by name");
            System.out.println("P: Exit");
            System.out.println("*******************************************************************************");

            Scanner sc = new Scanner(System.in);  //make a object sc and assign ist as sc
            System.out.println("Enter your character-: ");

            char ch = sc.next().charAt(0);

            switch (ch) {
                case 'A':
                case 'a':
                    addUser(); //if user choose "a" or "A" run method adduser()
                    break;

                case 'V':
                case 'v':
                    viewAll();
                    break;

                case 'E':
                case 'e':
                    viewEmpty();
                    break;
                case 'D':
                case 'd':
                    deleteUser();
                    break;
                case 'F':
                case 'f':
                    findRoom();
                    break;
                case 'S':
                case 's':
                    storeFile();
                    break;
                case 'L':
                case 'l':
                    loadFile();
                    break;
                case 'O':
                case 'o':
                    orderedAl();
                    break;
                default:
                    System.out.println("That wasn't a choice."); //if user enter another word without using menu key word.it will say like this

            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("Would you like to quit y/n?"); //ask from user if he want to exit from the programme.if it "y"programme will exit and if it "n" programme menu will be loop again
            input = sc.next().toLowerCase();
            quit = input.charAt(0);
        }
    }


    private static void addUser() {


        System.out.println("Enter room number (0-7) or 8 to stop:");
        roomNum = input.nextInt();    //take user inputs and assign them to specified name
        if (roomNum==8){
            System.exit(0);
        }
        System.out.println("Enter name for room " + roomNum + " :");
        roomName = input.next();
        hotel[roomNum].setName(roomName);

        System.out.println(" ");
        System.out.println("__________Enter Customer Details__________");
        System.out.println(" ");

        System.out.print("Enter Customer First Name : ");
        customerFirstName = input.next();
        System.out.print("Enter customer SurName :");
        customerSurName = input.next();

        System.out.print("Enter No Of Guests :");
        noOfGuests = input.nextInt();

        System.out.print("Enter the credit card number :");
        creditCardNum = input.nextInt();


        person[roomNum].setFirstName(customerFirstName); //in person array roomNum element equals to customerFirstName
        person[roomNum].setSurName(customerSurName);
        person[roomNum].setCreditCardNum(creditCardNum);
        person[roomNum].setTotalGuest(noOfGuests);

    }

    //when user start the programme following arrays x element equals like this
    private static void initialise() {
        for (int x = 0; x < 8; x++) {
            hotel[x].setName(" "); //initialise
            person[x].setFirstName(" ");
            person[x].setSurName(" ");
            person[x].setCreditCardNum(0);
            person[x].setTotalGuest(0);
        }
    }






    private static void viewAll() {
        for (int i = 0; i < 8; i++) {
            System.out.println("room " + i + " occupied by " + hotel[i].getName());

            System.out.println("First Name : " + person[i].getFirstName());
            System.out.println("surname : "+ person[i].getSurNamw());
            System.out.println("Credit card number : "+ person[i].getCreditCardNum());
            System.out.println("Num of guests : "+ person[i].getTotalGuest());
            System.out.println(" ");
            System.out.println(" ");
        }
    }


    private static void viewEmpty() {
        for (int x = 0; x < 8; x++) {
            if (hotel[x].getName().equals(" ")) System.out.println("room " + x + " is empty"); //if hotel element x is equal to (" ") it will print room is empty
        }

    }



    private static void deleteUser() { //getting the delete input and hotel arrays "delete" index will equal like that
        Scanner input = new Scanner(System.in);

        System.out.println("Enter room number user delete:");
        int delete = input.nextInt();
        hotel[delete].setName(" ");
        person[delete].setFirstName(" ");
        person[delete].setSurName(" ");
        person[delete].setCreditCardNum(0);
        person[delete].setTotalGuest(0);
        System.out.println("Room number " + delete + "customer details deleted");
    }

    private static void findRoom() {
        Scanner input = new Scanner(System.in);
        String userName;
        System.out.println("Enter the customer name:");
        userName = input.next();
        boolean Checker = false;
        for (int x = 0; x < hotel.length; x++) {
            if (userName.equals(hotel[x].getName())) { //when user add userName to find if it equals to hotel array's x element
                System.out.println("That customer is in room " + x);
                Checker = true; //if it print boolean value be true
            }
        }
        if (Checker == false) { //if it false print this
            System.out.println("There are no any customer in that name...");
        }
    }

    private static void storeFile() {
        //store data to this location. in output.TXT file
        try (PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\Kasun\\Desktop\\Java programming Coursework\\programming cw task 3\\Task 2 modified\\output.TXT"))) {
            for (int x = 0; x < 8; x++) {
                out.println("Room number " + x + " and Customer name is " + hotel[x].getName());
                out.println("First Name : " +person[x].getFirstName());
                out.println("surname : "+person[x].getSurNamw());
                out.println("Credit card number : "+person[x].getCreditCardNum());
                out.println("Num of guests : "+person[x].getTotalGuest());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("All Room Names have been Saved.");
    }

    private static void loadFile() {
        //load output.TXT file from this location
        try {
            File myObj = new File("C:\\Users\\Kasun\\Desktop\\Java programming Coursework\\programming cw task 3\\Task 2 modified\\output.TXT");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void orderedAl() {
        String[] hotelOrder = new String[hotel.length]; //hotel class length equals to hotelOrder class length
        for (int a=0;a< hotel.length;a++){
            hotelOrder[a]=hotel[a].getName();  //hotelOrder class element a equals to hotel class element a
        }
        for (int i = 0; i <8; i++) {

            for (int j = i + 1; j <8; j++) {
                // to compare one string with other strings
                if (hotelOrder[i].compareTo(hotelOrder[j]) > 0) {
                    // swapping
                    String temp = hotelOrder[i];
                    hotelOrder[i] = hotelOrder[j];
                    hotelOrder[j] = temp;
                }

            }
        }
        for (int i = 0; i <hotelOrder.length; i++)// Print words
        {
            System.out.print(hotelOrder[i] + " ");
        }
        System.out.println();
    }



}




















