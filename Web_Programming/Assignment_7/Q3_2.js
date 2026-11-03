async function squareArray(arr){
    return arr.map(num => num* num);

}


const numbers = [2, 4, 6, 8];

const result = await squareArray(numbers);
console.log(result)