#include<iostream>
using namespace std;
#ifndef STUDENT_H
#define STUDENT_H

class Student{
    private:
        int sid;
        char *sname;
        int age;
        double m1,m2,m3;

    public:
        //default constructor
        Student();

        //parametrized constructor
       Student(int, const char*,int,double ,double ,double);

            //setters
            void setSid(int);
            void setAge(int);
            void setSname(const char *);
            void setm1(double);
            void setm2(double);
            void setm3(double);

            //getters
            int getSid();
            int getAge();
            char *getSname();
            double getm1();
            double getm2();
            double getm3();

            //calculate percentage
            double calculatePercentage();

            //display function
            void display();

            //destructor
            ~Student();
};

#endif       