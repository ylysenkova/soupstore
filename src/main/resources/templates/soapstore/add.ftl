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
            background-image: url("http://buzz-netnews.com/wp-content/uploads/2016/04/b7612b71c08547dbd9309a2ec66b0785.jpg");
            background-size: cover;
        }

    </style>
</head>
<body class="page">
<header class="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg ">
            <a class="navbar-brand" href="/products">
                <img src="https://wonderopolis.org/wp-content/uploads/2017/04/Soapdreamstime_xl_37053010.jpg" width="30"
                     height="30" class="d-inline-block align-top">
                Soap World
            </a>
        </nav>
    </div>
</header>
<div class="container">
    <form action="/product/add" method="POST">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" style="width: 102px">Name: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="name">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" style="width: 102px">Price: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="price">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Image link: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="imgRef">
        </div>
        <div class="button">
            <button type="submit" class="btn btn-success" style="background-color: cornflowerblue">Add</button>
        </div>
    </form>
</div>
</body>
</html>