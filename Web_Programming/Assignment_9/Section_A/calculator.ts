
type CalculatorFn = (a: number, b: number) => number;

const sum: CalculatorFn = (a: number, b: number): number => {
    return a + b;
};


const sub: CalculatorFn = (a: number, b: number): number => {
    return a - b;
};

console.log("Sum (20 + 10):", sum(20, 10)); 
console.log("Sub (20 - 10):", sub(20, 10)); 