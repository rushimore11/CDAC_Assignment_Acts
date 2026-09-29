#include<iostream>
#include<math.h>
using namespace std;

//returns true if the number is prime otherwise return false
bool isPrime(int num){
    int counter = sqrt(num);  
    for(int i=2;i<=counter;i++){
       if(num%i==0){
         return false;
       }  
    }
    return true;
}

//returns addition of digits of a number
int findDigitAddition(int num){
   int sum=0;
   while(num>0){
     int d=num%10;
     sum+=d;
     num=num/10;
   } 
   return sum;
}

//calculates the factorial
int fact(int num){
   int f=1;
   for(int i=num ; i>1 ; i--){
       f=f*i;
   }    
   return f;
}

//calculate the table
 void printTable(int num){
 int table;
 for(int i=1; i<=10 ; i++){
     table = num*i;
     cout<<num<<" * " <<i<<" = "<<table<<endl;
  }
}

int main(){
   int choice=0,num,result,factorial;
   bool status;
   do{
   cout<<"1. Check prime\n2.Factorial\n3. printtable \n4. find addition of digits of a number\n5. exit\nchoice:";
   cin>>choice;
   switch(choice){
   case 1:
         cout<<"enter number"<<endl;
         cin>>num;
         status=isPrime(num);
         if(status){
             cout<<num <<" is prime"<<endl;
         }else{
             cout<<num<<" is not prime"<<endl;
         }
         break;
   case 2:
         // factorial function
	 cout<<"Enter the number:"<<endl;
	 cin>>num;
	 factorial= fact(num);
         cout<<"Factorial of "<<num<<" is : "<<factorial<<endl; 
         break;
   case 3:
         // print table function //output is 5*1=5  5*2=10 ... 5*10=50
	 cout<<"Enter a number : "<<endl;
	 cin>>num;
	 printTable(num);
         break;
   case 4:
         cout<<"enter number"<<endl;
         cin>>num;
         result=findDigitAddition(num);
	 cout<<"Digit addition is:"<<result<<endl;
         break;
   case 5: 
        cout<<"Thank you for using our code"<<endl;
   default:
         break;
   }  
   }while(choice!=5); 
   return 0;
}
