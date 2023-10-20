# 従業員管理システム

**Employee Management System** :briefcase:

## はじめに :rocket:

これはJava SwingとMySQLデータベースを使用した従業員管理アプリケーションです。 :computer:

## 機能 :gear:

- ユーザーのログインとアクセス制御（管理者と従業員） :key:
- 従業員情報の管理（追加/編集/削除/検索） :bust_in_silhouette:
- 従業員の出勤管理 :calendar:

## 技術 :wrench:

- 言語: Java :coffee:
- GUIフレームワーク: Java Swing :art:
- データベース: MySQL :floppy_disk:

## 依存関係 :inbox_tray:

- JDK 21 :hammer:
- MySQL Connector/J 8.0.31 :electric_plug:

## インストールガイド :arrow_down:

1. JDK 21をインストール :arrow_upper_right:
2. MySQLをインストールし、employee_managementデータベースを作成 :package:
3. プロジェクトをIDE（Eclipse、IntelliJ、...）にインポート :inbox_tray:
4. MySQL Connector/J 8.0.31ライブラリをクラスパスに追加 :file_folder:
5. DBConnection.javaでデータベース接続情報（ユーザー名、パスワード、...）を修正 :pencil:
6. MainUIクラスを実行してアプリケーションを起動 :rocket:

## メインクラス :hammer_and_wrench:

- DBConnection: データベースへの接続 :file_folder:
- MainUI: ログイン画面とメインメニュー :computer:
- AdminUI: 管理者画面 :bar_chart:
- EmployeeUI: 従業員画面 :briefcase:
- AuthManager: ユーザー認証とアクセス制御 :cop:
- EmployeeManager: 従業員に関するCRUD操作の管理 :busts_in_silhouette:
- *他のクラスについてはソースコードを参照 :file_folder:

## MySQLのインストールと"employee_management"データベースの作成 :floppy_disk:

1. **MySQLのインストール (Install MySQL)**: お使いのコンピュータにMySQLがインストールされていることを確認してください。インストールされていない場合は、公式MySQLウェブサイト（https://dev.mysql.com/downloads/mysql/）からMySQLをダウンロードできます。

   **お使いのコンピュータにMySQLがインストールされていることを確認してください。まだインストールされていない場合は、公式MySQLウェブサイト（https://dev.mysql.com/downloads/mysql/）からMySQLをダウンロードできます。**

2. **MySQLサーバーの起動 (Start MySQL Server)**: インストールが完了したら、MySQLサーバーを起動してください。

   **インストールが完了したら、MySQLサーバーを起動してください。**

3. **MySQLコマンドラインまたはMySQL Workbenchへのアクセス (Access MySQL Command Line or MySQL Workbench)**: データベースとテーブルを作成するために、MySQLコマンドラインまたはMySQL Workbenchを使用できます。以下はMySQLコマンドラインを使用する例です。

   **データベースとテーブルを作成するために、MySQLコマンドラインまたはMySQL Workbenchを使用できます。以下はMySQLコマンドラインを使用する例です。**

   - コマンド プロンプトまたはターミナルを開き、次のコマンドを入力してMySQLにアクセスします。

     **コマンド プロンプトまたはターミナルを開き、次のコマンドを入力してMySQLにアクセスします。**

     ```shell
     mysql -u root -p
     ```

     その後、求められる場合はパスワードを入力してください。

     **その後、求められる場合はパスワードを入力してください。**

4. **"employee_management"データベースの作成 (Create the "employee_management" Database)**:

   ```sql
   CREATE DATABASE employee_management;

   USE employee_management;
   
   CREATE TABLE login (
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   keyid VARCHAR(255) NOT NULL,
   PRIMARY KEY (username)
   );
   
著者 :pencil2: Salamander :raised_hand:
メール::email: trunghieu.bomm@gmail.com :email:

このReadmeが従業員管理アプリケーションに関する情報を網羅していることを願っています。ご意見やフィードバックをお待ちしております。 :pray: :tada:

ありがとうございます！ :rocket:

# Employee Management System :briefcase:

**Introduction** :rocket:

This is an employee management application using Java Swing and MySQL database. :computer:

**Features** :gear:

- User login and access control (admin and employee) :key:
- Manage employee information (add/edit/delete/search) :bust_in_silhouette:
- Manage employee attendance :calendar:

**Technologies** :wrench:

- Language: Java :coffee:
- GUI Framework: Java Swing :art:
- Database: MySQL :floppy_disk:

**Dependencies** :inbox_tray:

- JDK 21 :hammer:
- MySQL Connector/J 8.0.31 :electric_plug:

**Installation Guide** :arrow_down:

1. Install JDK 21 :arrow_upper_right:
2. Install MySQL and create the employee_management database :package:
3. Import the project into your IDE (Eclipse, IntelliJ, etc.) :inbox_tray:
4. Add the MySQL Connector/J 8.0.31 library to the classpath :file_folder:
5. Modify the database connection information (username, password, etc.) in DBConnection.java :pencil:
6. Run the MainUI class to start the application :rocket:

**Main Classes** :hammer_and_wrench:

- DBConnection: Manages the database connection :file_folder:
- MainUI: Provides the login screen and main menu :computer:
- AdminUI: Admin interface :bar_chart:
- EmployeeUI: Employee interface :briefcase:
- AuthManager: Handles user authentication and authorization :cop:
- EmployeeManager: Manages CRUD operations on employees :busts_in_silhouette:
- *See the source code for other classes :file_folder:

## Install MySQL and Create the "employee_management" Database :floppy_disk:

1. **Install MySQL**: Make sure you have MySQL installed on your computer. If not, you can download MySQL from the official MySQL website (https://dev.mysql.com/downloads/mysql/).

   **Ensure you have MySQL installed on your computer. If not, you can download MySQL from the official MySQL website (https://dev.mysql.com/downloads/mysql/).**

2. **Start MySQL Server**: After the installation is complete, start the MySQL Server.

   **Start the MySQL Server after installation.**

3. **Access MySQL Command Line or MySQL Workbench**: You can use MySQL Command Line or MySQL Workbench to create the database and table. Here's an example using MySQL Command Line:

   **You can use MySQL Command Line or MySQL Workbench to create the database and table. Here's an example using MySQL Command Line:**

   - Open Command Prompt or Terminal and enter the following command to access MySQL:

     **Open Command Prompt or Terminal and enter the following command to access MySQL:**

     ```shell
     mysql -u root -p
     ```

     Then, enter your password when prompted.

4. **Create the "employee_management" Database**:

   ```sql
   CREATE DATABASE employee_management;
   

   USE employee_management;
   

   CREATE TABLE login (
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   keyid VARCHAR(255) NOT NULL,
   PRIMARY KEY (username)
   );
  
**Author** :pencil2: Salamander :raised_hand:

Email: :email: trunghieu.bomm@gmail.com :email:

Hope this Readme covers all the information about your employee management application. Appreciate your feedback to improve it. :pray: :tada:
