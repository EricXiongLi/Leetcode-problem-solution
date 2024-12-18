<h2><a href="https://leetcode.com/problems/visit-array-positions-to-maximize-score/">2786. Visit Array Positions to Maximize Score</a></h2><h3>Medium</h3><hr><div data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040"><p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">You are given a <strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">0-indexed</strong> integer array <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">nums</code> and a positive integer <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">x</code>.</p>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">You are <strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">initially</strong> at position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">0</code> in the array and you can visit other positions according to the following rules:</p>

<ul data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">
	<li data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">If you are currently in position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">i</code>, then you can move to <strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">any</strong> position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">j</code> such that <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">i &lt; j</code>.</li>
	<li data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">For each position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">i</code> that you visit, you get a score of <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">nums[i]</code>.</li>
	<li data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">If you move from a position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">i</code> to a position <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">j</code> and the <strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">parities</strong> of <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">nums[i]</code> and <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">nums[j]</code> differ, then you lose a score of <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">x</code>.</li>
</ul>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">Return <em data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">the <strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">maximum</strong> total score you can get</em>.</p>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1"><strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">Note</strong> that initially you have <code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">nums[0]</code> points.</p>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">&nbsp;</p>
<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040"><strong class="example" data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,6,1,9,2], x = 5
<strong>Output:</strong> 13
<strong>Explanation:</strong> We can visit the following positions in the array: 0 -&gt; 2 -&gt; 3 -&gt; 4.
The corresponding values are 2, 6, 1 and 9. Since the integers 6 and 1 have different parities, the move 2 -&gt; 3 will make you lose a score of x = 5.
The total score will be: 2 + 6 + 1 + 9 - 5 = 13.
</pre>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040"><strong class="example" data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,4,6,8], x = 3
<strong>Output:</strong> 20
<strong>Explanation:</strong> All the integers in the array have the same parities, so we can visit all of them without losing any score.
The total score is: 2 + 4 + 6 + 8 = 20.
</pre>

<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">&nbsp;</p>
<p data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040"><strong data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">
	<li data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="60c3de9d-372b-466c-b70e-1965df649040">1 &lt;= nums[i], x &lt;= 10<sup>6</sup></code></li>
</ul>
</div>