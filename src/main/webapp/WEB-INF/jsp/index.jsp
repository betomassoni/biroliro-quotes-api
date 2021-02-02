<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">        

        <title>Biroliro Quotes</title>

        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/cover.css" rel="stylesheet">    
    </head>

    <body class="text-center">
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <div class="main">
                <div class="inner cover">
                    <h1 class="cover-heading"><q id="quote"></q></h1>                                
                    <p class="lead">
                        <strong>Fonte:</strong> <a href="#" id="link" target="_blank"></a>
                    </p>
                </div>
            </div> 


            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <p><a href="/swagger-ui.html" target="_blank">API Documentation</a><br><a href="https://github.com/betomassoni/biroliro-quotes-api">GitHub</a></p>
                </div>
            </footer>
        </div> 

        <script>
            fetch("/api/random/quote")
                    .then(resp => resp.json())
                    .then(function (y) {
                        document.getElementById("quote").innerHTML = y.content.value;
                        document.getElementById("link").innerHTML = y.content.url;
                        document.getElementById("link").href = y.content.url;
                    });
        </script>
    </body>
</html>
