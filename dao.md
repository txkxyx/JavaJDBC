# JavaJDBC 追加問題　 DAO

SQL の追加問題([https://github.com/txkxyx/sql_workshop/blob/master/question.md](https://github.com/txkxyx/sql_workshop/blob/master/question.md))で使用したテーブルを使用する。

## 問題 1

社員テーブル(m_employee)、プロジェクトテーブル(m_project)、役割テーブル(m_role)、プロジェクト管理テーブル(t_project)のそれぞれのデータを保持するクラスを作成せよ。

### 社員テーブルクラス(MEmployee.java)

- フィールド

  | フィールド名 | 公開範囲 | 型     | 説明     |
  | ------------ | -------- | ------ | -------- |
  | eno          | private  | 整数   | 社員番号 |
  | ename        | private  | 文字列 | 社員名   |
  | hireDate     | private  | 日付   | 入社日   |
  | salary       | private  | 整数   | 給料     |
  | address      | private  | 文字列 | 出身地   |

- コンストラクタ

  | 引数                                  | 説明                               |
  | ------------------------------------- | ---------------------------------- |
  | 社員番号 社員名　入社日　給料　出身地 | 各フィールドに引数の値を設定する。 |

- メソッド

  | メソッド名 | 公開範囲 | 引数             | 戻り値           | 説明                           |
  | ---------- | -------- | ---------------- | ---------------- | ------------------------------ |
  | get???     | public   | なし             | 各フィールドの型 | 各フィールドの getter メソッド |
  | set???     | public   | 各フィールドの型 | なし             | 各フィールドの setter メソッド |

### プロジェクトテーブルクラス(MProject.java)

- フィールド

  | フィールド名 | 公開範囲 | 型     | 説明             |
  | ------------ | -------- | ------ | ---------------- |
  | pno          | private  | 整数   | プロジェクト番号 |
  | pname        | private  | 文字列 | プロジェクト名   |

- コンストラクタ

  | 引数                            | 説明                               |
  | ------------------------------- | ---------------------------------- |
  | プロジェクト番号 プロジェクト名 | 各フィールドに引数の値を設定する。 |

- メソッド

  | メソッド名 | 公開範囲 | 引数             | 戻り値           | 説明                           |
  | ---------- | -------- | ---------------- | ---------------- | ------------------------------ |
  | get???     | public   | なし             | 各フィールドの型 | 各フィールドの getter メソッド |
  | set???     | public   | 各フィールドの型 | なし             | 各フィールドの setter メソッド |

### 役割テーブルクラス(MRole.java)

- フィールド

  | フィールド名 | 公開範囲 | 型     | 説明     |
  | ------------ | -------- | ------ | -------- |
  | rno          | private  | 整数   | 役割番号 |
  | rname        | private  | 文字列 | 役割名   |

- コンストラクタ

  | 引数            | 説明                               |
  | --------------- | ---------------------------------- |
  | 役割番号 役割名 | 各フィールドに引数の値を設定する。 |

- メソッド

  | メソッド名 | 公開範囲 | 引数             | 戻り値           | 説明                           |
  | ---------- | -------- | ---------------- | ---------------- | ------------------------------ |
  | get???     | public   | なし             | 各フィールドの型 | 各フィールドの getter メソッド |
  | set???     | public   | 各フィールドの型 | なし             | 各フィールドの setter メソッド |

### プロジェクト管理クラス(TProject.java)

- フィールド

  | フィールド名 | 公開範囲 | 型   | 説明             |
  | ------------ | -------- | ---- | ---------------- |
  | id           | private  | 整数 | 管理番号         |
  | pno          | private  | 整数 | プロジェクト番号 |
  | eno          | private  | 整数 | 社員番号         |
  | rno          | private  | 整数 | 役割番号         |

- コンストラクタ

  | 引数                                        | 説明                               |
  | ------------------------------------------- | ---------------------------------- |
  | プロジェクト番号 社員番号 役割番号          | 各フィールドに引数の値を設定する。 |
  | 管理番号 プロジェクト番号 社員番号 役割番号 | 各フィールドに引数の値を設定する。 |

- メソッド

  | メソッド名 | 公開範囲 | 引数             | 戻り値           | 説明                           |
  | ---------- | -------- | ---------------- | ---------------- | ------------------------------ |
  | get???     | public   | なし             | 各フィールドの型 | 各フィールドの getter メソッド |
  | set???     | public   | 各フィールドの型 | なし             | 各フィールドの setter メソッド |

## 問題 2

社員テーブル(m_employee)を管理する DAO クラス、プロジェクトテーブル(m_project)を管理する DAO クラス、プロジェクト管理テーブル(t_project)を管理する DAO クラスを作成する。

### 社員テーブル DAO クラス(MEmployeeDAO.java)

- フィールド

  | フィールド名 | 公開範囲  | 型                  | 説明              |
  | ------------ | --------- | ------------------- | ----------------- |
  | connection   | protected | java.sql.Connection | JDBC コネクション |

- コンストラクタ

  | 引数              | 説明                                         |
  | ----------------- | -------------------------------------------- |
  | JDBC コネクション | フィールドの connection に引数の値を設定する |

- メソッド

  | メソッド名 | 公開範囲 | 引数      | 戻り値 | 説明                                                                                                              |
  | ---------- | -------- | --------- | ------ | ----------------------------------------------------------------------------------------------------------------- |
  | create     | pubic    | MEmployee | 整数   | 社員テーブル(m_employee)のデータを保持する MEmployee クラスを引数で受け取り、そのデータをデータベースに登録する。 |

### プロジェクトテーブル DAO クラス(MProjectDAO.java)

- フィールド

  | フィールド名 | 公開範囲  | 型                  | 説明              |
  | ------------ | --------- | ------------------- | ----------------- |
  | connection   | protected | java.sql.Connection | JDBC コネクション |

- コンストラクタ

  | 引数              | 説明                                         |
  | ----------------- | -------------------------------------------- |
  | JDBC コネクション | フィールドの connection に引数の値を設定する |

- メソッド

  | メソッド名 | 公開範囲 | 引数     | 戻り値 | 説明                                                                                                                    |
  | ---------- | -------- | -------- | ------ | ----------------------------------------------------------------------------------------------------------------------- |
  | create     | pubic    | MProject | 整数   | プロジェクトテーブル(m_project)のデータを保持する MProject クラスを引数で受け取り、そのデータをデータベースに登録する。 |

### プロジェクト管理テーブル DAO クラス(TProjectDAO.java)

- フィールド

  | フィールド名 | 公開範囲  | 型                  | 説明              |
  | ------------ | --------- | ------------------- | ----------------- |
  | connection   | protected | java.sql.Connection | JDBC コネクション |

- コンストラクタ

  | 引数              | 説明                                         |
  | ----------------- | -------------------------------------------- |
  | JDBC コネクション | フィールドの connection に引数の値を設定する |

- メソッド

  | メソッド名 | 公開範囲 | 引数     | 戻り値        | 説明                                                                                                                        |
  | ---------- | -------- | -------- | ------------- | --------------------------------------------------------------------------------------------------------------------------- |
  | create     | pubic    | TProject | 整数          | プロジェクト管理テーブル(t_project)のデータを保持する TProject クラスを引数で受け取り、そのデータをデータベースに登録する。 |
  | findByPno  | public   | 整数     | List:TProject | pno を引数から受け取り、プロジェクト管理テーブル(t_project)からプロジェクト番号が pno であるデータを検索する。              |

## 問題 3

新たな社員と新たなプロジェクトが開始されたとします。

下の表を参考に、社員テーブルに新たな社員を、プロジェクトテーブルに新たなプロジェクトを、プロジェクト管理テーブルにプロジェクトに参加する社員と役割を登録せよ。

登録後に、プロジェクト管理テーブルから、新たに登録したプロジェクトの情報を検索せよ。

- 社員情報

  | eno | ename     | hire_date  | salary | address  |
  | --- | --------- | ---------- | ------ | -------- |
  | 12  | OKADA     | 2016-09-21 | 300000 | Osaka    |
  | 13  | YAMAGUCHI | 2017-12-14 | 280000 | Hyogo    |
  | 14  | KATAOKA   | 2018-03-02 | 240000 | Ishikawa |

- プロジェクト情報

  | pno | pname          |
  | --- | -------------- |
  | 5   | Python Project |
  | 6   | IoT Project    |

- プロジェクト管理情報

  | pno | eno | rno |
  | --- | --- | --- |
  | 5   | 5   | 10  |
  | 5   | 6   | 20  |
  | 5   | 9   | 30  |
  | 5   | 12  | 40  |
  | 6   | 2   | 10  |
  | 6   | 3   | 20  |
  | 6   | 14  | 30  |
  | 6   | 13  | 40  |

- ヒント

  ```java
  package ???;

  import java.sql.Connection;
  import java.sql.Date;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import java.util.List;

  public class Main {
      static final String URL = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
      static final String USER = "root";
      static final String PASSWORD = "???";

      public static void main(String[] args) {

          ???[] mEmployeeList = { new ???(12, "OKADA", Date.valueOf("2016-09-21"), 300000, "Osaka"),
                  new ???(13, "YAMAGUCHI", Date.valueOf("2017-12-14"), 280000, "Hyogo"),
                  new ???(14, "KATAOKA", Date.valueOf("2018-03-02"), 240000, "Ishikawa") };
          ???[] mProjectList = { new ???(5, "Python Project"), new ???(6, "IoTProject") };
          ???[] tProjectList = { new ???(5, 5, 10), new ???(5, 6, 20), new ???(5, 9, 30),
                  new ???(5, 12, 40), new ???(6, 2, 10), new ???(6, 3, 20), new ???(6, 14, 30),
                  new ???(6, 13, 40) };

          try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
              connection.???;

              try {
                  MEmployeeDAO mEmployeeDAO = new MEmployeeDAO(connection);
                  ???

                  MProjectDAO mProjectDAO = new MProjectDAO(connection);
                  ???

                  connection.???;

                  TProjectDAO tProjectDAO = new TProjectDAO(connection);
                  ???
                  connection.???;

                  List<TProject> t5Projects = tProjectDAO.findByPno(5);
                  showTProject(t5Projects);
                  List<TProject> t6Projects = tProjectDAO.findByPno(6);
                  showTProject(t6Projects);

              } catch (SQLException e) {
                  connection.rollback();
                  e.printStackTrace();
              }

          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      public static void showTProject(List<TProject> tProjects) {
          System.out.println(" id | pno | eno | rno |");
          System.out.println("-----------------------");
          for (TProject tProject : tProjects) {
              System.out.printf(" %2d | %3d | %3d | %3d |\n", ???, ???, ???,???);
          }
          System.out.println();
      }
  }
  ```

- 実行結果

  ```bash
  id | pno | eno | rno |
  -----------------------
  32 |   5 |   5 |  10 |
  33 |   5 |   6 |  20 |
  34 |   5 |   9 |  30 |
  35 |   5 |  12 |  40 |

  id | pno | eno | rno |
  -----------------------
  36 |   6 |   2 |  10 |
  37 |   6 |   3 |  20 |
  38 |   6 |  14 |  30 |
  39 |   6 |  13 |  40 |
  ```
