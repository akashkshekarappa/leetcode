<h2>65. Valid Number</h2><h3>Hard</h3><hr><div><p>Validate if a given string can be interpreted as&nbsp;a decimal number.</p>

<p>Some examples:<br>
<code>"0"</code> =&gt; <code>true</code><br>
<code>" 0.1 "</code> =&gt; <code>true</code><br>
<code>"abc"</code> =&gt; <code>false</code><br>
<code>"1 a"</code> =&gt; <code>false</code><br>
<code>"2e10"</code> =&gt; <code>true</code><br>
<code>" -90e3&nbsp; &nbsp;"</code> =&gt; <code>true</code><br>
<code>" 1e"</code> =&gt; <code>false</code><br>
<code>"e3"</code> =&gt; <code>false</code><br>
<code>" 6e-1"</code> =&gt; <code>true</code><br>
<code>" 99e2.5&nbsp;"</code> =&gt; <code>false</code><br>
<code>"53.5e93"</code> =&gt; <code>true</code><br>
<code>" --6 "</code> =&gt; <code>false</code><br>
<code>"-+3"</code> =&gt; <code>false</code><br>
<code>"95a54e53"</code> =&gt; <code>false</code></p>

<p><strong>Note:</strong> It is intended for the problem statement to be ambiguous. It would be best if you gathered all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:</p>

<ul>
	<li>Numbers 0-9</li>
	<li>Exponent - "e"</li>
	<li>Positive/negative sign - "+"/"-"</li>
	<li>Decimal point - "."</li>
</ul>

<p>Of course, the context of these characters also matters in the input.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<pre><strong>Input:</strong> s = "0"
<strong>Output:</strong> true
</pre><p><strong>Example 2:</strong></p>
<pre><strong>Input:</strong> s = "3"
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 20</code></li>
	<li><code>s</code> consists of only English letters, digits, space <code>' '</code>, plus <code>'+'</code>, minus <code>'-'</code>, or dot <code>'.'</code>.</li>
</ul>
</div>