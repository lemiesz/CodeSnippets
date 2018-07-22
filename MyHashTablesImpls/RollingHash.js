var testString = "World";
var searchString = "Hello my beautiful world"



var hash = (input) => {
    return input % 113;
}

var prehash = (input) => {
    var sum = 0;
    for(var i = 0; i < input.length; i++) {
        sum += input.charCodeAt(i);
    }
    return sum;
}

var search = (test, search) => {
    var searchCurr = search.substring(0, test.length);
    var pHashTest = 

}

console.log(prehash(testString));