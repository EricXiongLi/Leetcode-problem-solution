<h2><a href="https://leetcode.com/problems/island-perimeter/">463. Island Perimeter</a></h2><h3>Easy</h3><hr><div data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">You are given <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">row x col</code> <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid</code> representing a map where <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid[i][j] = 1</code> represents&nbsp;land and <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid[i][j] = 0</code> represents water.</p>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">Grid cells are connected <strong data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">horizontally/vertically</strong> (not diagonally). The <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid</code> is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).</p>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.</p>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">&nbsp;</p>
<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><strong class="example" data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/12/island.png" style="width: 221px; height: 213px;" data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">
<pre><strong>Input:</strong> grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
<strong>Output:</strong> 16
<strong>Explanation:</strong> The perimeter is the 16 yellow stripes in the image above.
</pre>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><strong class="example" data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[1]]
<strong>Output:</strong> 4
</pre>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><strong class="example" data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[1,0]]
<strong>Output:</strong> 4
</pre>

<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">&nbsp;</p>
<p data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><strong data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">Constraints:</strong></p>

<ul data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">
	<li data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">row == grid.length</code></li>
	<li data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">col == grid[i].length</code></li>
	<li data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6"><code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">1 &lt;= row, col &lt;= 100</code></li>
	<li data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1"><code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid[i][j]</code> is <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">0</code> or <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">1</code>.</li>
	<li data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6" data-immersive-translate-paragraph="1">There is exactly one island in <code data-immersive-translate-walked="75751a70-c5cc-4203-b854-af6c168203e6">grid</code>.</li>
</ul>
</div>