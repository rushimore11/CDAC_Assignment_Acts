const fs =require('fs');

try {
  const data =fs.readFileSync('numbers.txt', 'utf8');
   const numbers =data.split(',');
  let sum = 0;
   for (let i = 0;i<numbers.length; i++) {

    sum += Number(numbers[i].trim());

  }

  fs.writeFileSync('result.txt', sum.toString());
  
  console.log(sum);

} catch (err) {

  console.error("An error occurred:",err.message);

}
