// calculator.js

function add(a, b) {
    return a + b;
}

function subtract(a, b) {
    return a - b;
}

function multiply(a, b) {
    return a * b;
}

function divide(a, b) {
    if (b === 0) {
        return "Error: Division by zero is not allowed.";
    }
    return a / b;
}

const num1 = 20;
const num2 = 5;

console.log("=== Node.js Calculator ===");
console.log(`Operand 1: ${num1}`);
console.log(`Operand 2: ${num2}\n`);

console.log(`Addition (+): ${num1} + ${num2} = ${add(num1, num2)}`);
console.log(`Subtraction (-): ${num1} - ${num2} = ${subtract(num1, num2)}`);
console.log(`Multiplication (*): ${num1} * ${num2} = ${multiply(num1, num2)}`);
console.log(`Division (/): ${num1} / ${num2} = ${divide(num1, num2)}`);