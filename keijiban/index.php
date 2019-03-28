<!doctype html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>掲示板</title>
    </head>
    <body>
        <?php
        mb_internal_encoding("utf8");
        $pdo=new PDO("mysql:dbname=nanika;host=localhost;","root","mysql");
        $stmt=$pdo->query("select * from keijiban");
        ?>
        
        <header>
            <div>掲示板</div>
        </header>
        
        <main>
            <div class="form">
            <h2>入力フォーム</h2>
            <form method="post" action="insert.php">
                <div><label>名前</label><br>
                    <input type="text" class="text" name="name" size="40">
                </div>
                <div><label>タイトル</label><br>
                    <input type="text" class="text" name="title" size="40">
                </div>
                <div><label>コメント</label><br>
                    <textarea rows="7" cols="50" name="comments"></textarea>
                </div>
                <div>
                    <input type="submit" class="submit" value="投稿する">
                </div>
            </form>
            </div>
            <?php
            while($row=$stmt->fetch()){
                echo"<div class='kiji'>";
                echo"<h3>".$row['title']."</h3>";
                echo"<div class='contents'>";
                echo $row['comments'];
                echo"<div class='name'>posted by".$row['name']."</div>";
                echo"</div>";
                echo"</div>";
            }
            ?>
        </main>
        
        <footer>
            <div>©　aiueo</div>
        </footer>
        
    </body>
</html>