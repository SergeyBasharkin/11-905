<#macro mainMacro title, css=[], scripts=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel='stylesheet' href='/css/bootstrap.min.css' type='text/css' media='all'/>
        <#list css as style>
            <link rel="stylesheet" href="/css/${style}">
        </#list>
        <title>${title}</title>
    </head>
    <body>
    <#nested>
    <#list scripts as script>
        <script src="/js/${script}"></script>
    </#list>
    </body>
    </html>
</#macro>