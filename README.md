# chess
RedSky chess code

Chess Build Instructions
1) Install the following
   a. Maven 3
   b. GIT (command line)
   c. Java (The latest version)
2) Make a directory for the source code
3) Go into that directory you made
4) Type 'git clone https://github.com/ddemott/chess' without the single quotes.  This should pull the code down
5) Type 'mvn clean install'
6) Type 'cd target'
7) Type 'dir *.jar'.  You should get a jar file.  This is the file you want to execute.
8) To start the application type 'java -jar chess-0.0.1-SNAPSHOT.jar’.

This will start up the built-in application server and kick off the application locally.  Now just hit the URLs below in an open browser while leaving this window open.


Chess Instruction

RESETTING / QUITTING

To reset the board simply use one of the following the urls.  All are mapped to the same action

http://localhost:8080/chess/reset
http://localhost:8080/chess/resetboard
http://localhost:8080/chess/quit

STATUS

To see the status of the board which is the entire layout of the board type use the following url.  Both are mapped to the same action

http://localhost:8080/chess/status
http://localhost:8080/chess/boardstatus

MOVING

http://localhost:8080/chess/move/x1/{x1}/y1/{y1}/x2/{x2}/y2/{y2}
{x1} represents the starting x position on the board from 1 to 8
{y1} represents the starting y position on the board from 1 to 8
{x2} represents the destination x position on the board from 1 to 8
{y2} represents the destination y position on the board from 1 to 8

The board is set up with White on the bottom and Black on the top.  If you wanted to move
your left most white pawn forward 2 (since it is the first move), you would use the following
url

http://localhost:8080/chess/move/x1/1/y1/2/x2/1/y2/4

This would advance your pawn 2 spaces.
After each action a status is returned to if your move was successful.

An example of seeing the entire state of the board would be 
http://localhost:8080/chess/status

This will give you the entire board in JSON format.  I've only given you a small, snippet of it so you can get the idea of the JSON passed back.

NOTE: 
	The x,y coordinates in the json are 0 based.  The movement of the pieces are 1 based.
	The Pawn has a firstMoveAvailable flag on it.  The first move you can move 2 forward but only if it is the first move.
	To quit the application hit Control-C a few times in the server window where you executed your java -jar command.  

{  
   "boardPieces":[  
      [  
         {  
            "name":"Rook",
            "color":"White",
            "x":0,
            "y":0
         },
         {  
            "name":"Pawn",
            "color":"White",
            "x":0,
            "y":1,
            "firstMoveAvailable":true
         },
         {  
            "name":"",
            "color":"",
            "x":0,
            "y":2
         },
         {  
            "name":"",
            "color":"",
            "x":0,
            "y":3
         },
         {  
            "name":"",
            "color":"",
            "x":0,
            "y":4
         },
         {  
            "name":"",
            "color":"",
            "x":0,
            "y":5
         },
         {  
            "name":"Pawn",
            "color":"Black",
            "x":0,
            "y":6,
            "firstMoveAvailable":true
         },
         {  
            "name":"Rook",
            "color":"Black",
            "x":0,
            "y":7
         }
      ],
      [  
         {  
            "name":"Knight",
            "color":"White",
            "x":1,
            "y":0
         },


...

Thanks

Dale DeMott
