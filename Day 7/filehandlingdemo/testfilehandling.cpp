#include<iostream>
#include <fstream>
#include<cstring>
using namespace std;
class Person{
    int pid;
    char name[50];
    public:
        Person(){
            pid=0;
            name[0]='\0';
        }
        Person(int id,const char nm[]){
            pid=id;
            strcpy(name,nm);

        }
        ~Person(){}
        void display(){
            cout<<pid<<","<<name<<endl;
            cout<<"------------------"<<endl;
        }

};

//serialize data
void writedata(const char * filename,Person parr[],int size){
    ofstream outfile(filename,ios::binary);
    if(!outfile){
        cerr<<"Error opening file for writing"<<endl;
        return;
    }
    for(int i=0;i<size;i++){
        outfile.write(reinterpret_cast<char*>(&parr[i]),sizeof(parr[i]));
        //outfile<<parr[i].getId()<<","<<parr[i].getName();
    }
    outfile.close();
    cout<<"data written in "<<filename<<endl;

}

//deserializdedata

void readdata(const char* fname){
    ifstream infile(fname);
    if(!infile){
        cout<<"Error opening file "<<endl;
        return;
    }
    Person p;
    cout<<"Reading data from file"<<endl;
    while (infile.read(reinterpret_cast<char*>(&p), sizeof(p))) {
        //parr[count++]=p;
        p.display();
    }
        infile.close();
    
        //infile>>id>>name


}

int main(){
   Person p1(12,"xxxx"),p2(23,"yyyyy"),p3(24,"zzzz");
   Person parr[]={p1,p2,p3};

   const char* filename="empdata.txt";
   writedata(filename,parr,3);
   readdata(filename);
   return 0;
    
}
