<h2>269. Alien Dictionary</h2><h3>Hard</h3><hr><div><p>There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.</p>

<p>You are given&nbsp;a list of strings&nbsp;<code>words</code> from the dictionary, where <code>words</code> are <strong>sorted lexicographically</strong> by the rules of this new language.</p>

<p><em>Derive the order of letters in this language, and return it</em>. If the given input is invalid, return <code>""</code>. If there are multiple valid solutions, return <strong>any of them</strong>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["wrt","wrf","er","ett","rftt"]
<strong>Output:</strong> "wertf"
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["z","x"]
<strong>Output:</strong> "zx"
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> words = ["z","x","z"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> The order is invalid, so return <code>""</code>.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> consists of only lowercase English letters.</li>
</ul>
</div>