<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Login</title>
    <style type="text/css">
        body {
    color: blueviolet;
    background: lavender;
    }
    .form-control {
    min-height: 41px;
    background: #f2f2f2;
    box-shadow: none !important;
    border: transparent;
    }
    .form-control:focus {
    background: #e2e2e2;
    }
    .form-control, .btn {
    border-radius: 2px;
    }
    .login-form {
    width: 350px;
    margin: 30px auto;
    text-align: center;
    }
    .login-form h2 {
    margin: 10px 0 25px;
    }
    .login-form form {
    color: #7a7a7a;
    border-radius: 3px;
    margin-bottom: 15px;
    background: #fff;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
    }
    .login-form .btn {
    font-size: 16px;
    font-weight: bold;
    background: plum;
    border: none;
    outline: none !important;
    }
    .login-form .btn:hover, .login-form .btn:focus {
    background: lavender;
    }
    .login-form a {
    color: #fff;
    text-decoration: underline;
    }
    .login-form a:hover {
    text-decoration: none;
    }
    .login-form form a {
    color: #7a7a7a;
    text-decoration: none;
    }
    .login-form form a:hover {
    text-decoration: underline;
    }
    </style>
</head>
<body>

<!-- Modal HTML -->
<div id="login" class="login-form">
    <h2 class="text-center">Login</h2>
    <form action="/login" method="post">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Username" name="login" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" name="password" required="required">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login">
        </div>
    </form>
</div>
</body>
</html>
