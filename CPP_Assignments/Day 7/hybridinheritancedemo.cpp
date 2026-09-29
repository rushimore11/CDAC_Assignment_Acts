#include<iostream>
using namespace std;

class A{
   public:
     A(){
        cout<<"in A constructor"<<endl;
      }
      ~A(){
        cout<<"in A destructor"<<endl;
      }

};
class B:virtual public A{
    public:
      B(){
        cout<<"in B constructor"<<endl;
      }
      ~B(){
        cout<<"in B destructor"<<endl;
      }
};

class C:virtual public A{
    public:
      C(){
        cout<<"in C constructor"<<endl;
      }
      ~C(){
        cout<<"in c destructor"<<endl;
      }
};

class D:public B,public C{
    public:
      D(){
        cout<<"in D constructor"<<endl;
      }
      ~D(){
        cout<<"in D destructor"<<endl;
      }

};

int main(){
    D ob;
   // D *ob1=new D();
   // delete ob1;
    return 0;
}