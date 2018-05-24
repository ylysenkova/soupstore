<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>soapstore</title>
    <style>
        .header {
            background-color: lavender;
        }

        .body {
            background-image: url("https://pixelbox.ru/upload/file/-/clouds_brushes.jpg");
            background-size: cover;
        }

        .card {
            background-color: lightpink;
        }

        .invisible {
            visibility: hidden;
        }

        .card-columns {
            min-height: 100vh;

        @include media-breakpoint-only(lg) {
            column-count: 4;
        }
        @include media-breakpoint-only(xl) {
            column-count: 5;
        }

        }
    </style>
</head>
<body>
<header class="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg ">
            <a class="navbar-brand" href="/products">
                <img src="https://wonderopolis.org/wp-content/uploads/2017/04/Soapdreamstime_xl_37053010.jpg" width="30"
                     height="30" class="d-inline-block align-top">
                Soap World
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="/products/Add">Add<span
                            class="sr-only">(current)</span></a>
                </div>
            </div>
        </nav>
    </div>
</header>
<main class="body ">
    <section class="products container">
        <div class="card-columns mb-3">
                    <#list products as product>

                    <#--<div class="row mb-3">-->

                        <div class="card border-secondary" style="width: 18rem;">
                            <img class="card-img-top" src="${product.imgRef}" alt="picture">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-subtitle">Price:  ${product.price} $</p>
                            <#--<p class="card-subtitle">Production date: ${product.localDateTime}</p>-->
                                <p class="card-text invisible">${product.id}</p>
                            </div>
                        </div>
                    <#--</div>-->

                    </#list>
        </div>
    </section>
</main>

</body>
</html>