import java.util.Scanner;

public class SafeInput
{

    /**
     * Return a user supppled int within the specified range
     * @param pipe The scanner instance to sue for the console input
     * @param prompt A string that tells the user what to input
     * @param low The lower bound for the range of valid values
     * @param high The upper bound for the range of valid vaules
     * @return It returns and integer within range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear line from buffer
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You said your ret val is " + retVal + " but that is out of range [" + low + " - " + high + "]:");
                }


            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("you entered " + trash + " that is not a valid input");
            }


        } while (!done);
        return retVal;

    }

    /**
     * returns a user supplied int of an arbitrary value
     * @param pipe The Scanner to use for the input
     * @param prompt The string prompt telling the user what to input
     * @return an arbitrary integer of any value
     */
    public static int getInt (Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You inputted " + trash + " That is not a valid input");
            }

        } while (!done);
        return retVal;
    }

    /**
     * returns a user supplied int of an arbitrary value
     * @param pipe The Scanner to use for the input
     * @param prompt The string prompt telling the user what to input
     * @return an arbitrary integer of any value
     */
    public static double getDouble (Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You inputted " + trash + " That is not a valid input");
            }

        } while (!done);
        return retVal;
    }

    /**
     * get a double value with a specified inclusive range
     *
     * @param pipe Scanner to read the console
     * @param prompt The prompt to tell the user what to input
     * @param low The low value for the range
     * @param high The high value for the range
     * @return return a double within the specified range
     */
    public static Double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear line from buffer
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You said your number is " + retVal + " but that is out of range [" + low + " - " + high + "]:");
                }


            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("you entered " + trash + " that is not a valid input");
            }


        } while (!done);
        return retVal;

    }


    /**
     * Gets a string with at least one character
     *
     * @param pipe Scanner to use for input
     * @param prompt String prompt to tell a user what to input
     * @return returns a non zero length string to the user
     */
    public static String getNonZeroLengthString(Scanner pipe, String prompt)
    {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.length() != 0)
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter at least one character.");
            }

        } while (!done);
        return retVal;
    }

    /**
     * Takes a Y or an N and returns true or false respectively
     *
     * @param pipe Scanner to use for console input
     * @param prompt The prompt given to the user
     * @return The return YN in the form of a boolean
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean done = false;
        String inputYN = "";

        do
        {

            System.out.print(prompt + "[Y/N]: ");
            inputYN = pipe.nextLine();
            if (inputYN.equalsIgnoreCase("Y"))
            {
                done = true;
                retVal = true;
            }
            else if (inputYN.equalsIgnoreCase("N"))
            {
                done = true;
                retVal = false;
            }
            else
            {
                System.out.println("invalid input you entered " + inputYN + "You must enter Y or N");
            }

        } while (!done);
        return retVal;
    }

    /**
     * Gets a string that matches a RegEX pattern like ###-##-#### \d{3}-\d{2}-\d{4}
     *
     * @param pipe Scanner to use for input
     * @param prompt String prompt to tell the user what to input
     * @param regEx A string that matches the regex formatting
     * @return
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;


        do {

            System.out.print(prompt + ":");
            retVal = pipe.nextLine();

            if (retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter a string that matches the pattern" + regEx);
            }


        } while (!done);
        return retVal;
    }

    /**
     * A program that takes an input and makes a message like at the top of a recipt
     *
     * @param msg That is the message that you want to appear on the top. It has to be below thirty characters to work properly
     */
    public static void prettyHeader(String msg)
    {
        int prettyMid = 30 -1 - msg.length();

        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();
        System.out.print("***");
        for (int i = 0; i < prettyMid; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < prettyMid; i++) {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();


        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

    }
    /**
     * Takes an array and gets it's sum
     *
     * @param values The array that you are using
     * @return The sum
     */
    public static int sum(int values[])
    {
        int retVal = 0;
        for (int i = 0; i < values.length; i++)
        {
            retVal += values[i];
        }

        return retVal;
    }

    /**
     * This code averages out the array
     *
     * @param values the array that you are using
     * @return The average
     */
    public static int getAverage(int values[])
    {
        int sum = 0;
        int retVal = 0;
        for (int i = 0; i < values.length; i++)
        {
            sum += values[i];
        }
        retVal = sum / values.length;

        return retVal;
    }

    /**
     * This program takes the number of occurances of a certain number in an array of numbers and returns it to the user
     *
     * @param values The array that it scans
     * @param target The target value the program is looking for.
     * @return
     */
    public static int occuranceScan(int values[], int target)
    {
        int retval = 0;
        boolean done = false;
        for (int i = 0; i < values.length; i++) {
            if(values[i] == target) {
                retval++;
                done = true;
            }
        }
        return retval;
    }

    /**
     * Program that finds the minumum and returns its value
     *
     * @param values The array that it is looking through
     * @return the minimum
     */
    public static int min(int values[])
    {
        int min = values[0];

        for (int i = 0; i < values.length; i++) {
            if (values [i] < min) // new min
                min = values[i]; // so save it
        }
        return min;
    }

    /**
     * A program that takes an array and finds the max
     *
     * @param values The array that it is looking through
     * @return the maximum
     */
    public static int max(int values[])
    {
        int max = values[0];

        for (int i = 0; i < values.length; i++) {
            if (values [i] > max) // new max
                max = values[i]; // so save it

        }
        return max;
    }

    /**
     *
     * @param values This is the array you are searching
     * @param target This is the target you want to know if it is in the array
     * @return This is a boolean that is true if it finds the target
     */
    public boolean contains(int values[], int target)
    {
        boolean retval = false;
        boolean done = false;
        for (int i = 0; i < values.length; i++) {
            if(values[i] == target) {
                retval = true;
            }
        }
        return retval;
    }

}
