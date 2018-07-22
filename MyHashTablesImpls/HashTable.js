export class HashTable {

    static default_hash(item) {
        var itemString = JSON.stringify(item);
        var sum = 0;
        for(var i in itemString) {
            sum = sum + itemString.charCodeAt(i);
        }
        return sum % 100;
    }

    constructor(hashFunction) {
        this.dictionary = Array(100);
        this.hash = hashFunction ? hashFunction : HashTable.default_hash;
    }

    insert(key, value) {
        var currentHash = this.hash(key);
        if(!this.dictionary[currentHash]) {
            this.dictionary[currentHash] = new Set();
            this.dictionary[currentHash].add({key: key, value: value});
        } else {
            this.dictionary[currentHash].add({key: key, value: value});
        }
    }

    
    delete(key, value) {
        var currentHash = this.hash(key);
        if(!this.dictionary[currentHash]) {
            console.log("Failed to delete item from dictionary, item does not exist");
            return false;
        } else {
            var deletedItem = this.dictionary[currentHash].delete({key: key, value: value});
            if(deleteItem === false) {
                console.log("Failed to delete item from dictioanry, item does not exist");
            }
        }
    }

    find(key) {
        var currentHash = this.hash(key);
        if(!this.dictionary[currentHash]) {
            console.log("returning null");
            return null;
        } else {
            var foundItem = null;
            this.dictionary[currentHash].forEach(chainItem => {
                if(chainItem.key === key) {
                    foundItem = chainItem; 
                }
            })
            return foundItem;
        }
    }

}

var table = new HashTable();
table.insert("Hello", "Hello World");
table.insert("hellow", "Hellow World");
console.log(table.find("hellow"));
// console.log(table);
