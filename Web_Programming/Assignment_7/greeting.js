

function greet(){
const currentHour = new Date().getHours();
  if (currentHour < 12) {
    return "Good morning";
  } else if (currentHour< 17) {
    return "Good Afternoon";
  } else {
    return "Good Evening";
  }
}
module.exports = greet;