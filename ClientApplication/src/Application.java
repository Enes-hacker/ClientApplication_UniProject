import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final int BOOMER_CLIENT = 1965;
        final String GENDER_MALE = "MALE";
        final String GENDER_FEMALE = "FEMALE";
        final String GENDER_SECRET = "IT IS A SECRET";
        final int Digit_ID_ONE = 1;
        final int Digit_ID_THREE = 3;
        final int ADULT_AGE = 18;
        final float UNDER_WEIGHT = 16;
        final float NORMAL_WEIGHT = (float) 16.99;
        final float IDEAL_ATHLETIC_WEIGHT = (float) 18.49 ;
        final float IDEAL_WEIGHT = (float) 24.99;
        final float PRE_OVERWEIGHT = (float) 29.99;
        final float OVERWEIGHT = (float) 34.99;
        final float OBESE = (float) 39.99;
        final float MEGA_OBESE = 40;
        final int SELDOM = 1;
        final int SOMETIMES = 2;
        final int OFTEN = 3;
        final int  FRUITS_AND_VEGETABLES = 1;
        final int  MEAT_AND_MEAT_PRODUCTS = 2;
        final int  CIGARETTE_AND_ALCOHOL = 3;
        final int  DIARY_PRODUCTS = 4;
        final int  SWEETS = 5;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Кога сте родени?");   // First Question
        int yearOfBirth = scanner.nextInt();

        System.out.println("Enter yor gender (1 - MALE/2 - FEMALE 3-PREFER NOT TO SAY)"); // Second Question
        int Gender = scanner.nextInt();
        String message = (Gender == 1)
                ? GENDER_MALE
                : (Gender == 2)
                ? GENDER_FEMALE
                : (Gender == 3)
                ? GENDER_SECRET
                : "Oops something went wrong";
        System.out.println(message);

        System.out.println("How old are you?"); // Question 3
        int age = scanner.nextInt();

        Random randomGenerator = new Random();
        int randomDigit = randomGenerator.nextInt(7)+1;
        System.out.println("Random Digit is: " + randomDigit);

        int firstDigitIDFormula = age/randomDigit;              // First Digit ID
        int firstDigitID = 0;
        int firstOutOfTwo = (firstDigitIDFormula / 10) % 10;

        if(firstDigitIDFormula > 9){
            System.out.println("Цифра на десетиците или  цялото число  е: " + firstOutOfTwo);
        } else
            System.out.println("First ID num if year !=1965 " + firstDigitID);

        boolean isClientBoomer = yearOfBirth < BOOMER_CLIENT;
        boolean isClientNotBoomer = yearOfBirth > BOOMER_CLIENT;
        boolean isClientBornIn1965 = yearOfBirth == BOOMER_CLIENT;

        if (isClientBoomer &&  (firstDigitIDFormula % 2 == 0) && firstDigitIDFormula > 9){
            firstDigitID = firstOutOfTwo + 1;
            System.out.println("1ST DIGIT ID is: " + firstDigitID);

        }  else if(isClientBoomer && firstDigitIDFormula % 2 != 0 && firstDigitIDFormula > 9) {
            firstDigitID = firstOutOfTwo;
            System.out.println("1ST DIGIT ID is: " + firstDigitID);
        }
        else if (isClientNotBoomer && firstDigitIDFormula % 2 != 0){
            firstDigitID = firstDigitIDFormula + 1;
            System.out.println("1st FIRST Digit ID:" + firstDigitID);
        } else if (isClientNotBoomer && firstDigitIDFormula % 2 == 0){
            firstDigitID = firstDigitIDFormula;
            System.out.println("1st FIRST Digit ID:" + (firstDigitID));
        } else if (isClientNotBoomer && firstDigitIDFormula > 9){
            firstDigitID = firstOutOfTwo;
            System.out.println(firstDigitID);
        } else if (isClientNotBoomer && firstDigitIDFormula > 9 && firstDigitIDFormula %2  != 0){
            firstDigitID = firstOutOfTwo + 1;
            System.out.println(firstDigitID);
        }
        else if (isClientBornIn1965) {
            System.out.println("1st digit id is " + firstDigitID);
        }

        int secondDigitID = 0;                      // Second digit ID number

        if (Gender == 1) {
            secondDigitID = Digit_ID_ONE;
            System.out.println("2nd Second DIGIT ID: " + secondDigitID);
        } else if (Gender == 2) {
            secondDigitID = Digit_ID_THREE;
            System.out.println("2nd Second DIGIT ID: " + secondDigitID);
        } else if (Gender == 3) {
            System.out.println("Enter a number between 1-9");
            secondDigitID = scanner.nextInt();

            if (secondDigitID == 1 || secondDigitID == 3 || secondDigitID > 9) {
                System.out.println("ERROR");
            } else
                System.out.println("2nd Second DIGIT ID: " + secondDigitID);
        }

        int thirdDigitID = 0;                               // Third digit ID number

        boolean isClientAdult = age >= ADULT_AGE;
        boolean isClientUnderage = age < ADULT_AGE;

        int yearOfBirthMother = 0;
        int yearOfBirthFather = 0;

        if(isClientAdult){
            System.out.println("3rd Third digit ID is: " + thirdDigitID);
        }  if (isClientUnderage &&  yearOfBirthMother % 10 == yearOfBirthFather % 10){
            System.out.println("When did your father born");
            yearOfBirthFather = scanner.nextInt();
            System.out.println("When did yor mother born");
            yearOfBirthMother = scanner.nextInt();
            thirdDigitID = (yearOfBirthMother / 10) % 10;
            System.out.println("3rd ID Number is: " + thirdDigitID);
        } else if (isClientUnderage && yearOfBirthMother % 10 != yearOfBirthFather % 10) {
            System.out.println("When did your father born");
            yearOfBirthFather = scanner.nextInt();
            System.out.println("When did yor mother born");
            yearOfBirthMother = scanner.nextInt();
            thirdDigitID = yearOfBirthFather % 10;
            System.out.println("3rd ID Number is: " + thirdDigitID);
        }

        int fourthDigitID = 0;                     // Fourth digit ID number

        System.out.println("What's your height in cm?"); // Question 4
        float height = scanner.nextInt();
        System.out.println("Could you write down your weight in kg, please?");
        float kilogram = scanner.nextInt();

        float formula = (float) (kilogram / (height*height)) * 10000;
        System.out.println(formula);

        boolean isClientUnderWeight = formula < UNDER_WEIGHT;
        boolean isClientNormalWeight = formula > UNDER_WEIGHT &&
                formula <= NORMAL_WEIGHT;
        boolean isClientIdealAthleticWeight = formula > NORMAL_WEIGHT &&
                formula <= IDEAL_ATHLETIC_WEIGHT;
        boolean isClientIdealWeight = formula > IDEAL_ATHLETIC_WEIGHT
                && formula <= IDEAL_WEIGHT;
        boolean isClientPreOverWeight = formula > IDEAL_WEIGHT
                && formula <= PRE_OVERWEIGHT;
        boolean isClientOverWeight = formula > PRE_OVERWEIGHT
                && formula <= OVERWEIGHT ;
        boolean isClientObese = formula > OVERWEIGHT
                && formula <= OBESE;
        boolean isClientMegaObese = formula >OBESE
                && formula <= MEGA_OBESE;

        if (isClientUnderWeight) {
            fourthDigitID = 1;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        } else if (isClientNormalWeight) {
            fourthDigitID = 2;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        } else if (isClientIdealAthleticWeight) {
            fourthDigitID = 3;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        } else if (isClientIdealWeight) {
            fourthDigitID = 4;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        } else if (isClientPreOverWeight) {
            fourthDigitID = 5;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        } else if (isClientOverWeight) {
            fourthDigitID = 6;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        }  else if (isClientObese) {
            fourthDigitID = 7;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        }  else if (isClientMegaObese) {
            fourthDigitID = 8;
            System.out.println("4th Fourth Digit ID is: " + fourthDigitID);
        }

        int fruitsAndVegetablesID  = 1;                                          // Fifth digit ID number
        int meatAndMeatProductsID  = 2;
        int CigarettesAndAlcoholID = 3;
        int diaryProductsID        = 4;
        int SweetsID               = 5;
        int fifthDigitID = 0;
        int firstQuestion = 0;
        int secondQuestion;
        int thirdQuestion;
        int fourthQuestion;
        int fifthQuestion = 0;

        System.out.println("Коко често употребявате следните стоки?"); // Question 5
        System.out.println("Изберете");
        System.out.println("1 -  РЯДКО ");
        System.out.println("2 -  ПОНЯКОГА ");
        System.out.println("3 - ЧЕСТО");

        System.out.println("Изберете си Стока: ");

        System.out.println("1. плодове и зеленчуци");
        System.out.println("2. месо и месни продукти");
        System.out.println("3. цигари и алкохол" );
        System.out.println("4. млечни продукти");
        System.out.println("5. захарни изделия");

        int selectedQuestion = scanner.nextInt();
        String selectedQuestionAnswer = (selectedQuestion == 1)
                ? "1. плодове и зеленчуци"
                : (selectedQuestion == 2)
                ? "2. месо и месни продукти"
                : (selectedQuestion == 3)
                ? "3. цигари и алкохол"
                : (selectedQuestion == 4)
                ? "4. млечни продукти"
                : (selectedQuestion == 5)
                ? "5. захарни изделия"
                : "Грешка! Въпросът не е намерен";
        System.out.println(selectedQuestionAnswer);

        if (selectedQuestion == FRUITS_AND_VEGETABLES){
            System.out.println("Въведете 1 - РЯДКО/НИКОГА");
            System.out.println("Въведете 2 - ПОНЯКОГА");
            System.out.println("Въведете 3 - ЧЕСТО");
             firstQuestion = scanner.nextInt();
            String firstQuestionAnswer = (firstQuestion == SELDOM)
                    ? "РЯДКО ИЛИ НИКОГА"
                    : (firstQuestion == SOMETIMES)
                    ? "ПОНЯКОГА"
                    : (firstQuestion == OFTEN)
                    ? "ЧЕСТО"
                    : "ГРЕШКА";
            System.out.println(firstQuestionAnswer);
            fifthDigitID = fruitsAndVegetablesID  + firstQuestion;
            System.out.println("5th Fifth Digit ID is: " + fifthDigitID);
        } else if (selectedQuestion == MEAT_AND_MEAT_PRODUCTS) {
            System.out.println("Въведете 1 - РЯДКО/НИКОГА");
            System.out.println("Въведете 2 - ПОНЯКОГА");
            System.out.println("Въведете 3 - ЧЕСТО");
            secondQuestion = scanner.nextInt();
            String secondQuestionAnswer = (secondQuestion == SELDOM)
                    ? "РЯДКО ИЛИ НИКОГА"
                    : (secondQuestion == SOMETIMES)
                    ? "ПОНЯКОГА"
                    : (secondQuestion == OFTEN)
                    ? "ЧЕСТО"
                    : "ГРЕШКА";
            System.out.println(secondQuestionAnswer);
            fifthDigitID = meatAndMeatProductsID  + secondQuestion;
            System.out.println("5th Fifth Digit ID is: " + fifthDigitID);
        } else if (selectedQuestion == CIGARETTE_AND_ALCOHOL) {
            System.out.println("Въведете 1 - РЯДКО/НИКОГА");
            System.out.println("Въведете 2 - ПОНЯКОГА");
            System.out.println("Въведете 3 - ЧЕСТО");
            thirdQuestion = scanner.nextInt();
            String thirdQuestionAnswer = (thirdQuestion == SELDOM)
                    ? "РЯДКО ИЛИ НИКОГА"
                    : (thirdQuestion == SOMETIMES)
                    ? "ПОНЯКОГА"
                    : (thirdQuestion == OFTEN)
                    ? "ЧЕСТО"
                    : "ГРЕШКА";
            System.out.println(thirdQuestionAnswer);
            fifthDigitID = CigarettesAndAlcoholID + thirdQuestion;
            System.out.println("5th Fifth Digit ID is: " + fifthDigitID);
        } else if (selectedQuestion == DIARY_PRODUCTS) {
            System.out.println("Въведете 1 - РЯДКО/НИКОГА");
            System.out.println("Въведете 2 - ПОНЯКОГА");
            System.out.println("Въведете 3 - ЧЕСТО");
            fourthQuestion = scanner.nextInt();
            String fourthQuestionAnswer = (fourthQuestion == SELDOM)
                    ? "РЯДКО ИЛИ НИКОГА"
                    : (fourthQuestion == SOMETIMES)
                    ? "ПОНЯКОГА"
                    : (fourthQuestion == OFTEN)
                    ? "ЧЕСТО"
                    : "ГРЕШКА";
            System.out.println(fourthQuestionAnswer);
            fifthDigitID = diaryProductsID + fourthQuestion;
            System.out.println("5th Fifth Digit ID is: " + fifthDigitID);
        } else if (selectedQuestion == SWEETS) {
            System.out.println("Въведете 1 - РЯДКО/НИКОГА");
            System.out.println("Въведете 2 - ПОНЯКОГА");
            System.out.println("Въведете 3 - ЧЕСТО");
            fifthQuestion = scanner.nextInt();
            String fifthQuestionAnswer = (fifthQuestion == SELDOM)
                    ? "РЯДКО ИЛИ НИКОГА"
                    : (fifthQuestion == SOMETIMES)
                    ? "ПОНЯКОГА"
                    : (fifthQuestion == OFTEN)
                    ? "ЧЕСТО"
                    : "ГРЕШКА";
            System.out.println(fifthQuestionAnswer);
            fifthDigitID = SweetsID + fifthQuestion;
            System.out.println("5th Fifth Digit ID is: " + fifthDigitID);
        }

        int sixthDigitID = firstDigitID + secondDigitID +                       //Sixth Digit ID
                thirdDigitID + fourthDigitID +fifthDigitID;
        System.out.println("1-5 sum: " + sixthDigitID);

        int totalSumFirstDigit = (sixthDigitID / 10) % 10;
        int totalSumSecondDigit = sixthDigitID % 10;

        if(sixthDigitID <= 9){
            System.out.println("6th Sixth ID number is: " + sixthDigitID);
        } else if (sixthDigitID > 9) {
            sixthDigitID = totalSumFirstDigit + totalSumSecondDigit;
            System.out.println("6th Sixth ID number is: " + sixthDigitID);
        }

        int seventhDigitID = 0;                                              // Seventh Digit ID
        int firstSixDigits = firstDigitID + secondDigitID + thirdDigitID
                +fourthDigitID+fifthDigitID+sixthDigitID;

        boolean firstSixDigitComparison = (sixthDigitID > fifthDigitID) && (sixthDigitID > fourthDigitID)
                && (sixthDigitID > thirdDigitID) && (sixthDigitID > secondDigitID) &&
                (sixthDigitID > firstDigitID) && (fifthDigitID > fourthDigitID) && (fifthDigitID  > thirdDigitID)
                && (fifthDigitID > secondDigitID) && (fifthDigitID > firstDigitID) &&
                (fourthDigitID > thirdDigitID) && (fourthDigitID > secondDigitID) && (fourthDigitID > firstDigitID)
                && (thirdDigitID > secondDigitID) && (thirdDigitID > firstDigitID) &&
                (secondDigitID > firstDigitID);

        boolean isFirstSixDigitsAreEqual = (sixthDigitID == fifthDigitID) && (sixthDigitID == fourthDigitID)
                && (sixthDigitID == thirdDigitID) && (sixthDigitID == secondDigitID) &&
                (sixthDigitID == firstDigitID) && (fifthDigitID == fourthDigitID) && (fifthDigitID  == thirdDigitID)
                && (fifthDigitID == secondDigitID) && (fifthDigitID == firstDigitID) &&
                (fourthDigitID == thirdDigitID) && (fourthDigitID == secondDigitID) && (fourthDigitID == firstDigitID)
                && (thirdDigitID == secondDigitID) && (thirdDigitID == firstDigitID) &&
                (secondDigitID == firstDigitID);

        boolean isFirstAndSecondDigitsEven = firstDigitID % 2 == 0 && secondDigitID % 2 == 0;
        boolean isThirdFourthFifthDigitsOdd = thirdDigitID % 2 != 0 && fourthDigitID % 2 != 0
                && fifthDigitID % 2 != 0;
        boolean isFirstOrThirdOrFifthDigitsEven = firstDigitID % 2 == 0 || thirdDigitID % 2 == 0 ||
                   fifthDigitID % 2 == 0;
        boolean isFirstThirdFifthDigitsOdd = firstDigitID % 2 != 0 && thirdDigitID % 2 != 0 &&
                fifthDigitID % 2 != 0;
        boolean isFirstThirdFifthDigitsEven = firstDigitID % 2 == 0 && thirdDigitID % 2 == 0 &&
                fifthDigitID % 2 == 0;

        if (firstSixDigits > 10){
            seventhDigitID = 7;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        } else if (firstSixDigits < 10){
            seventhDigitID = 6;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        } else if(firstSixDigitComparison){
            seventhDigitID = 5;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        } else if(isFirstSixDigitsAreEqual){
            seventhDigitID = 4;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        } else if(isFirstAndSecondDigitsEven || isThirdFourthFifthDigitsOdd){
            seventhDigitID = 3;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        }  else if(isFirstOrThirdOrFifthDigitsEven){
            seventhDigitID = 2;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        }  else if(isFirstThirdFifthDigitsOdd){
            seventhDigitID = 1;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        }  else if(isFirstThirdFifthDigitsEven){
            seventhDigitID = 0;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        } else {
            seventhDigitID = 9;
            System.out.println("7th Seventh Digit is: " + seventhDigitID);
        }

        int eighthDigitID = 0;                                                      //Eight Digit
        int oddNumberGenerator = 0;
        int evenNumberGenerator = 0;

        while(oddNumberGenerator % 2 == 0)
            oddNumberGenerator = randomGenerator.nextInt((9 + 1-1) + 1);
        System.out.print("odd number between 1 and is 9: ");
        System.out.println(oddNumberGenerator);

         evenNumberGenerator = randomGenerator.nextInt(8); evenNumberGenerator = (evenNumberGenerator * 2) % 10;
        System.out.print("Even number between 1 and  8 is: ");
        System.out.println(evenNumberGenerator);

        if(age >= 18 && isClientOverWeight && fifthQuestion == OFTEN){
            eighthDigitID = oddNumberGenerator;
            System.out.println("8th Eighth Digit ID  is: " + eighthDigitID);
        } else if(age <18 && isClientIdealAthleticWeight && firstQuestion == SELDOM) {
            eighthDigitID = evenNumberGenerator;
            System.out.println("8th Eighth Digit ID  is: " + eighthDigitID);
        } else {
            System.out.println("8th Eighth Digit ID  is: " + eighthDigitID);
        }

        int ninthDigit = 0;
        int digitA = 0;
        int digitB = 0;

        boolean isFirstDigitTheGreatest = firstDigitID > thirdDigitID &&                //Odd numbers
                firstDigitID > fifthDigitID && firstDigitID > seventhDigitID;
        boolean isThirdDigitTheGreatest = thirdDigitID > firstDigitID && thirdDigitID > fifthDigitID
                && thirdDigitID > seventhDigitID;
        boolean isFifthDigitTheGreatest = fifthDigitID > firstDigitID &&
                fifthDigitID > thirdDigitID && firstDigitID > seventhDigitID;
        boolean isSeventhDigitTheGreatest = seventhDigitID > firstDigitID &&
                seventhDigitID > thirdDigitID && seventhDigitID > fifthDigitID;

        boolean isSecondDigitTheGreatest = secondDigitID > fourthDigitID &&                //Even numbers
                secondDigitID > sixthDigitID && secondDigitID > eighthDigitID;
        boolean isFourthDigitTheGreatest = fourthDigitID > secondDigitID &&
                fourthDigitID > sixthDigitID && fourthDigitID > eighthDigitID;
        boolean isSixthDigitTheGreatest = sixthDigitID > secondDigitID &&
                sixthDigitID > fourthDigitID && sixthDigitID > eighthDigitID;
        boolean isEighthDigitTheGreatest = eighthDigitID > secondDigitID &&
                eighthDigitID > fourthDigitID && eighthDigitID > sixthDigitID;

        if (isFirstDigitTheGreatest){
            digitA = firstDigitID;
            System.out.println("DIGIT A IS: " + digitA);
        } else  if (isThirdDigitTheGreatest){
            digitA = thirdDigitID;
            System.out.println("DIGIT A IS: " + digitA);
        } else  if (isFifthDigitTheGreatest){
            digitA = fifthDigitID;
            System.out.println("DIGIT A IS: " + digitA);
        } else  if (isSeventhDigitTheGreatest){
            digitA = seventhDigitID;
            System.out.println("DIGIT A IS: " + digitA);
        }

        if (isSecondDigitTheGreatest){
            digitB = secondDigitID;
            System.out.println("DIGIT B IS: " + digitB);
        } else  if (isFourthDigitTheGreatest){
            digitB = fourthDigitID;
            System.out.println("DIGIT B IS: " + digitB);
        } else  if (isSixthDigitTheGreatest){
            digitB = sixthDigitID;
            System.out.println("DIGIT B IS: " + digitB);
        } else  if (isEighthDigitTheGreatest){
            digitB = eighthDigitID;
            System.out.println("DIGIT B IS: " + digitB);
        }

        boolean isDigitAGreater = digitA > digitB;
        boolean isDigitALesser = digitA < digitB;
        boolean isDigitAAndDigitBEqual = digitA == digitB;
        boolean isDigitAEqualsNine = digitA == 9;
        boolean isDigitAEqualsZero = digitB == 0;

        if (isDigitAGreater){
            ninthDigit = digitA + 1;
            System.out.println("9th Digit is: " + ninthDigit);
        } else if (isDigitAGreater && isDigitAEqualsNine){
            ninthDigit = 0;
            System.out.println("9th Digit is: " + ninthDigit);
        } else if (isDigitALesser) {
            ninthDigit = digitA - 1;
            System.out.println("9th Digit is: " + ninthDigit);
        } else if (isDigitALesser && isDigitAEqualsZero){
            ninthDigit = 1;
            System.out.println("9th Digit is: " + ninthDigit);
        } else if (isDigitAAndDigitBEqual) {
            ninthDigit = 0;
            System.out.println("9th Digit is: " + ninthDigit);
        }

        System.out.println("Your Client ID is: ");
        System.out.print(firstDigitID);
        System.out.print(secondDigitID);
        System.out.print(thirdDigitID);
        System.out.print(fourthDigitID);
        System.out.print(fifthDigitID);
        System.out.print(sixthDigitID);
        System.out.print(seventhDigitID);
        System.out.print(eighthDigitID);
        System.out.println(ninthDigit);

        String asterisk = "*";
        String exclamationMark = "!";
        String atTheRateSign = "@";
        String numberSign = "#";
        String dollarSign = "$";
        String moduloSign = "%";
        String circumflex = "^";
        String ampersand = "&";
        String slash = "/";
        String plus = "+";

        System.out.println("Your barcode is: ");

        if(firstDigitID == 0 ){
            System.out.print(asterisk);
        } else if(firstDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(firstDigitID == 2 ){
        System.out.print(atTheRateSign);
    } else if(firstDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(firstDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(firstDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(firstDigitID == 6 ){
            System.out.print(circumflex);
        } else if(firstDigitID == 7 ){
            System.out.print(ampersand);
        } else if(firstDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(secondDigitID == 0 ){
            System.out.print(asterisk);
        } else if(secondDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(secondDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(secondDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(secondDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(secondDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(secondDigitID == 6 ){
            System.out.print(circumflex);
        } else if(secondDigitID == 7 ){
            System.out.print(ampersand);
        } else if(secondDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(thirdDigitID == 0 ){
            System.out.print(asterisk);
        } else if(thirdDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(thirdDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(thirdDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(thirdDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(thirdDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(thirdDigitID == 6 ){
            System.out.print(circumflex);
        } else if(thirdDigitID == 7 ){
            System.out.print(ampersand);
        } else if(thirdDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(fourthDigitID == 0 ){
            System.out.print(asterisk);
        } else if(fourthDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(fourthDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(fourthDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(fourthDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(fourthDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(fourthDigitID == 6 ){
            System.out.print(circumflex);
        } else if(fourthDigitID == 7 ){
            System.out.print(ampersand);
        } else if(fourthDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(fifthDigitID == 0 ){
            System.out.print(asterisk);
        } else if(fifthDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(fifthDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(fifthDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(fifthDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(fifthDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(fifthDigitID == 6 ){
            System.out.print(circumflex);
        } else if(fifthDigitID == 7 ){
            System.out.print(ampersand);
        } else if(fifthDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(sixthDigitID == 0 ){
            System.out.print(asterisk);
        } else if(sixthDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(sixthDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(sixthDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(sixthDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(sixthDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(sixthDigitID == 6 ){
            System.out.print(circumflex);
        } else if(sixthDigitID == 7 ){
            System.out.print(ampersand);
        } else if(sixthDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(seventhDigitID == 0 ){
            System.out.print(asterisk);
        } else if(seventhDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(seventhDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(seventhDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(seventhDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(seventhDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(seventhDigitID == 6 ){
            System.out.print(circumflex);
        } else if(seventhDigitID == 7 ){
            System.out.print(ampersand);
        } else if(seventhDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(eighthDigitID == 0 ){
            System.out.print(asterisk);
        } else if(eighthDigitID == 1 ){
            System.out.print(exclamationMark);
        }   else if(eighthDigitID == 2 ){
            System.out.print(atTheRateSign);
        } else if(eighthDigitID == 3 ) {
            System.out.print(numberSign);
        } else if(eighthDigitID == 4 ){
            System.out.print(dollarSign);
        } else if(eighthDigitID == 5 ){
            System.out.print(moduloSign);
        } else if(eighthDigitID == 6 ){
            System.out.print(circumflex);
        } else if(eighthDigitID == 7 ){
            System.out.print(ampersand);
        } else if(eighthDigitID == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }

        if(ninthDigit == 0 ){
            System.out.print(asterisk);
        } else if(ninthDigit == 1 ){
            System.out.print(exclamationMark);
        }   else if(ninthDigit == 2 ){
            System.out.print(atTheRateSign);
        } else if(ninthDigit == 3 ) {
            System.out.print(numberSign);
        } else if(ninthDigit == 4 ){
            System.out.print(dollarSign);
        } else if(ninthDigit == 5 ){
            System.out.print(moduloSign);
        } else if(ninthDigit == 6 ){
            System.out.print(circumflex);
        } else if(ninthDigit == 7 ){
            System.out.print(ampersand);
        } else if(ninthDigit == 8 ){
            System.out.print(slash);
        } else {
            System.out.print(plus);
        }
    }
}