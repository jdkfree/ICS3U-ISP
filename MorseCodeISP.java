/*
Justin Freemanlte
Jan 15 2018
ICS3U Ms. Krasteva
This program will displaymy ICS ISP, a Morse code teach, test, and translator.

Name                 Type          Purpose
------------------------------------------------
letter               String[]      Stores all letters, numbers, and spaces
morse                String[]      Stores all morse code letters, spaces, and slashes used for translation 
sentence             String        
morseLine            String
choice               char
translation          char
translateLetter      Sting
player               String
HIGHNAMES            final int
name                 String[]
scores               double[]
highScore            int[]
currentScore         double
correctAns           int
output               Printwriter
input                BufferedReader
fileName             String
*/
// import
import java.awt.*;
import hsa.Console;
import java.io.*;
import javax.swing.JOptionPane;

//the MorseCodeISP class
public class MorseCodeISP
{
    //variable declaration
    Console c;
    String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "/", " "};
    String sentence;
    String morseLine;
    char choice;
    char translation;
    String translateLetter;
    String player;
    final int HIGHNAMES = 10;
    String[] name = new String [HIGHNAMES];
    double[] scores;
    int[] highScore = new int [HIGHNAMES];

    double currentScore;
    int correctAns;
    PrintWriter output;
    BufferedReader input;
    String fileName = "MorseCodeHighScores.txt";

    //creates the cosole
    public MorseCodeISP ()
    {
	c = new Console ("Morse Code Teach and Test");
    }


    //usedto pause the program so the user can read all info before the program continues
    public void pauseProgram ()
    {
	c.println ();
	c.println ("Press any key to continue...");
	c.getChar ();
    }


    //creates the title
    public void title ()
    {
	c.clear ();
	c.print (' ', 28);
	c.println ("Morse Code Teach and Test");
	c.println ();
    }


    //the introduction to the program
    public void intro ()
    {
	//fills the high scores arrays
	for (int i = 0 ; i < HIGHNAMES ; i++)
	{
	    name [i] = "Player";
	    highScore [i] = 0;
	}

	title ();
	c.print ("Welcome to Morse Code Teach and Test! This program will teach you the basic     ");
	c.print ("translations of morse code and test you on them! There is also a translator     ");
	c.println ("that can translate from english to morse code and vice versa.");
	pauseProgram ();
    }


    //displays the instructions to the user
    public void instructions ()
    {
	title ();
	c.print ("From the menu, select your option. Learning will show you the direct letter");
	c.print ("     translations and show you the basics of morse code. There is a quiz you can");
	c.print ("take to test yourself on your knowledge. In the translator, you can");
	c.print (" enter a morse    code phrase or english word and translate it. When you're");
	c.println (" done, enter 'quit'    from the main menu.");
	c.println ();
	c.println ("Translator instructions:");
	c.println ("After selecting 'translator' from the main menu, select whether you would like  to translate from English to morse code or vice versa.");
	c.println ("    i) English to morse code");
	c.println ("        Enter any English sentence. Only letters and numbers are accepted.");
	c.println ("    ii) Morse code to English");
	c.println ("        Enter any morse code phrase. The phrase may only contain dots           ");
	c.print ("(periods), dashes, slashes and spaces. The morse code must have spaces between  each letter, with slashes denoting spaces between words (in an English sentence)");
	c.println ();
	c.println ("In addition, a space must be added before and after every slash.");
	c.println ("ex. Given that 'h' = '....' , 'i' = '..' , 'b' = '-...' , 'y' = '-.--' , and    'e' = '.' ,");
	c.println ("'hi bye' would translate to '.... .. / -... -.-- .'");
	pauseProgram ();

	title ();
	c.println ("Test instrctions:");
	c.println ("Enter your name, and the test will give you 10 randomly selected questions to   answer. English answers must be given in lowercase. Good luck!");
	pauseProgram ();
    }

    //draws the splash screen, the introductory animation before the code runs
    public void splashScreen ()
    {
    // calls the splash screen class
	SplashScreen a = new SplashScreen (c); 
	a.start ();

    }

    // displays the main menu, where the user can navigate through the program and choose what to do
    public void mainMenu ()
    {
	title ();
	//prompt
	c.println ("Please enter the number corresponding to your choice");
	c.println ();
	//options
	c.println ("1) Morse Code Learning");
	c.println ("2) Morse Code Testing");
	c.println ("3) Translator");
	c.println ("4) High Scores");
	c.println ("5) Instructions");
	c.println ("6) Exit");
	
	//error trapping if user inputs correct values
	do
	{
	    choice = c.getChar ();
	    if (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5' && choice != '6')
	    {
		JOptionPane.showMessageDialog (null, "Sorry, please enter a number from 1 to 6!", "Error", JOptionPane.ERROR_MESSAGE); //error message
	    }
	}
	while (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5' && choice != '6');

    }


    // Teaches the user the morse code translations
    public void codeTeach ()
    {
	title ();
	//translation chart
	c.println ("Here is a chart which shows the letter and number conversions.");
	c.println ("a  .-      t  -       1  .----");
	c.println ("b  -...    u  ..-     2  ..---");
	c.println ("c  -.-.    v  ...-    3  ...--");
	c.println ("d  -..     w  .--     4  ....-");
	c.println ("e  .       x  -..-    5  .....");
	c.println ("f  ..-.    y  -.--    6  -....");
	c.println ("g  --.     z  --..    7  --...");
	c.println ("h  ....               8  ---..");
	c.println ("i  ..                 9  ----.");
	c.println ("j  .---               0  -----");
	c.println ("k  -.-");
	c.println ("l  .-..");
	c.println ("m  --");
	c.println ("n  -.");
	c.println ("o  ---");
	c.println ("p  .--.");
	c.println ("q  --.-");
	c.println ("r  .-.");
	c.println ("s  ...");

	pauseProgram ();
	title ();
	//displays tips on learning morse code
	c.println ("Helpful tips:");
	c.println ();
	c.println ("1) If a morse code phrase has 5 characters, it is always a number.");
	c.println ("2) For numbers 1-9, as the numbers increase, the number of dots increases and   decreases.");
	c.println ("3) You can replace . with 'dit' and - with 'dah' if you are an auditory learner.");
	c.println ("   Ex. -..- becomes 'dah dit dit dah'");
	c.println ("4) Pratice makes perfect! Keep doing the test to enhance your skills!");
	pauseProgram ();
    }

    // A method to test the user on their morse code knowledge
    public void codeTest ()
    {
	title ();
	correctAns = 0;
	int hold;
	String holdName;


	//gets the student name
	c.print ("Please enter your name: ");
	player = c.readLine ();
	
	//Repeats for 10 questions
	for (int i = 0 ; i < 10 ; i++)
	{
	    //randomizes the question
	    int type = (int) (Math.random () * 2 + 1);
	    int character = (int) (Math.random () * 36);
	    
	    // if asking a letter to morse code
	    if (type == 1)
	    {
		c.print ("Question " + (i + 1) + ")  ");
		c.println ("What is \" " + letter [character] + " \" in morse code?");
		
		//if the user enters the correct answer adds one to answer count
		if (c.readLine ().equals (morse [character].trim ()))
		{
		    correctAns++;
		}
	    }
	    // if asking a morse code to letters
	    else
	    {
		c.print ("Question " + (i + 1) + ")  ");
		c.println ("What is \" " + morse [character] + " \" in English?");
		
		//if the user enters the correct answer adds one to answer count
		if (c.readLine ().equals (letter [character].trim ()))
		{
		    correctAns++;
		}
	    }
	}
	//if the user gets 70% or more
	if (correctAns > 6)
	{
	    c.println ("Your score was " + correctAns + " / 10. Good Work!");
	    pauseProgram ();
	}
	// if the user gets 60% or less
	else
	{
	    c.println ("Your score was " + correctAns + " / 10. Review the material and try again!");
	    pauseProgram ();
	}
	
	//bubble sorts high scores
	for (int i = 0 ; i < name.length - 1 ; i++)
	{
	    for (int j = 0 ; j < name.length - 1 ; j++)
	    {
		if (correctAns > highScore [j])
		{
		    //switches lower and higher scores
		    hold = correctAns;
		    correctAns = highScore [j];
		    highScore [j] = hold;
		    
		    holdName = player;
		    player = name [j];
		    name [j] = holdName;
		}
	    }
	}
	//writes new scores to the files
	try
	{
	    //opens the file
	    output = new PrintWriter (new FileWriter (fileName));
	    // the length of the high scores arrays 
	    for (int i = 0 ; i < HIGHNAMES ; i++)
	    {
		output.println (name [i]);
		output.println (highScore [i]);
	    }
	    output.close ();
	}
	//catches any file exceptions
	catch (IOException e)
	{
	}
    }

    // Can translate the user input (String to morse code or vice versa) 
    public void translator ()
    {
	title ();

	boolean validPhrase = true;
	boolean validMorse = true;
	String smallMorse = "";
	String filePhrase = "";

	// repeats until a valid input is entered
	do
	{
	    title ();
	    //user prompts
	    c.println ("Please select your translation: ");
	    c.println ();
	    c.println ("1) English to Morse Code");
	    c.println ("2) Morse Code to English");
	    c.println ("3) Write to file");
	    c.println ("4) Read from file and translate");
	    //gets user input
	    translation = c.getChar ();
	    if (translation != '1' && translation != '2' && translation != '3' && translation != '4')
	    {
		JOptionPane.showMessageDialog (null, "Sorry, please enter a number 1 through 4!", "Error", JOptionPane.ERROR_MESSAGE); //error message
	    }
	}
	while (translation != '1' && translation != '2' && translation != '3' && translation != '4');

	title ();
	
	// if the user wishes to translate from english to morse code
	if (translation == '1')
	{
	    //repeats until a valid phrase is entered
	    do
	    {
		title ();
		//prompt
		c.print ("Please enter what phrase you would like to translate (letters and numbers only):");
		//user input
		sentence = c.readLine ();
		//repeats for the length of the sentence to check every letter
		for (int i = 0 ; i < sentence.length () ; i++)
		{
		    for (int j = 0 ; j < letter.length ; j++)
		    {
			//if the inputted characters are not valid letters of numbers
			if (sentence.charAt (i) != letter [j].charAt (0))
			    validPhrase = false;
			else
			{
			    validPhrase = true;
			    break;
			}
		    }
		    //if the phrase is not valid
		    if (validPhrase == false)
		    {
			JOptionPane.showMessageDialog (null, "Sorry, only letters and numbers are allowed!", "Error", JOptionPane.ERROR_MESSAGE); //error message
			break;
		    }
		}

	    }
	    while (validPhrase == false);
	}
	// if the user wants to translate a morse code to a string 
	else if (translation == '2')
	{
	    //repeats until a valid user input
	    do
	    {
		title ();
		//user prompt
		c.print ("Please enter what phrase you would like to translate (dots, dashes, spaces, and ");
		c.print ("backslashes only): ");
		//user input
		morseLine = c.readLine ();
		//splits inputted string into different parts seperated by a space
		String[] splitString = morseLine.split (" ");
		//checks if only dots, dashes, spaces, and slashes are used
		for (int i = 0 ; i < morseLine.length () ; i++)
		{
		    if (morseLine.charAt (i) != ' ' && morseLine.charAt (i) != '.' && morseLine.charAt (i) != '/' && morseLine.charAt (i) != '-')
		    {
			validMorse = false;
			JOptionPane.showMessageDialog (null, "Sorry, only dots, dashes, spaces, and slashes are allowed!", "Error", JOptionPane.ERROR_MESSAGE); //error message
			break;
		    }
		    else
			validMorse = true;

		}
		//checks if morse code uses only valid morse phrases
		if (validMorse == true)
		{
		    // for the amount of parts in split string
		    for (int i = 0 ; i < splitString.length ; i++)
		    {
		    	
			for (int j = 0 ; j < morse.length ; j++)
			{
			    // if the splitstring part can be translated to a valid morse code letter
			    if (splitString [i].equals (morse [j]))
			    {
				validMorse = true;
				break;
			    }
			    else
				validMorse = false;
			}
			if (validMorse == false)
			{
			    JOptionPane.showMessageDialog (null, "Sorry, your input is not a valid morse code. Please enter a valid morse code and try again!", "Error", JOptionPane.ERROR_MESSAGE); //error message
			    break;
			}
		    }
		}
	    }
	    while (validMorse == false);
	}
	//if the user wants to store a string to a file
	else if (translation == '3')
	{   
	    //prompt
	    c.println ("Please enter the sentence/phrase you would like to store:");
	    try
	    {
		output = new PrintWriter (new FileWriter ("WordStorage.txt"));
		output.println (c.readLine ());
		output.close ();
	    }
	    //catches file errors
	    catch (IOException e)
	    {
	    }
	    // success message
	    c.println ("Successfully uploaded to the file 'WordStorage.txt'");
	}
	//if the user wants to translate a word from a file
	else if (translation == '4')
	{   
	    // gets string from the file
	    try
	    {
		input = new BufferedReader (new FileReader ("WordStorage.txt"));

		filePhrase = input.readLine ();
		c.println ("The sentence/phrase in the file is:");
		c.println (filePhrase);
	    }
	    //catches file erros
	    catch (IOException e)
	    {
	    }
	    validMorse = false;
	    validPhrase = false;
	    //splits inputted string into different parts seperated by a space
	    String[] splitString = filePhrase.split (" ");

	    //checks if morse code uses only valid phrases

	    for (int i = 0 ; i < splitString.length ; i++)
	    {
		for (int j = 0 ; j < morse.length ; j++)
		{
		    if (splitString [i].equals (morse [j]))
		    {
			validMorse = true;
			break;
		    }
		    else
			validMorse = false;
		}
		if (validMorse == false)
		{
		    break;
		}
	    }

	    for (int i = 0 ; i < filePhrase.length () ; i++)
	    {
		for (int j = 0 ; j < letter.length ; j++)
		{
		    if (filePhrase.charAt (i) != letter [j].charAt (0))
			validPhrase = false;
		    else
		    {
			validPhrase = true;
			break;
		    }
		}
		if (validPhrase == false)
		{
		    break;
		}
	    }

	    if (validPhrase == false && validMorse == false)
	    {
		JOptionPane.showMessageDialog (null, "Sorry, your input cannot be translated. Store another value to the file and try again", "Error", JOptionPane.ERROR_MESSAGE);                          //error message
	    }
	}


	if (translation == '1')
	{
	    c.print ("Your morse code line is: ");
	    c.print (morseTranslator (sentence));
	}


	else if (translation == '2')
	{
	    c.print ("Your sentence is: ");
	    c.print (stringTranslator (morseLine));
	}

	else if (translation == '4')
	{
	    if (validMorse == true)
	    {
		c.print ("Your translated sentence is: ");
		c.print (stringTranslator (filePhrase));
	    }
	    else if (validPhrase == true)
	    {
		c.print ("Your translated phrase is: ");
		c.print (morseTranslator (filePhrase));
	    }
	}
	pauseProgram ();
    }


    private String morseTranslator (String input)
    {
	String small = "";

	input = input.trim ();

	for (int i = 0 ; i < input.length () ; i++)
	{
	    for (int j = 0 ; j < letter.length ; j++)
	    {
		if (input.charAt (i) == letter [j].charAt (0))
		{
		    small += morse [j];
		    small += " ";
		}
	    }
	}


	return small;
    }


    private String stringTranslator (String input)
    {
	String[] splitString = input.split (" ");
	String small = "";

	for (int i = 0 ; i < splitString.length ; i++)
	{
	    for (int j = 0 ; j < morse.length ; j++)
	    {
		if (morse [j].equals (splitString [i]))
		{
		    small += letter [j];
		    break;
		}
	    }
	}


	return small;
    }


    public void highScores ()
    {
	title ();
	char clearScores;

	try
	{
	    input = new BufferedReader (new FileReader (fileName));

	    for (int i = 0 ; i < HIGHNAMES ; i++)
	    {
		name [i] = input.readLine ();
		highScore [i] = Integer.parseInt (input.readLine ());
	    }
	    input.close ();

	}


	catch (IOException e)
	{
	}


	catch (NumberFormatException e)
	{
	}


	c.println ("High Scores");
	c.println ();
	for (int i = 0 ; i < HIGHNAMES ; i++)
	{
	    c.print (name [i] + " ");
	    c.println (highScore [i]);
	}


	c.println ("Press any key to continue, or 'c' to clear the high scores.");
	clearScores = c.getChar ();
	if (clearScores == 'c')
	{
	    try
	    {
		output = new PrintWriter (new FileWriter (fileName));
		for (int i = 0 ; i < HIGHNAMES ; i++)
		{
		    name [i] = "Player";
		    highScore [i] = 0;

		    output.println (name [i]);
		    output.println (highScore [i]);
		}
		output.close ();
	    }
	    catch (IOException e)
	    {
	    }
	}
    }


    public void goodbye ()
    {
	title ();
	c.println ("Thank you for using the Morse Code Teach and Test Program!");
	c.println ("Coded By: Justin Freemantle");
	try
	{
	    Thread.sleep (3000);
	}
	catch (Exception e)
	{
	}
    }


    public void quit ()
    {
	System.exit (0);
    }


    public static void main (String[] args)  //msin method
    {
	MorseCodeISP t = new MorseCodeISP ();

	t.splashScreen ();
	t.intro ();
	do
	{
	    t.mainMenu ();
	    if (t.choice == '1')
		t.codeTeach ();
	    else if (t.choice == '2')
	    {
		t.codeTest ();
		if (t.choice == '4')
		    t.highScores ();
	    }
	    else if (t.choice == '3')
		t.translator ();
	    else if (t.choice == '4')
		t.highScores ();
	    else if (t.choice == '5')
		t.instructions ();
	}
	while (t.choice != '6');
	t.goodbye ();
	t.quit ();
    }
}


