<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>お問い合わせ内容確認</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        
        <h1>お問い合わせ内容確認</h1>
        <div class="form">
            <p class="n">お問い合わせ内容はこちらでよろしいでしょうか。<br>
            よろしければ「送信する」ボタンを押してください。</p>
            <p class="n">名前<br>
                <?php echo $_POST['name']; ?>
            </p>
            <p class="n">メールアドレス<br>
                <?php echo $_POST['mail']; ?>
            </p>
            <p class="n">年齢<br>
                <?php echo $_POST['age']; ?>
            </p>
            <p class="n">コメント<br>
                <?php echo $_POST['nakami']; ?>
            </p>
            
            <form action="index.html">
                <input type="submit" class="submit" value="戻って修正する">
            </form>
            <form action="insert.php" method="post">
                <input type="submit" class="submit2" value="登録する">
                <input type="hidden" value="<?php echo $_POST['name']; ?>" name="name">
                <input type="hidden" value="<?php echo $_POST['mail']; ?>" name="mail">
                <input type="hidden" value="<?php echo $_POST['age']; ?>" name="age">
                <input type="hidden" value="<?php echo $_POST['nakami']; ?>" name="nakami">
            </form>
        </div>
        
    </body>
</html>