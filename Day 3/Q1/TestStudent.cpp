#include<iostream>
#include "Student.h"
using namespace std;

int main(){
Student s1;

//object using default constructor
s1.setSid(1);
 s1.setSname("Rushikesh");
 s1.setAge(22);
 s1.setm1(95);
 s1.setm2(85);
 s1.setm3(76);

s1.display();

//object using parameterized constructor
Student s2(2,"Vishvajit",22,91,78,87);
s2.display();

//object using pointers
Student * s3 = new Student(3,"abc",24, 65,87,95);
s3->display();
delete s3;
return 0;
}