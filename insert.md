# JavaJDBC 追加問題　 Insert

SQL の追加問題([https://github.com/txkxyx/sql_workshop/blob/master/question.md](https://github.com/txkxyx/sql_workshop/blob/master/question.md))で使用したテーブルを使用する。

## 問題 1

社員テーブル(m_employee)に、以下の表の情報の新入社員のデータを作成せよ。

| eno | ename | hire_date          | salary | address |
| --- | ----- | ------------------ | ------ | ------- |
| 11  | SATO  | データ作成時の日付 | 300000 | Tokyo   |

## 問題 2

プロジェクトテーブル(m_project)に、以下の表の情報の新たなプロジェクトのデータを作成せよ。

| pno | pname            |
| --- | ---------------- |
| 4   | Java Application |

## 問題 3

問題 2 で追加したプロジェクトに人員を配置します。以下の表の社員をプロジェクトに配置できるように、プロジェクト管理テーブル(t_project)にデータを作成せよ。

| 社員番号 | 社員名 | 役割名          |
| -------- | ------ | --------------- |
| 1        | TANAKA | Project Manager |
| 3        | SUZUKI | Project Leader  |
| 9        | FUJII  | System Engineer |
| 11       | SATO   | Programmer      |
