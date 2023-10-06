INSERT INTO article (title, content) VALUES('제목 1', '내용 1')
INSERT INTO article (title, content) VALUES('제목 2', '내용 2')
INSERT INTO article (title, content) VALUES('제목 3', '내용 3')

INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 1', '내용 1', NOW(), NOW()+1)
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 2', '내용 2', NOW(), NOW()+2)
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 3', '내용 3', NOW(), NOW()+3)