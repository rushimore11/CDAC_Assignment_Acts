#include<iostream>
using namespace std;

class MathUtils{
  private: 
     static int factorial(int num){
         // calculate factorial
	 int fact = 1;
	 for(int i=num ; i>1; i--){ 
              fact = fact * i;
	 }
         return fact;
     }   
  public:
       //this function can be called by using classname::functionname
       //it doesnot receive this pointer
       //static function can use only static members, to use nonstatic member you need to create object and then use it
       static int addition(int n1,int n2){

             return n1+n2;
       } 
       
       static int combination(int n,int r){
         int result;
         result=factorial(n)/(factorial(r)*factorial(n-r));
         return result;
       }

};

int main(){
   int num1=20,num2=30,result, n, r;
   result=MathUtils::addition(num1,num2);
   cout<<"anaswer : "<<result<<endl;
   cout<<"answer: "<<MathUtils::addition(num1,num2)<<endl;
   /// todo : call combination function here
   cout<<"Enter the value of n"<<endl;
   cin>>n;
   cout<<"Enter the value for r"<<endl;
   cin>>r;
   cout<<"Combination : "<<MathUtils::combination(n,r)<<endl;
   return 0;
}
