DROP TABLE IF EXISTS USER_KBX;

CREATE TABLE USER_KBX(
  user_id NUMBER PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL
);

DROP TABLE IF EXISTS USER_VIEW;
  
CREATE TABLE USER_VIEW (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  viewer_id NUMBER NOT NULL,
  viewed_id NUMBER NOT NULL,
  view_date TIMESTAMP NOT NULL
);

ALTER TABLE USER_VIEW
ADD FOREIGN KEY (VIEWER_ID) 
REFERENCES USER_KBX(USER_ID);

ALTER TABLE USER_VIEW
ADD FOREIGN KEY (VIEWED_ID)
REFERENCES USER_KBX(USER_ID);

INSERT INTO USER_KBX (user_id, first_name, last_name) VALUES
  ('111111', 'Aliko', 'Dangote'),
  ('222222', 'Bill', 'Gates'),
  ('333333', 'Folrunsho', 'Alakija'),
  ('444444', 'Matt', 'Cooler'),
  ('555555', 'Adam', 'Baker'),
  ('666666', 'Tom', 'Ricer');