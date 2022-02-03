# e-Pocket
# Digital wallet
- e-Pocket is cloud based document storage where you can store your unlimited document.
- You can share document over the internet.
- You can put privacy in document before sharing your document to your friend.
- You can compress your document.
- You can convert your pdf to word , vice versa.


**Database Tables :**

> There Are Eight Tables
1. city

| Field     | Type     | Null | Key | Default | Extra |
|-----------|----------|------|-----|---------|-------|
| city_id   | int      | NO   | PRI | NULL    |       |
| city_name | char(20) | YES  |     | NULL    |       |
| state_id  | int      | YES  | MUL | NULL    |       |

2. country

| Field        | Type     | Null | Key | Default | Extra |
|--------------|----------|------|-----|---------|-------|
| country_code | int      | NO   | PRI | NULL    |       |
| country_name | char(20) | YES  |     | NULL    |       |

3. state

| Field        | Type     | Null | Key | Default | Extra |
|--------------|----------|------|-----|---------|-------|
| state_id     | int      | NO   | PRI | NULL    |       |
| state_name   | char(20) | YES  |     | NULL    |       |
| country_code | int      | YES  | MUL | NULL    |       |

4. user_master

| Field     | Type      | Null | Key | Default | Extra |
|-----------|-----------|------|-----|---------|-------|
| uid       | int       | NO   | PRI | NULL    |       |
| firstname | char(20)  | YES  |     | NULL    |       |
| lastname  | char(20)  | YES  |     | NULL    |       |
| phone_num | char(15)  | YES  |     | NULL    |       |
| city_id   | int       | YES  | MUL | NULL    |       |
| email     | char(40)  | YES  | MUL | NULL    |       |
| gender    | int       | YES  |     | NULL    |       |
| que       | char(100) | YES  |     | NULL    |       |
| ans       | char(100) | YES  |     | NULL    |       |


5. login_master

| Field    | Type     | Null | Key | Default | Extra |
|----------|----------|------|-----|---------|-------|
| email    | char(40) | NO   | PRI | NULL    |       |
| password | char(40) | YES  |     | NULL    |       |
| status   | int      | YES  |     | NULL    |       |


6. document

| Field | Type | Null | Key | Default | Extra |
| ----- | ---- | ---- |---- | ------- | ----- |
| doc_id            | char(40) | NO   | PRI | NULL    |       |
| uid               | int      | YES  | MUL | NULL    |       |
| doc_type          | char(10) | YES  |     | NULL    |       |
| doc_size          | int      | YES  |     | NULL    |       |
| doc_upload_time   | datetime | YES  |     | NULL    |       |
| doc_location      | char(40) | YES  |     | NULL    |       |
| doc_public_url    | char(40) | YES  |     | NULL    |       |
| doc_last_modified | datetime | YES  |     | NULL    |       |
| doc_file_name     | char(40) | YES  |     | NULL    |       |

7. pass_recovery

| Field    | Type     | Null | Key | Default | Extra |
|----------|----------|------|-----|---------|-------|
| rec_id   | int      | NO   | PRI | NULL    |       |
| rec_que  | char(80) | YES  |     | NULL    |       |
| rec_pass | char(50) | YES  |     | NULL    |       |
| rec_time | datetime | YES  |     | NULL    |       |
| email    | char(40) | YES  | MUL | NULL    |       |

8. email_verification

| Field             | Type     | Null | Key | Default | Extra |
|-------------------|----------|------|-----|---------|-------|
| email             | char(40) | YES  |     | NULL    |       |
| verification_code | char(40) | YES  |     | NULL    |       |
| creation_time     | datetime | YES  |     | NULL    |       |
| verifiaction_time | datetime | YES  |     | NULL    |       |

