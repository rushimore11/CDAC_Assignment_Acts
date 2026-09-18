#ifndef SHAPE_SERVICE_H
#define SHAPE_SERVICE_H

#include <iostream>
#include "Circle.h"
#include "Rectangle.h"
#include "Triangle.h"

using namespace std;

class ShapeService{
    static Shape *sarr[100];
    public:
        static bool addNewShape(Shape **s, int &count, int ch){
            char color[10]; 
            int id;

            double len, br, radius, height, base;
            cout << "enter color : " ;
            cin >> color;
            cout << "Enter id : ";
            cin >> id;
            if(ch == 1){
               cout << "enter len : ";
               cin >> len;
               cout << "enter breadth : ";
               cin >> br;
               s[count++] = new Rectangle(id, color, len, br);
            }
            else if(ch == 2){
               cout << "enter radius : ";
               cin >> radius;
               s[count++] = new Circle(id, color, radius);
            }
            else if(ch==3){
                cout<<"enter base:"<<endl;
                cin>> base;
                cout<<"enter height :"<<endl;
                cin>> height;
                s[count++]= new Triangle(color, id, height,base);
            }
            else 
             cout<<"invalid choice"<<endl;
            return true;
        }

        static void displayAll(Shape **s, int count){
            for(int i = 0; i < count; ++i){
                s[i]->display();
            }
        }

        static int searchById(Shape **s, int count, int id){
            for(int i = 0; i <count; ++i){
                if(s[i]->getId() == id){
                    return i;
                }
            }
            return -1;
        }
        
        static double findAreaById(Shape **s, int count, int id){
            int pos = searchById(s, count, id);
            if(pos == -1) return 0;
            return s[pos]->calculateArea();
        }

        static double findPerimeterById(Shape **s, int count, int id){
            int pos = searchById(s, count, id);
            if(pos == -1) return 0;
            return s[pos]->calculatePerimeter();
        }

        static void countAll(Shape **s, int count){
            int tCount =0, rCount=0, cCount=0;
            for(int i =0; i < count; ++i){
                if(dynamic_cast<Rectangle* >(s[i])) rCount++;
                else if(dynamic_cast<Circle* >(s[i])) cCount++;
                else tCount++;
            }
            cout << "Triangle count: " << tCount << endl;
            cout << "Rectangle count: " << rCount << endl;
            cout << "Circle count: " << cCount << endl;
        }

        static void countByType(Shape **s, int count, int ch){
            int tCount =0, rCount=0, cCount=0;

            for(int i =0; i < count; ++i){
                if(dynamic_cast<Rectangle* >(s[i])) rCount++;
                else if(dynamic_cast<Circle* >(s[i])) cCount++;
                else tCount++;
            }

            if(ch==1)
                cout<<"Rectangle count :"<<rCount<<endl;
            else if(ch==2)
                cout<<"Circle count :"<<cCount<<endl;
            else
               cout<<"Triangle Count"<<tCount<<endl;
           }



};

#endif