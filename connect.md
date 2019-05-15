# JavaJDBC 追加問題　データベース接続

## 問題

SQL の追加課題([https://github.com/txkxyx/sql_workshop/blob/master/question.md](https://github.com/txkxyx/sql_workshop/blob/master/question.md))で使用したデータベース`development`を作成し、JDBC ドライバー用いて接続せよ。

- ヒント

  ```java
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;

  public class Question1Main {
      public static void main(String[] args) {

          String url = "";
          String user = "";
          String password = "";

          try (??? connection = ???.???(url, user, password)) {

              System.out.println("Connection Success");
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }

  ```
