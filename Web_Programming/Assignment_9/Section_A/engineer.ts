// Create the type for programming languages (Q6)
type ProgrammingLanguage = 'TypeScript' | 'JavaScript' | 'Java' | 'Python' | 'C++';

interface Engineer {
    experience: number;
    programmingLanguage: ProgrammingLanguage[]; // Array of language union types (Q6)
}

const engineer: Engineer = {
    experience: 3,
    programmingLanguage: ['TypeScript', 'Java', 'Python']
};

console.log("Experience:", engineer.experience);
console.log("Programming Languages:", engineer.programmingLanguage);

export {};