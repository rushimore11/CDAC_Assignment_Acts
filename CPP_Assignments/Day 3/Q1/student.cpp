//~1. Create a class Student to store sid, sname, age, m1,m2,m3
//Write default constructor, parametrised constructor setter getter methods, display method
//Add method calculate_percentage which returns average marks for m1,m2,m3
//Create Student.h, student.cpp (Define all functions), TestStudent.cpp (write main method )
//	In main method create 3 objects
//	1. By using default constructor,
//	2. By using parametrised constructor
//		3. By using posters




#include "Student.h"
#include<iostream>
#include<cstring>
using namespace std;

//default constructor
Student::Student(){
    sid =0;
    sname = new char[1];
    sname[0] = '\0';
    age=0;
    m1=0;
    m2=0;
    m3=0;
}

//parametrized constructor
Student::Student(int id, const char* name, int a, double marks1, double marks2 , double marks3){
      sid=id;
      sname = new char[strlen(name)+1];
      strcpy(sname,name);
      age = a;
      m1=marks1;
      m2=marks2;
      m3=marks3;
}

//functions for setters
void Student::setSid(int id){
      sid=id;
    }

void Student::setSname(const char *name){
      delete[] sname;
      sname=new char[strlen(name)+1];
      strcpy(sname,name);
    }

void Student::setAge(int a){
      age=a;
    }

void Student::setm1(double marks1){
      m1=marks1;
    }

void Student::setm2(double marks2){
      m2=marks2;
    }

void Student::setm3(double marks3){
      m3=marks3;
    }

 //functions for getters
int Student::getSid(){
      return sid;
    }

char *Student::getSname(){
      return sname;
    }

int Student::getAge(){
      return age;
   }
  
double Student::getm1(){
     return m1;
   }

double Student::getm2(){
     return m2;
   }

double Student::getm3(){
     return m3;
   }

//function to calculate percentage of marks
double Student::calculatePercentage(){
     return (m1+m2+m3)/3;
   }

//display function
void Student::display(){
     cout<<"Student Id : "<<sid<<endl;
     cout<<"Student Name : "<<sname<<endl;
     cout<<"Student Age : "<<age<<endl;
     cout<<"Marks1 : "<<m1<<endl;
     cout<<"Marks2 : "<<m2<<endl;
     cout<<"Marks3 : "<<m3<<endl;
     cout<<"Percentage of the students : " <<calculatePercentage()<<"%"<<endl;
   }

Student::~Student(){
    delete[] sname;
   }