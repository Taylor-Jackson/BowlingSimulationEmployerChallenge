This program was created in response to a challenge given to me from an employer.

The goal of this project is to simulate a game of bowling between 2-4 players.
The game should be kept track of frame-by-frame with a total score and winner at the end.

At first I went over my head and tried programming this in Unity to give a great visual interface,
but I ended up hitting a difficulty block with how to read a lot of user input efficiently. I scrapped it
and switched to Java two days before the deadline and finished the challenge. I realize I should have thought 
about my process a little more and I take full responsibility for any seemingly sloppy or rushed work.

I created one class to operate on the cards. The class has ArrayList variables that stored the integer
data for the score cards and methods to run calculations and store data for them. Covering all instances of 
scoring took a lot of thinking and troubleshooting. The calculation of the cards uses a 
series of different branching if-else structures to determine what is being bowled and 
the appropriate way to process it. I created calculateStrike and calculateSpare in order to simplfy
the code in the calculateCard method.

NOTE TO EMPLOYERS READING***

My main class is long and messy. Looking back, I should have created a class structure that housed 
the process for each individual player bowling. As of right now, the program cannot expand beyond four players like 
it could if the process for reading input and printing all the prompts was housed in a smaller class.

Thanks for reading!

Taylor Jackson
10/2/2020
