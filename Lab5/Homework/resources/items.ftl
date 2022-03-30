<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${catalogName}|${catalogPath}</h1>



<h2>Items</h2>
<ul>

    <#list items as item>
        <#if item.type == "Book">
             <li>${item_index + 1}. ${item.title} | ${item.location} | ${item.author }| ${item.years} | ${item.id} }</li>
        </#if>
    </#list>
</ul>

<h2>Articles</h2>
<ul>
    <#list items as item>
        <#if item.type == "Article">
            <li>${item_index + 1}. ${item.title} | <a href=" ${item.location} " target="_blank">This is a link</a> | ${item.author}| ${item.years} | ${item.id} }</li>
        </#if>
    </#list>
</ul>

</body>
</html>