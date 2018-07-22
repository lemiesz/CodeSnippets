var binarySearch = (sortedArray, needle) => {
    if(sortedArray.length === 0) {
        return -1;
    }
    var m = sortedArray.length / 2;

    var currentValue = sortedArray[m];

    if(currentValue === needle) {
        return m;
    } else if (needle < currentValue && m != 0) {
        return binarySearch(sortedArray.slice(0, m - 1), needle);
    } else if (needle > currentValue && m != sortedArray.length) {
        return binarySearch(sortedArray.slice(m + 1, sortedArray.length), needle);
    }
}
console.log("well0");

var list = [];
for(var i = 0; i < 20000; i++) {
    list.push(i);
}

console.log(list);

var result = binarySearch(list, 3);
console.log(result);
