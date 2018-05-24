<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>soapstore</title>
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
        </nav>
    </div>
</header>
<div class="container">
    <form action="/product/add" method="POST">
        <input type="hidden" value="${product.id}" name="id">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Name: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="name" value="${product.name}">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Price: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="price" value="${product.price}">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Image link: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="imgRef" value="${product.imgRef}">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-datetime-local" style="width: 100px">Date: </span>
            </div>
            <input class="form-control" aria-label="With textarea" name="localDateTime"
                   value="${product.localDateTime}">
        </div>
        <div class="button">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>
</body>
</html>