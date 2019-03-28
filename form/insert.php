<?php
mb_internal_encoding("utf8");
$pdo=new PDO("mysql:dbname=nanika;host=localhost;","root","mysql");
$pdo->exec("insert into toi(name,mail,age,comment) values('".$_POST['name']."','".$_POST['mail']."','".$_POST['age']."','".$_POST['nakami']."');");
?>
<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>お問い合わせ送信完了</title>
    </head>
    <body>
        <h1>お問い合わせフォーム</h1>
        <div class="form">
            <p>お問い合わせありがとうございました。<br>
            3営業日以内に担当者よりご連絡差し上げます。</p>
            <form action="index.html">
                <input type="submit" class="submit" value="戻る">
            </form>
        </div>
    </body>
</html>