// JavaScript source code
function sumAll() {
    var result = 0;  //�����Լ�
    if (arguments.length == 0) {
        result = (-999);

    } else {
        for (var idx in arguments) { //for (var idx =0; idx< arguments.length; idx++)
            result += arguments[idx];
        }
    }
    return result;
}




/*   var arr = [10, 20, 30]; �������Ҷ�.
       var sum = 0;
       for (var idx in arr) {  // for (var idx =0; idx < arr.length; idx++)
           sum += arr[idx];
       }
       alert(sum);  */