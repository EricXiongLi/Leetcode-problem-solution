<h2><a href="https://leetcode.com/problems/design-tic-tac-toe/">348. Design Tic-Tac-Toe</a></h2><h3>Medium</h3><hr><div data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e"><p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">Assume the following rules are for the tic-tac-toe game on an <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">n x n</code> board between two players:</p>

<ol data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">A move is guaranteed to be valid and is placed on an empty block.</li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">Once a winning condition is reached, no more moves are allowed.</li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">A player who succeeds in placing <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">n</code> of their marks in a horizontal, vertical, or diagonal row wins the game.</li>
</ol>

<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">Implement the <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">TicTacToe</code> class:</p>

<ul data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">TicTacToe(int n)</code> Initializes the object the size of the board <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">n</code>.</li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">int move(int row, int col, int player)</code> Indicates that the player with id <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">player</code> plays at the cell <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">(row, col)</code> of the board. The move is guaranteed to be a valid move, and the two players alternate in making moves. Return
	<ul data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">
		<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">0</code> if there is <strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">no winner</strong> after the move,</li>
		<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">1</code> if <strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">player 1</strong> is the winner after the move, or</li>
		<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">2</code> if <strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">player 2</strong> is the winner after the move.</li>
	</ul>
	</li>
</ul>

<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">&nbsp;</p>
<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e"><strong class="example" data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">Example 1:</strong></p>

<pre><strong>Input</strong>
["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
<strong>Output</strong>
[null, 0, 0, 0, 0, 0, 0, 1]

<strong>Explanation</strong>
TicTacToe ticTacToe = new TicTacToe(3);
Assume that player 1 is "X" and player 2 is "O" in the board.
ticTacToe.move(0, 0, 1); // return 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

ticTacToe.move(0, 2, 2); // return 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

ticTacToe.move(2, 2, 1); // return 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

ticTacToe.move(1, 1, 2); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

ticTacToe.move(2, 0, 1); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

ticTacToe.move(1, 0, 2); // return 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

ticTacToe.move(2, 1, 1); // return 1&nbsp;(player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
</pre>

<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">&nbsp;</p>
<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e"><strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">2 &lt;= n &lt;= 100</code></li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">player is <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">1</code> or <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">2</code>.</li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">0 &lt;= row, col &lt; n</code></li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">(row, col)</code> are <strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">unique</strong> for each different call to <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">move</code>.</li>
	<li data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1">At most <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">n<sup>2</sup></code> calls will be made to <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">move</code>.</li>
</ul>

<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">&nbsp;</p>
<p data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e" data-immersive-translate-paragraph="1"><strong data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">Follow-up:</strong> Could you do better than <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">O(n<sup>2</sup>)</code> per <code data-immersive-translate-walked="613b5295-360c-4019-b3f8-6fafb47ef22e">move()</code> operation?</p>
</div>