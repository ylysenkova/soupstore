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

        .page {
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFsJx8FyldlNLTpCC2pmHgi_IIBlNBMESss_7nFeG2-yjqWB2zzw");
            background-size: cover;
        }

        .card {
            background-color: lightcyan;
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
<body class="page">
<header class="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light">
            <nav class="navbar navbar-light">
                <a class="navbar-brand" href="/products">
                    <img src="https://wonderopolis.org/wp-content/uploads/2017/04/Soapdreamstime_xl_37053010.jpg"
                         width="60"
                         height="60" class="d-inline-block align-center">
                    Soap World
                </a>
            </nav>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/product/add">Add</a>
                    </li>
                </ul>
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
                                <p class="card-text d-none">${product.id}</p>
                            </div>
                        </div>
                    <#--</div>-->

                    </#list>
        </div>
    </section>
</main>

</body>
</html>