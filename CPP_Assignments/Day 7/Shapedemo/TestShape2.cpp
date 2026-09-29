#include <iostream>
#include "Shape.h"
#include "Rectangle.h"
#include "ShapeService.h"

using namespace std;

int main(){
    Shape *sArr[100];
    int count = 0, id;
    int choice = 0;
    double area ,perimeter;
    //readdata("shapedata.txt",sArr,count);
    cout<<count;
    do{
      cout << "1. add new shape\n 2.calculate area by id\n 3.calculate perimeter by id\n ";
      cout << "4. display count of given type\n 5. display all\n 6.count all types\n 0. exit\n";
      cout << "------------------" << endl;
      cout<<"Enter Choice : "<< endl;
      cin >> choice;
      int subChoice = 0;
      int ch=0;
      bool status = false;
      switch(choice){
        case 1:
            // add new shape
            cout << "1. rectangle\n 2.circle\n 3. triangle\n";
            cin >> subChoice;
            status = ShapeService::addNewShape(sArr , count, subChoice);
            if(status){
                cout << "Shape added..." << endl;
            }
            else{cout<<"Enter Choice"<< choice << endl;
                cout << "Not added..."<< endl;
            }
            break;
        case 2:
            // 2.calculate area by id
            cout << "enter id : ";
            cin >> id;
            area = ShapeService::findAreaById(sArr, count, id);
            cout << "Area : " << (area > 0 ? area  : -1) << endl;
            break;
        case 3:
            // calculate perimeter by i,d
            cout << "enter id : ";
            cin >> id;
            perimeter = ShapeService::findPerimeterById(sArr, count, id);
            cout << "Perimeter : " << (perimeter > 0 ? perimeter  : -1) << endl;
            break;
        case 4:
            // 4. display count of given type
            // ShapeService::countByType(s, count, type);

            cout<<"1.Rectangle\n2.Circle \n3.Triangle\n";
            cin>>ch;
            ShapeService:: countByType(sArr, count, ch);
            break;
        case 5:
            // display all shape
            ShapeService::displayAll(sArr, count);
            break;
        case 6:
            ShapeService::countAll(sArr, count);
            break;
        case 0:
            // add new shape
           // writedata("shapedata.txt",sArr)
            cout << "thank you....!" << endl;
            break;
        default:
            cout << "Wrong choice\n";
      }
      
    }while(choice != 0);
    return 0;
}