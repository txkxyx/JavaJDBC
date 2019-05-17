# JavaJDBC 追加問題　 Select

SQL の追加問題([https://github.com/txkxyx/sql_workshop/blob/master/question.md](https://github.com/txkxyx/sql_workshop/blob/master/question.md))で使用したテーブルを使用する。

## 問題 1

社員テーブル(m_employee)で社員名が「A」で終わる社員の社員名と給料を検索せよ。その際、給料の高い社員順に検索せよ。

- 実行結果例

  ```bash
  | ename | salary |
  |-------|--------|
  | TANAKA | 400000 |
  | YAMADA | 310000 |
  | KIMURA | 300000 |
  | IKEDA | 290000 |
  | SHIMADA | 270000 |
  | FUJIWARA | 250000 |
  ```

## 問題 2

社員テーブル(m_employee)の中から、2000 年代に入社した社員の平均給料を検索せよ。

- 実行結果例

```bash
| average  |
| -------- |
| 283750.0 |
```

## 問題 3

全てのプロジェクトにおいて、プロジェクトごとの社員名とその役割名の一覧を検索せよ。さらに、プロジェクトの並び順はプロジェクト番号が高い順で、役割の並び順は役割番号が低い順に表示せよ。

- 実行結果例

```bash
| pname | ename | rname |
|--------|--------|--------|
| Android Application | TANAKA Project Manager |
| Android Application | KIMURA Project Leader |
| Android Application | AONO System Engineer |
| Android Application | YAMAMOTO Programmer |
| iOS Application | KIMURA | Project Manager |
| iOS Application | IKEDA | Project Leader |
| iOS Application | SHIMADA | System Engineer |
| iOS Application | FUJIWARA | Programmer |
| Web Application | TANAKA | Project Manager |
| Web Application | SUZUKI | Project Leader |
| Web Application | YAMADA | System Engineer |
| Web Application | YAMAMOTO | Programmer |
| Web Application | FUJII | Programmer |
```
