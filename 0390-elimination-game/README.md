<h2><a href="https://leetcode.com/problems/elimination-game/">390. Elimination Game</a></h2><h3>Medium</h3><hr><div data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c"><p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">You have a list <code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">arr</code> of all integers in the range <code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">[1, n]</code> sorted in a strictly increasing order. Apply the following algorithm on <code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">arr</code>:</p>

<ul data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">
	<li data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.</li>
	<li data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.</li>
	<li data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Keep repeating the steps again, alternating left to right and right to left, until a single number remains.</li>
</ul>

<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Given the integer <code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">n</code>, return <em data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">the last number that remains in</em> <code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">arr</code>.</p>

<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">&nbsp;</p>
<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c"><strong class="example" data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 9
<strong>Output:</strong> 6
<strong>Explanation:</strong>
arr = [<u>1</u>, 2, <u>3</u>, 4, <u>5</u>, 6, <u>7</u>, 8, <u>9</u>]
arr = [2, <u>4</u>, 6, <u>8</u>]
arr = [<u>2</u>, 6]
arr = [6]
</pre>

<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c"><strong class="example" data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">&nbsp;</p>
<p data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c"><strong data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">
	<li data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c"><code data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">1 &lt;= n &lt;= 10<sup data-immersive-translate-walked="3b8aade0-d27a-4276-b8ec-39a90bc4921c">9</sup></code></li>
</ul>
</div>