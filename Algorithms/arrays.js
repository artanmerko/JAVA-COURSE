// Function to push a value to the front of an array
function pushFront(arr, val) {
    for (let i = arr.length; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = val;
    return arr;
  }
  
  // Function to pop the value from the front of an array
  function popFront(arr) {
    if (arr.length === 0) return undefined;
    const frontValue = arr[0];
    for (let i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr.pop();
    console.log(frontValue + " returned");
    console.log(arr);
    return frontValue;
  }
  
  // Function to insert a value at a given index in an array
  function insertAt(arr, index, val) {
    for (let i = arr.length; i > index; i--) {
      arr[i] = arr[i - 1];
    }
    arr[index] = val;
    return arr;
  }
  
  // Function to remove a value at a given index in an array
  function removeAt(arr, index) {
    if (index < 0 || index >= arr.length) return undefined;
    const removedValue = arr[index];
    for (let i = index; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr.pop();
    console.log(removedValue + " returned");
    console.log(arr);
    return removedValue;
  }
  
  // Function to swap pairs of values in an array
  function swapPairs(arr) {
    for (let i = 0; i < arr.length - 1; i += 2) {
      const temp = arr[i];
      arr[i] = arr[i + 1];
      arr[i + 1] = temp;
    }
    return arr;
  }
  
  // Function to remove duplicate values from a sorted array
  function removeDupes(arr) {
    let uniqueIndex = 0;
    for (let i = 1; i < arr.length; i++) {
      if (arr[i] !== arr[uniqueIndex]) {
        uniqueIndex++;
        arr[uniqueIndex] = arr[i];
      }
    }
    arr.length = uniqueIndex + 1;
    return arr;
  }
  
  // Testing the functions
  console.log(pushFront([5, 7, 2, 3], 8));
  console.log(popFront([0, 5, 10, 15]));
  console.log(insertAt([100, 200, 5], 2, 311));
  console.log(removeAt([1000, 3, 204, 77], 1));
  console.log(swapPairs([1, 2, 3, 4]));
  console.log(removeDupes([-2, -2, 3.14, 5, 5, 10]));
  