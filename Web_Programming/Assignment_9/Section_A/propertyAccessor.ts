
function getPropertyValue<T, K extends keyof T>(obj: T, key: K): T[K] {
    return obj[key];
}

// Test object
const sampleUser = {
    id: 1,
    username: "john_doe",
    isActive: true
};

const userId = getPropertyValue(sampleUser, "id");
const userName = getPropertyValue(sampleUser, "username");

console.log("User ID:", userId);
console.log("Username:", userName);