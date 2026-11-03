
type Gender = 'Male' | 'Female' | 'Other';
type Country = 'India' | 'USA';
type City = 'Bangalore' | 'Hyderabad';
type State = 'Karnataka' | 'Telangana';

interface Employee {
    firstName: string;
    lastName: string;
    age: number;
    salary: number;
    city?: City;
    state?: State;
    country: Country;
    geoLocation: [number, number];
    gender: Gender;
    email: string;
    getTax: () => number;
    getFullName: () => string;
    dob: Date;
}

type ProgrammingLanguage = 'TypeScript' | 'JavaScript' | 'Java' | 'Python';

interface Engineer {
    experience: number;
    programmingLanguage: ProgrammingLanguage[];
}


type ITEngineer = Employee & Engineer;

const itEngineer: ITEngineer = {
    firstName: "Neha",
    lastName: "Gupta",
    age: 27,
    salary: 110000,
    city: "Bangalore",
    state: "Karnataka",
    country: "India",
    geoLocation: [12.9716, 77.5946],
    gender: "Female",
    email: "neha.gupta@cdac.in",

    getTax(): number {
        return this.salary * 0.15;
    },
    getFullName(): string {
        return `${this.firstName} ${this.lastName}`;
    },
    dob: new Date("1999-03-20"),
    experience: 4,
    programmingLanguage: ['TypeScript', 'JavaScript', 'Python']
};

console.log("IT Engineer Name:", itEngineer.getFullName());
console.log("Experience:", itEngineer.experience, "Years");
console.log("Languages Known:", itEngineer.programmingLanguage);