<h2><a href="https://leetcode.com/problems/basic-calculator/">224. Basic Calculator</a></h2><h3>Hard</h3><hr><div data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Given a string <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">s</code> representing a valid expression, implement a basic calculator to evaluate it, and return <em data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">the result of the evaluation</em>.</p>

<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1"><strong data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">Note:</strong> You are <strong data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">not</strong> allowed to use any built-in function which evaluates strings as mathematical expressions, such as <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">eval()</code>.</p>

<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">&nbsp;</p>
<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><strong class="example" data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "1 + 1"
<strong>Output:</strong> 2
</pre>

<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><strong class="example" data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Example 2:</strong></p>

<pre><strong>Input:</strong> s = " 2-1 + 2 "
<strong>Output:</strong> 3
</pre>

<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><strong class="example" data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "(1+(4+5+2)-3)+(6+8)"
<strong>Output:</strong> 23
</pre>

<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">&nbsp;</p>
<p data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><strong data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240"><code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">s</code> consists of digits, <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">'+'</code>, <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">'-'</code>, <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">'('</code>, <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">')'</code>, and <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">' '</code>.</li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">s</code> represents a valid expression.</li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">'+'</code> is <strong data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">not</strong> used as a unary operation (i.e., <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">"+1"</code> and <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">"+(2 + 3)"</code> is invalid).</li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">'-'</code> could be used as a unary operation (i.e., <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">"-1"</code> and <code data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240">"-(2 + 3)"</code> is valid).</li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">There will be no two consecutive operators in the input.</li>
	<li data-immersive-translate-walked="2b1a0fa8-608c-4d7d-b121-a49ad0b6e240" data-immersive-translate-paragraph="1">Every number and running calculation will fit in a signed 32-bit integer.</li>
</ul>
</div>