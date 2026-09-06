#include<iostream>

#include "Triangle.h"
using namespace std;

Triangle::Triangle(char* color,int id,double height , double base):Shape(color,id){
    this->height = height;
    this->base = base;
}

double Triangle::calculateArea() const{
    return (this->height * this->base)* 0.5;
}

double Triangle::calculatePerimeter()const{
    return this->base + this->height;
}

void Triangle :: display(){
    Shape::display();
    cout<<"height:"<<height<<endl;
    cout<<"base:"<<base<<endl;
}

Triangle::~Triangle(){
    cout<<"Triangle destructor is called..."<<endl;
}