****************
* Assignment 1: Warmup
* CS 221 Section 1
* Jan 23, 2019
* Aidan VanLeuven
**************** 

OVERVIEW:

This program takes properly formatted files and checks to 
see if they are magic squares. It can also create a new
magic square as long as the size is odd.


INCLUDED FILES:

* MagicSquare.java - the main logic for the checker and
magic square creator
* MagicSquareDriver.java - Driver class for the program
* README - this file


COMPILING AND RUNNING:

From the directory containing all source files, compile the
driver class (and all dependencies) with the command:

```$ javac *.java```

Run the compiled class file with the command:

```$ java MagicSquareDriver [-check | -create] [filename] [size]```

Size is only required if the "-create" flag is used. It must be odd.

Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

All logic and formatting in this program is handled by the 
MagicSquare class. The only purpose the MagicSquareDriver has
is to get command line arguments, check for some basic errors,
and run the program and return its output.

The checkMatrix method takes a file from the driver as an input.
It uses two scanners, one for the rows, and one for the columns.
It then stores the size and loads the rest of the data into a 2d
array. A regular array is created with the data as well, and then is
sorted in ascending order to make checking easier. Lines 67-71 make
sure that each integer is present. The magic number is calculated,
and each row and column are looped through, added together, and
compared to the magic number.

The createMagicSquare method takes in a name of a file, and a magic
square size. It then fills in a 2d array with numbers as required.
It uses the 2d array to make a properly formatted output, and then
writes that output to the filename that was provided. I just used the
pseudocode on the project description straight out of the box with
little to no modifications.

The outputValues method is used by the checkMatrix method, as a way 
to separate out some of the string editing from the main logic. I
think doing this has made the code more readable. If I had more time,
I would probably make it so both functions could use the outputValues
method to return the final output.

TESTING:

I used all of the test files included in Magic.zip for testing, as 
well as creating new magic squares and then testing them. I've gone
through all of the cases that I can think of and it seems fairly
"idiot-proof" to me. The only thing I can think of that might break
this would be an improperly formatted magic square file.


DISCUSSION:

This assignment was overall not super difficult. I skipped over a 
line in the pseudocode that had me scratching my head for a while,
but that was my own fault. This was actually a pretty fun 
assignment to do, and I think I came up with some pretty elegant 
solutions to a couple of the problems. This uses a lot of loops,
so it probably isn't the most performant code ever, but it does 
pretty well, even when creating huge magic squares. I was able to
get a size 401 magic square and check its validity on my machine. 
I also used Git and GitHub for version control on this, and to sync
my code between my laptop and desktop. Pretty cool! You can check it
out [here](https://github.com/aidanvanleuven/cs221-1) if you'd like.
