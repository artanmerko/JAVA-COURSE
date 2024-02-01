// Function to remove blanks from a string
function removeBlanks(str) {
    let result = "";
    for (let i = 0; i < str.length; i++) {
      if (str[i] !== " ") {
        result += str[i];
      }
    }
    return result;
  }
  
  // Function to get digits from a string and return the integer
  function getDigits(str) {
    let result = "";
    for (let i = 0; i < str.length; i++) {
      if (!isNaN(str[i])) {
        result += str[i];
      }
    }
    return Number(result);
  }
  
  // Function to create an acronym from a string
  function acronym(str) {
    let words = str.split(" ");
    let acronym = "";
    for (let word of words) {
      if (word.length > 0) {
        acronym += word[0].toUpperCase();
      }
    }
    return acronym;
  }
  
  // Function to count non-space characters in a string
  function countNonSpaces(str) {
    let count = 0;
    for (let i = 0; i < str.length; i++) {
      if (str[i] !== " ") {
        count++;
      }
    }
    return count;
  }
  
  // Function to remove shorter strings from an array
  function removeShorterStrings(arr, minLength) {
    let result = [];
    for (let str of arr) {
      if (str.length >= minLength) {
        result.push(str);
      }
    }
    return result;
  }
  
  // Testing the functions
  console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "));
  console.log(getDigits("abc8c0d1ngd0j0!8")); 
  console.log(acronym(" there's no free lunch - gotta pay yer way. "));
  console.log(countNonSpaces("Honey pie, you are driving me crazy"));
  console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4));
  