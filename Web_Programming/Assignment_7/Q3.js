  async function sum(numbers){
    let sum=0;
    for(let i=0;i<numbers.length;i++){
        sum=sum+numbers[i];
    }
    return sum;
}

const numbers = [2, 4, 6, 8];

const result = await sum(numbers);
console.log(result)