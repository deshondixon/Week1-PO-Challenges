function oddishOrEvenish(num) {
    const digitSum = num.toString().split('').reduce((sum, digit) => sum + parseInt(digit), 0);
    return digitSum % 2 === 0 ? "Evenish" : "Oddish";
}

console.log(oddishOrEvenish(60));
console.log(oddishOrEvenish(43));
