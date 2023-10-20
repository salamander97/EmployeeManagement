⬇️ Clone source or download from github ⬇️


     ```shell
     git clone https://github.com/salamander97/EmployeeManagement.git
     cd EmployeeManagement
     ```
**Author** :pencil2: Salamander 👮‍♂️


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
2. MySQLをインストールし、Employee Dataデータベースを作成 :package:
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

## MySQLのインストールと"Employee Data"データベースの作成 :floppy_disk:

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

4. **"Employee Data"データベースの作成 (Create the "Employee Data" Database)**:

   ```sql
   CREATE DATABASE Employee Data;
   ```
   ```sql
   USE Employee Data;
   ```
   ```sql
   CREATE TABLE login (
   id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   role_id INT
   );
   ```
   
### 従業員データベース内

従業員データでは、従業員データとデータベースへのアクセスに関するログイン情報を保存するために、2つのテーブル「employees」と「login」を作成します.

**テーブル: employees** :busts_in_silhouette: 

- このテーブルは、従業員データを保存するために使用されます.
- 「employee_id」、「name」、「gender」、「dob」（生年月日）、「address」、「email」、「phone」、「position」、「role_id」などのフィールドが含まれます.
- 「employee_id」は各従業員の一意の識別子です.
- このテーブルのフィールドは、従業員に関する情報を保存します. 例えば、名前, 性別, 生年月日, 住所, メールアドレス, 電話番号, ポジション, および「role_id」などです.

**テーブル: login** :key:

- このテーブルはログイン資格情報を管理するために使用されます.
- 「username」、「password」、「id」、「role_id」などのフィールドが含まれます.
- 「username」フィールドはログインに使用されるユーザー名を保存します.
- 「password」フィールドはそれに対応するパスワードを保存します.
- 「id」フィールドは、ユーザーがアカウントの詳細情報を忘れた場合のパスワードの取得に使用できます.
- 「role_id」フィールドは、アクセス権を管理し、管理者と通常のユーザーを区別するのに使用されます. 

これらのテーブルは、従業員情報を保存し、データベースへのセキュアなアクセスを提供し、役割に基づくアクセス権を管理するために重要です. :floppy_disk:


このReadmeが従業員管理アプリケーションに関する情報を網羅していることを願っています。:pray: :tada:

ありがとうございます！ :rocket:

| # Hệ Thống Quản Lý Nhân Viên :briefcase: |
|---------------------------------------|
| **Giới Thiệu** :rocket: |
| Đây là một ứng dụng quản lý nhân viên sử dụng Java Swing và cơ sở dữ liệu MySQL. :computer: |

| **Tính Năng** :gear: |
| - Đăng nhập và kiểm soát quyền truy cập người dùng (quản trị viên và nhân viên) :key: |
| - Quản lý thông tin nhân viên (thêm/sửa/xóa/tìm kiếm) :bust_in_silhouette: |
| - Quản lý chấm công nhân viên :calendar: |

| **Công Nghệ** :wrench: |
| - Ngôn ngữ: Java :coffee: |
| - Framework giao diện người dùng: Java Swing :art: |
| - Cơ sở dữ liệu: MySQL :floppy_disk: |

| **Các Thư Viện** :inbox_tray: |
| - JDK 21 :hammer: |
| - MySQL Connector/J 8.0.31 :electric_plug: |

| **Hướng Dẫn Cài Đặt** :arrow_down: |
| 1. Cài đặt JDK 21 :arrow_upper_right: |
| 2. Cài đặt MySQL và tạo cơ sở dữ liệu "Employee Data" :package: |
| 3. Nhập dự án vào IDE của bạn (Eclipse, IntelliJ, vv.) :inbox_tray: |
| 4. Thêm thư viện MySQL Connector/J 8.0.31 vào classpath :file_folder: |
| 5. Sửa thông tin kết nối cơ sở dữ liệu (tên người dùng, mật khẩu, vv.) trong DBConnection.java :pencil: |
| 6. Chạy lớp MainUI để khởi động ứng dụng :rocket: |

| **Các Lớp Chính** :hammer_and_wrench: |
| - DBConnection: Quản lý kết nối cơ sở dữ liệu :file_folder: |
| - MainUI: Cung cấp màn hình đăng nhập và menu chính :computer: |
| - AdminUI: Giao diện quản trị viên :bar_chart: |
| - EmployeeUI: Giao diện nhân viên :briefcase: |
| - AuthManager: Xử lý xác thực người dùng và cấp quyền :cop: |
| - EmployeeManager: Quản lý các thao tác CRUD trên nhân viên :busts_in_silhouette: |
| - *Xem mã nguồn để biết về các lớp khác :file_folder: |

| **Cài Đặt MySQL và Tạo Cơ Sở Dữ Liệu "Employee Data" :floppy_disk:** |
| 1. **Cài Đặt MySQL**: Đảm bảo rằng bạn đã cài đặt MySQL trên máy tính của bạn. Nếu chưa, bạn có thể tải MySQL từ trang web chính thức của MySQL (https://dev.mysql.com/downloads/mysql/). |

| 2. **Khởi Động Máy Chủ MySQL**: Sau khi quá trình cài đặt hoàn tất, hãy khởi động Máy Chủ MySQL. |

| 3. **Truy Cập Dòng Lệnh MySQL hoặc MySQL Workbench**: Bạn có thể sử dụng Dòng Lệnh MySQL hoặc MySQL Workbench để tạo cơ sở dữ liệu và bảng. Dưới đây là một ví dụ sử dụng Dòng Lệnh MySQL: |

|   - Mở Command Prompt hoặc Terminal và nhập lệnh sau để truy cập MySQL: |
|     ```shell |
|     mysql -u root -p |
|     ``` |
|     Sau đó, nhập mật khẩu khi được yêu cầu. |

| 4. **Tạo Cơ Sở Dữ Liệu "Employee Data"**: |
|   ```sql |
|   CREATE DATABASE `Employee Data`; |
|   ``` |
|   ```sql |
|   USE `Employee Data`; |
|   ``` |
|   ```sql |
|   CREATE TABLE login ( |
|   id INT AUTO_INCREMENT PRIMARY KEY, |
|   username VARCHAR(255) NOT NULL, |
|   password VARCHAR(255) NOT NULL, |
|   role_id INT |
|   ); |
|   ``` |

| **Trong Cơ Sở Dữ Liệu Employee Data :floppy_disk:** |
| Trong Employee Data, bạn tạo hai bảng: `employees` và `login` để lưu trữ dữ liệu nhân viên và thông tin đăng nhập để truy cập cơ sở dữ liệu. |

| **Bảng: employees** :busts_in_silhouette: |
| - Bảng này được sử dụng để lưu trữ dữ liệu nhân viên. |
| - Nó bao gồm các trường như `employee_id`, `name`, `gender`, `dob` (ngày sinh), `address`, `email`, `phone`, `position`, và `role_id`. |
| - `employee_id` là một mã số định danh duy nhất cho mỗi nhân viên. |
| - Các trường trong bảng này lưu trữ thông tin về nhân viên, chẳng hạn như tên, giới tính, ngày sinh, địa chỉ, email, số điện thoại, vị trí, và `role_id`. |

| **Bảng: login** :key: |
| - Bảng này được sử dụng để quản lý thông tin đăng nhập. |
| - Nó bao gồm các trường như `username`, `password`, `id`, và `role_id`. |
| - Trường `username` lưu trữ tên người dùng được sử dụng để đăng nhập. |
| - Trường `password` lưu trữ mật khẩu tương ứng. |
| - Trường `id` có thể được sử dụng để khôi phục mật khẩu trong trường hợp người dùng quên thông tin tài khoản của họ. |
| - Trường `role_id` được sử dụng để quản lý quyền truy cập, phân biệt giữa quản trị viên và người dùng thông thường. :cop: |

| Những bảng này rất quan trọng để lưu trữ và quản lý thông tin nhân viên, cung cấp quyền truy cập an toàn vào cơ sở dữ liệu và quản lý quyền truy cập dựa trên vai trò. :lock: |

| **Tác Giả** :pencil2: Salamander :raised_hand: |
| Hi vọng rằng Readme này bao quát đầy đủ thông tin về ứng dụng quản lý nhân viên của bạn. :pray: :tada: |


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
2. Install MySQL and create the Employee Data database :package:
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

## Install MySQL and Create the "Employee Data" Database :floppy_disk:

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

4. **Create the "Employee Data" Database**:

   ```sql
   CREATE DATABASE Employee Data;
   ```
   ```sql
   USE Employee Data;
   ```
   ```sql
   CREATE TABLE login (
   id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   role_id INT
   );
   ```

   
### In the Employee Data Database :floppy_disk:

In Employee Data, you create two tables: `employees` and `login` to store employee data and login information for accessing the database.

**Table: employees** :busts_in_silhouette:

- This table is used to store employee data.
- It includes fields like `employee_id`, `name`, `gender`, `dob` (date of birth), `address`, `email`, `phone`, `position`, and `role_id`.
- The `employee_id` is a unique identifier for each employee.
- The fields in this table store information about the employees, such as their name, gender, date of birth, address, email, phone number, position, and role_id.

**Table: login** :key:

- This table is used for managing login credentials.
- It includes fields like `username`, `password`, `id`, and `role_id`.
- The `username` field stores the username used for login.
- The `password` field stores the corresponding password.
- The `id` field can be used for password retrieval in case a user forgets their account details.
- The `role_id` field is used for managing access permissions, differentiating between administrators and regular users. :cop:

These tables are crucial for storing and managing employee information, providing secure access to the database, and administering role-based access rights. :lock:


Hope this Readme covers all the information about your employee management application.:pray: :tada:
