CREATE TABLE project(
ID INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(100),
guts_paper INT,
cover_paper INT,
Pages INT(20),
Print_Format VARCHAR(50),
height DOUBLE(3,3),
width DOUBLE(3,3),
Binding_Style VARCHAR(30),
Additional_Features VARCHAR(400),
Description VARCHAR(400),
sale_price DOUBLE(4,2),
cost_to_produce FLOAT(4,projectproject2),

CONSTRAINT guts_paper FOREIGN KEY (guts_paper) REFERENCES paper(id),
CONSTRAINT cover_paper FOREIGN KEY (cover_paper) REFERENCES paper(id)
);