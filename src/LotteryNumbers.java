import java.util.Scanner;

public class LotteryNumbers {

    public static void getUserName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello " +name);
        }

    public static void  promptGamePlay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The following program will output lottery numbers based on responses. Type 'yes' or 'y' to continue.");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"))
        getLottoNumbers();
        else {
            System.out.println("Have a nice day!");
            return;
        }
    }

    public static void getLottoNumbers(){
        String favPet = "";
        Integer petAge = 0;
        Integer luckyNum = 0;
        Integer jerseyNum = 0;
        Integer modelYear = 0;
        String favActor = "";
        Integer userRandomNum = 0;

// Get user input using the scanner and store in variables:
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of your favorite pet?");
        favPet = scanner.nextLine();
        System.out.println("What is the age of your favorite pet?");
        petAge = scanner.nextInt();
        System.out.println("What is your lucky number?");
        luckyNum = scanner.nextInt();

// Validate numeric entries and loop until valid entry is provided:
        do {
            System.out.println("Enter the jersey number of your favorite NFL Quarterback (Between 1 and 99): ");
            jerseyNum = scanner.nextInt();
            if (jerseyNum < 1 || jerseyNum > 99) {
                System.out.println("Please enter a valid jersey number between 1 and 99");
                jerseyNum = 0;
            }
        } while (jerseyNum == 0);

        do {
            System.out.println("Enter the two digit model year for your car or truck (Between 00 and 99): ");
            modelYear = scanner.nextInt();
            if (modelYear < 0 || modelYear > 99) {
                System.out.println("Please enter a valid model number between 00 and 99");
                modelYear = 0;
          }
        } while (modelYear == 0);

        scanner.nextLine();  //clear scanner buffer
        System.out.println("What is the name of your favorite actor/actress?");
        favActor = scanner.nextLine();

        do {
            System.out.println("Enter a random number between 1 and 50:");
            userRandomNum = scanner.nextInt();
            if(userRandomNum < 1 || userRandomNum > 50){
                System.out.println("Please enter a valid model number between 1 and 50");
                userRandomNum = 0;
            }
        } while (userRandomNum == 0);

// Generate a random number for use by other functions:
        double rand = (Math.random() * 100);
        int randomInt = (int)rand;

// invoke helper functions to get lotto numbers:
        int magicBall = getMagicBall(jerseyNum, luckyNum, randomInt);
        int lottoNumber1 = getValueFromPet(favPet);
        int lottoNumber2 = getValueFromCar(modelYear, luckyNum);
        int lottoNumber3 = getValueFromRandom(userRandomNum, randomInt);
        int lottoNumber4 = getValueFromActor(favActor);
        int lottoNumber5 = getValueFromPetCar(petAge, modelYear);

        System.out.println("Your lottery numbers are: " + lottoNumber1 + "," + lottoNumber2 + "," + lottoNumber3 + "," + lottoNumber4 + "," + lottoNumber5);
        System.out.println("The Magic Ball is: " + magicBall);
        System.out.println("\nWould you like to try again? (enter y for yes or n for no)");
        String response = scanner.nextLine();
        if (response == "y") {

        } else {
            return;
        }
    }


    public static int getMagicBall(int jerseyNum, int luckyNum, int randomInt){
        int multiplier = 0;

// Find the smaller of the two numbers between the jersey number and the lucky number...
        if (jerseyNum < luckyNum) {
             multiplier = jerseyNum;
        } else {
             multiplier = luckyNum;
        }

// and multiply that times the random number
        int magicBall = multiplier * randomInt;

// check to see if the MB number is less than 75. If not, keep subtracting 75 from the MB number until it is.
        if (magicBall > 75) {
            while (magicBall > 75) {
                magicBall -= 75;
            }
        }
        return magicBall;
    }

// Find the 3rd letter of their favorite pet.  Convert that character value to an integer value.
    public static int getValueFromPet(String favPet){
        char letter = favPet.charAt(2);
        int value = (int) letter;
        if (value > 65) {
            while (value > 65) {
                value -= 65;
            }
        }
        return value;

    }

//Use the two digit model year of their car and add their lucky number to it.
    public static int getValueFromCar(int modelYear, int luckyNum){
        int value = 0;
        value = modelYear + luckyNum;
        if (value > 65) {
            while (value > 65) {
                value -= 65;
            }
        }
        return value;
    }

//Use the random number between 1 and 50, subtracting one of the generated random numbers.
    public static int getValueFromRandom(int userRandomNum, int randomInt){
        int value = 0;
        value = userRandomNum - randomInt;
        value = Math.abs(value);
        if (value > 65) {
            while (value > 65) {
                value -= 65;
            }
        }
        return value;
    }

//Convert the first letter of their favorite actor/actress to an integer and use that value.
    public static int getValueFromActor(String favActor){
        char letter = favActor.charAt(0);
        int value = (int) letter;
        if (value > 65) {
            while (value > 65) {
                value -= 65;
            }
        }
        return value;

    }

//Use the age of their favorite pet + their car model year.
    public static int getValueFromPetCar(int petAge, int modelYear){
        int value = 0;
        value = petAge + modelYear;
        if (value > 65) {
            while (value > 65) {
                value -= 65;
            }
        }
        return value;

    }

}

