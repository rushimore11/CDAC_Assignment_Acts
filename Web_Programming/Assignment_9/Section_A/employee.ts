
type EmployeeGender = 'Male' | 'Female' | 'Other';
type EmployeeCity = 'Pune' | 'Mumbai' | 'Delhi';
type EmployeeState = 'Maharashtra' | 'Delhi NCR';
type EmployeeCountry = 'India' | 'USA';

type GetTaxFn = () => number;
type GetFullNameFn = () => string;

interface Employee {
    firstName: string;
    lastName: string;
    age: number;
    salary: number;
    city?: EmployeeCity;
    state?: EmployeeState;
    country: EmployeeCountry;
    geoLocation: [number, number];
    gender: EmployeeGender;
    email: string;                 
    getTax: GetTaxFn;
    getFullName: GetFullNameFn;
    dob: Date;
}

const employee: Employee = {
    firstName: "Rahul",
    lastName: "Sharma",
    age: 28,
    salary: 75000,
    city: "Pune",
    state: "Maharashtra",
    country: "India",
    geoLocation: [18.5204, 73.8567],
    gender: "Male",
    email: "rahul.sharma@cdac.in",
    getTax() {
        return this.salary * 0.1;
    },
    getFullName() {
        return `${this.firstName} ${this.lastName}`;
    },
    dob: new Date("1998-05-10")
};

console.log("Full Name:", employee.getFullName());
console.log("Tax:", employee.getTax());
console.log("DOB:", employee.dob.toDateString());

export {};