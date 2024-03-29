<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS 213 Spring 2023: Assignment 2</title>
<style>
body { font: 14px sans-serif, Trebuchet MS; width: 98%; margin-left:1%;}
a, a:visited { color: blue; }
table { border-collapse: collapse; cellspacing: 0px; margin-left: 10%;}
th { font: bold 14px Trebuchet MS; border-bottom: 1px solid black; padding: 10px;}
td { padding: 2px; font: 13px Trebuchet MS; }
td.pts { text-align: center; }
tt { color: blue; }
</style>
</head><body>
<center>
<h2>Assignment 2</h2>
<h2>2-Player Chess</h2>
<h3>Posted Tue, Feb 28
<p>First Bitbucket commit by EACH partner due <font color="red">Tue, Mar 7 11 PM</font>
<p>Complete implementation due <font color="red">Mon, Mar 27, 11 PM</font> in 
Bitbucket</h3>
<h3>Worth 100 points (10% of course grade.)</h3>
<h3><a href="../git_bitbucket.html">Git/Bucket How-To</a></h3>
</center>
<hr>
<p>For this assignment you will explore how to apply the object-oriented
design ideas you learned in class to design and implement the chess game.
You will continue working with your partner.
  
</p><p> Read the
<a href="http://www.cs.rutgers.edu/academics/undergraduate/academic-integrity-policy/programming-assignments">
DCS Academic Integrity Policy for Programmming Assignments</a> - you are responsible
for this. In particular, note that <b>"All Violations of the Academic
Integrity Policy will be reported by the instructor to the appropriate Dean".</b>
</p>

<p><font color="red">IMPORTANT</font>: 
Note that you will be maintaining your code in Bitbucket,
which is a source code repository. Learning how to manage your source code 
INCREMENTALLY and in COLLABORATION with your project partner is an important
skill, and Bitbucket (like Github) is a code repository that allows you to
do this effectively.

<hr>

You will implement the game
of <a href="http://en.wikipedia.org/wiki/Chess">Chess</a> for two
players.  Your program, when launched, should draw the board
<font color="red">in text, on the terminal</font> and prompt
whomever's turn it is (white or black) for a move. Once the move is
executed, the move should be played and the new board drawn, and the
other player queried.
</p>

<ul>
<li><a href="#output">Output</a>
<li><a href="#input">Input</a>
<li><a href="#end">Ending the game</a>
<li><a href="#grading">Grading</a>
<li><a href="#code">Submission/Code Maintenance in Bitbucket</a>
<li><a href="#faq">FAQs</a>
</ul>

<hr>

<h3><a name="output"></a>Output</h3>

<p>
The board should be drawn on the screen with ascii art <font color="red">EXACTLY</font>
as shown in this <a href="display.txt">example</a>. Note there is a blank line above
and below any prompt/message your program will print, and the board itself.

<p><font color="red">You will NOT use a graphical user interface</font>, 
that is not the point of this
assignment. If you do, your submission will NOT be graded.

<p><font color="red">You MUST have white make the first move.</font> 
Having black make the first move
is not appropriate, and will incur a penalty.

</p><p><b>Note:</b>
<ul>
<li>Every piece must know what moves are allowed on it. If a player attempts an
illegal move on a piece, your program should not execute the move. Instead, 
it should print "Illegal move, try again", followed by the usual prompt 
(for white's move or black's move). 

<p>You don't need to have a blank line 
between an attempted move, the illegal move warning, and the actual correct
move. You only need to have a blank line between the board drawing and a move.
<p><li>When a move is made, and it puts the opponent's King
under check, your program should print "Check" before prompting
for the opponent's move.
<p><li>If a checkmate is detected, your program should print "Checkmate"
<br>
<p><li>The last thing before termination should be a display of "Black wins",
"White wins" or "draw".
</ul>

</p><h3><a name="input"></a>Input</h3>

<p>
Your program needs to accept input of the form "FileRank FileRank", where the first file 
(column) and rank (row) are the coordinates of the piece to be moved, and the second file and 
rank are the coordinates of where it should end up. (See the board example shown above.) All inputs will be on the command line, one move at a time,
not through a file.
</p>

<p>
The figure immediately below should make it clear which rank and file combinations belong to 
which squares. The white pieces always intially occupy ranks 1 and 2. The black pieces always 
initially occupy ranks 7 and 8. The queen always starts on the d file.
</p>
<img src="SCD_algebraic_notation.svg">

<p>
As an example, advancing the white king's pawn two spaces would be input as "e2 e4".
</p>

<p>
A castling move is indicated by specifying where the king begins and ends.
So, white castling king's side would be "e1 g1".
</p>

<p>
A pawn promotion is indicated by putting the piece to be promoted to after the move. So, 
promoting a pawn to a knight might be "g7 g8 N". If no promotion piece is indicated, 
it is assumed to be a queen.
</p>

<p>
<a href="ex1.txt">Example of black winning</a>
</p>

<h3><a name="end"></a>Ending the game</h3>
<ul>
<li><p>
If checkmate occurs, the game shall end immediately with the result reported.
</p>
<p>
<li>A player may resign by entering "resign".
</p>
<ul>
<li><p>
<a href="ex_res_w.txt">Example of white resigning</a>
</p>
<li><p>
<a href="ex_res_b.txt">Example of black resigning</a>
</p>
</ul>
<li><p>
A player may offer a draw by appending "draw?" to the end of an otherwise regular move. When a draw is offered, the other player is obligated to accept, and the game
ends, whatever the actual situation may be. (No justification is needed.)
So the other player will simply 
submit "draw" as the entirety of their next move.
There will be no automatic draws (due to unchangeing positions over long periods of time, etc).
</p>
<ul>
<li><a href="ex_draw.txt">Example of a draw</a>
</ul>
</ul>
<p><font color="red">You are NOT required to implement termination by threefold repetition, or 
the fifty-move rule</font>. (You are welcome to include them in your code to make it complete;
however, there is no extra credit for either.)

<h3><a name="grading"></a>Grading</h3> 

<ul>
<li><b>Correctness, 90 pts</b>: Implementation of all required
functionality including drawing the board:
<ul>
<li>All legitimate basic moves for all pieces
<li>Castling
<li>Enpassant
<li>Promotion
<li>Identification of check
<li>Identifcation of checkmate
<li>Identification of illegal move (print "Illegal move, try again")
<li>Resign
<li>Draw
<li>Drawing board display as specified
</ul>
<p>Note: You are NOT required to implement stalemate.

<p><li><b>Javadoc, 10 pts</b>: Comment ALL classes, fields, and methods with 
<font color="red">Javadoc</font> tags (not just plain comments).
Also, make sure you record your name in each Java file with the @author Javadoc tag. 
<font color="red">Run javadoc to generate the Javadoc HTML documentation</font>
<p>There are numerous online resources that show how to write Javadoc comments,
and how to use the javadoc tool. Here's one such 
<a href="https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html">resource</a>.
It's pretty straightforward.
<p>
<li><b>Penalties (Including Lateness)</b>
<ul>
<li>5 pts: ANY deviation from specified format for drawing the board such as
extra spaces, extra blank lines, weird characters, other sketchy artwork, etc.
<li>5 pts: Game starts with black making the first move
<li>5 pts: Javadoc HTML not generated
<li>Up to 5 pts: Incomplete Javadoc tags in code
<li>5 pts (individual): No Bitbucket commit by Tue, Mar 7.
<li>10 pts: Every time you ask us and we test another commit version in your
repository that is earlier than the last commit before the deadline.
<li>10 pts: For every 2 hours of lateness, in case there is nothing
in the repository for us to test as of the deadline of Mar 27, 11 PM.<br>
<font color="red">NOTE: This 2 hour block will be applied STRICTLY starting any time
after 11 PM (even if it is one second), in increments of 2 hours. NO EXCEPTIONS.</font>
</ul>
</ul>

<hr>

<h3><a name="code"></a>Submission/Code Maintenance in Bitbucket
 (No, you may NOT use Github)</h3>

<p>Use the <a href="../git_bitbucket.html">Git/Bucket How-To</a>
to know how create a repository in Bitbucket (
<font color="red">and once again, NO, you may NOT use Github!!!</font>)
and manage it using Git. There
is a comprehensive walk through of all the features you need to know
to manage your code collaboratively. <font color="red">In particular, all Git examples
are shown on the command line, which is the recommended way to use Git
from your computer.</font> This is because it is clear as to what's going on,
so it is easy to recover from mistakes, if any. (Using an app/plugin with
a GUI generally hides a lot of things under the hood, and if things go awry
you may not have enough transparent info to work with and fix things.)

<p>Create a new repository and give your grader <b>read</b> access. You can give
read access to your grader at any time, there is no requirement that you 
give access immediately. 

<p>Since you are going to collaborate with your partner using Bitbucket,
and we are going to get your code from Bitbucket, there is no requirement of
any specific IDE to use since it will be of no consequence for the Bitbucket
codebase. So on your local machine you can use any IDE you want, Eclipse/IntelliJ/whatever.

<p>Create an Java project, name it <tt>ChessXX</tt>, where XX is the two digit group
number. Use packages as necessary. There should be at least one package,
called <tt>chess</tt>, with the main class called <tt>Chess</tt> in it. 
This is the class that we will run when testing your program.

<p>Create a <tt>docs</tt> directory under the project. You 
will put your complete generated Javadocs HTML documentation in this directory.

<p>For code management on Bitbucket, one option is to make your project folder
the root of your 
Bitbucket repository</b></font>. This way, when we get your project from
Bitbucket, we get the entire project space, with source and binary
files, and all data that is in the project in the right places.<br>(Strictly speaking,
we don't need the binaries, so if you find another way to set up your repo 
that holds all project source and data files, that's fine.)

<p><font color="red">EACH partner in the team will make a first Bitbucket commit in the
project by Tuesday, Mar 7. </font><br>
The BitBucket commit
does not have to be any Java code, you may commit any text file, with as little
as a single letter in it. 

<p>Thereafter, you will make commits incrementally, as and when you add reasonable 
functionality to your implementation. Aside from that first commit that should
come from each partner, we are not asking for a specific number
of commits from either partner, as long as you have found a way to work
together. 

<p>In any case, do NOT use Bitbucket like a Canvas assignment drop, as in
not making any commits after the initial required commit, then making the
second one the final commit just before the deadline. If you do this, you are
wasting a great
opportunity to learn an important skill you will be required to use in real projects, 
and will have one less thing to show to prospective employers.

<hr>

<h3><a name="faq"></a>Frequently Asked Questions</h3>

<b>Q:</b> Can we assume the input will always be separated by " "? That is, no 
inputs like "h7 h6draw?" or "h6 h7N". In addition, is extra space allowed? 
For example "h7 h6 " or " h7 h6" or "e2   e4".<br>
<b>A:</b> All inputs will have exactly one space between
components, such as "e2 e4", or "g7 g7 N". And there won't be any leading or
trailing spaces. 

<p><b>Q:</b> Do we have to implement a rule where a player is not allowed to make an
otherwise valid move if it will immediately put their king in check?<br>
<b>A:</b> Yes. This qualifies as an illegal move.

<p><b>Q:</b> Do we need to worry about bad input, like a player entering "draw" 
without being asked by the other player, or just entering things that don't make 
sense, such as "x10 p14"?<br>
<b>A:</b> No

<p><b>Q:</b> The assignment says we have to print "Illegal move, try again" if the player 
attempts an illegal move, but can we print more specific messages to identify 
the kind of illegal move?<br>
<b>A:</b> No, you must stick with the described format.

<p><b>Q:</b> Will differences in output such as 
"White is in checkmate" instead "Black wins" be OK?<br>
<b>A:</b> No, it's not ok. Your program should print "Checkmate" 
(followed by "White wins" or "Black wins").

<p><b>Q:</b> We saw rules elsewhere on castling/dead position/what-have-you that 
go beyond the description on the linked Wikipedia page. Should we implement those?<br>
<b>A:</b> No, we are going with the Wikipedia page only. 
We are not all practiced Chess players.

<p><b>Q:</b> Should we print the board out again if the user tries to 
input an illegal move?<br>
<b>A:</b> No

<p><b>Q:</b> If an opponent's piece is captured, should 
we indicate a captured piece?<br>
<b>A:</b> No

<p><b>Q:</b> For the resign examples, should we add "Black wins" or "White wins" at the 
end?<br>
<b>A:</b> Yes

<p><b>Q:</b> Can we use Github instead of Bitbucket?<br>
<b>A:</b> No

<p>&nbsp;<p>&nbsp;<p>
</p></body></html>
