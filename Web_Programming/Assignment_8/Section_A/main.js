
import { greet } from './greeting.js';
import readline from 'readline';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Enter time in HH:MM format (24-hour, e.g., 14:30): ', (input) => {
  const parts = input.split(':');
  const hour = parseInt(parts[0], 10);
  const minute = parseInt(parts[1], 10);

  if (isNaN(hour) || isNaN(minute) || hour < 0 || hour > 23 || minute < 0 || minute > 59) {
    console.log('Invalid time format. Please use valid HH:MM (0-23 hours).');
  } else {
    const greetingMessage = greet(hour, minute);
    console.log(`${greetingMessage}! (Time provided: ${hour}:${minute.toString().padStart(2, '0')})`);
  }

  rl.close();
});