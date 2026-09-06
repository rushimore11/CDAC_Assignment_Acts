#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "Shape.h"

class Triangle : public Shape{
    private : 
    double height;
    double base;

    public:
    Triangle(char*color,int id ,double height, double base ) ;
    double calculateArea() const override;
    double calculatePerimeter() const override;
    void display();
    ~Triangle();

};






#endif