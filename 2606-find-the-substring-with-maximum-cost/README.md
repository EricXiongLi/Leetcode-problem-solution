<h2><a href="https://leetcode.com/problems/find-the-substring-with-maximum-cost/">2606. Find the Substring With Maximum Cost</a></h2><h3>Medium</h3><hr><div data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0"><p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">You are given a string <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">s</code>, a string <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">chars</code> of <strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">distinct</strong> characters and an integer array <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">vals</code> of the same length as <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">chars</code>.</p>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">The <strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">cost of the substring </strong>is the sum of the values of each character in the substring. The cost of an empty string is considered <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">0</code>.</p>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">The <strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">value of the character </strong>is defined in the following way:</p>

<ul data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">If the character is not in the string <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">chars</code>, then its value is its corresponding position <strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">(1-indexed)</strong> in the alphabet.

	<ul data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">
		<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">For example, the value of <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">'a'</code> is <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">1</code>, the value of <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">'b'</code> is <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">2</code>, and so on. The value of <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">'z'</code> is <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">26</code>.</li>
	</ul>
	</li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">Otherwise, assuming <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">i</code> is the index where the character occurs in the string <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">chars</code>, then its value is <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">vals[i]</code>.</li>
</ul>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">Return <em data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">the maximum cost among all substrings of the string</em> <code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">s</code>.</p>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">&nbsp;</p>
<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0"><strong class="example" data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "adaa", chars = "d", vals = [-1000]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The value of the characters "a" and "d" is 1 and -1000 respectively.
The substring with the maximum cost is "aa" and its cost is 1 + 1 = 2.
It can be proven that 2 is the maximum cost.
</pre>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0"><strong class="example" data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abc", chars = "abc", vals = [-1,-1,-1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The value of the characters "a", "b" and "c" is -1, -1, and -1 respectively.
The substring with the maximum cost is the empty substring "" and its cost is 0.
It can be proven that 0 is the maximum cost.
</pre>

<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">&nbsp;</p>
<p data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0"><strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">s</code> consist of lowercase English letters.</li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">1 &lt;= chars.length &lt;= 26</code></li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">chars</code> consist of <strong data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">distinct</strong> lowercase English letters.</li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">vals.length == chars.length</code></li>
	<li data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="9eebd39d-28c0-455b-9c27-5cd7664d91f0">-1000 &lt;= vals[i] &lt;= 1000</code></li>
</ul>
</div>